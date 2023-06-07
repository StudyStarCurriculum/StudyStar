package com.curriculum.studystar.Service.Impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.Entity.Question;
import com.curriculum.studystar.Domain.Entity.Task;
import com.curriculum.studystar.Domain.Entity.TaskQuestion;
import com.curriculum.studystar.Domain.Entity.TaskQuestionSet;
import com.curriculum.studystar.Domain.Entity.TaskStatus;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.RequestData.AnswerReq;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.QuestionItem;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.QuestionResp;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.QuestionSetResp;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListFinishedResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.StartTestResponse;
import com.curriculum.studystar.Mapper.AnswerMapper;
import com.curriculum.studystar.Mapper.CorrectionMapper;
import com.curriculum.studystar.Mapper.CourseMapper;
import com.curriculum.studystar.Mapper.QuestionMapper;
import com.curriculum.studystar.Mapper.TaskMapper;
import com.curriculum.studystar.Mapper.TaskQuestionMapper;
import com.curriculum.studystar.Mapper.TaskQuestionSetMapper;
import com.curriculum.studystar.Mapper.TaskStatusMapper;
import com.curriculum.studystar.Service.StudentService.TaskService;
import com.curriculum.studystar.Utils.CurrentTimeUtil;
import com.curriculum.studystar.Utils.RandomUID;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TaskStatusMapper tsMapper;
    @Autowired
    TaskQuestionMapper tqMapper;
    @Autowired
    TaskQuestionSetMapper tqsMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    AnswerMapper answerMapper;
    @Autowired
    CorrectionMapper correctionMapper;

    @Override
    public GetTestListResponse GetTestList(String subjectId, String userId) {
        GetTestListResponse resp = new GetTestListResponse();
        ArrayList<Task> task = taskMapper.SelectTaskByCourseId(subjectId);

        Integer total = 0;
        for (Task item : task) {
            TaskStatus taskStatus = tsMapper.SelectTaskStatusByTaskIdAndUserId(item.getTaskId(), userId);
            if (taskStatus.getStatus() == 0) {
                total += 1;
                String subjectName = courseMapper.SelectCourseByCourseId(item.getCourseId()).getCourseName();
                resp.addData(item.getTaskId(), item.getTaskName(), item.getScore(), item.getCreateTime(), subjectId,
                        subjectName, item.getEndTime());
            }
        }
        resp.setTotal(total);
        return resp;
    }

    @Override
    public GetTestListFinishedResponse GetTestListFinished(String subjectId, String userId) {
        GetTestListFinishedResponse resp = new GetTestListFinishedResponse();
        ArrayList<Task> task = taskMapper.SelectTaskByCourseId(subjectId);

        Integer total = 0;
        for (Task item : task) {
            TaskStatus taskStatus = tsMapper.SelectTaskStatusByTaskIdAndUserId(item.getTaskId(), userId);
            if (taskStatus.getStatus() != 0) {
                total += 1;
                String subjectName = courseMapper.SelectCourseByCourseId(item.getCourseId()).getCourseName();
                resp.addData(item.getTaskId(), item.getTaskName(), taskStatus.getStatus(), item.getCreateTime(),
                        subjectName, taskStatus.getTotalScore(), item.getScore());
            }
        }
        resp.setTotal(total);

        return resp;
    }

    @Override
    public StartTestResponse StartTest(String taskId) {
        StartTestResponse resp = new StartTestResponse();
        Task task = taskMapper.SelectTaskByTaskId(taskId);
        resp.setName(task.getTaskName());
        resp.setSuggestTime("120min");
        resp.setScore(task.getScore());
        ArrayList<TaskQuestionSet> sets = tqsMapper.SelectQuestionSetByTaskId(taskId);

        Integer questionOrder = 0;
        for (TaskQuestionSet set : sets) {
            QuestionSetResp respSet = new QuestionSetResp();
            respSet.setName(set.getTitle());
            ArrayList<TaskQuestion> taskQuestions = tqMapper.SelectTaskQuestionBySetId(set.getTaskQuestionSetId());

            for (TaskQuestion taskQuestion : taskQuestions) {
                questionOrder++;
                Question question = questionMapper.SelectQuestionByQuestionId(taskQuestion.getQuestionId());
                String options = question.getOptions();
                String[] opts = options.split("@");
                ArrayList<QuestionItem> items = new ArrayList<QuestionItem>();

                for (String option : opts) {
                    String[] temp = option.split("\\$");
                    items.add(new QuestionItem(temp[0], temp[1]));
                }

                QuestionResp respQuestion = new QuestionResp(question.getQuestionId(), question.getQuestionType(),
                        question.getDescription(), items, questionOrder);
                respSet.addData(respQuestion);
            }
            resp.addData(respSet);
        }

        return resp;
    }

    @Override
    public RespCode SubmitTest(List<AnswerReq> req, String userId, String taskId) {
        boolean isDone = true;
        Integer totalScore = 0;
        for (AnswerReq item : req) {
            String questionId = item.getQuestionId();
            String[] answerArray = item.getContentArray();
            String answer = new String();
            Integer myScore = 0;
            Integer state = -1;
            Question question = questionMapper.SelectQuestionByQuestionId(questionId);

            for (String s : answerArray) {
                answer += s;
            }

            if (question.getQuestionType() < 4) {
                if (!question.getAnswer().equals(answer)) {
                    state = 0;
                    myScore = 0;
                    correctionMapper.InsertCorrectionRecord(RandomUID.getRandomUID(), CurrentTimeUtil.getCurrnetTime(),
                            userId, question.getQuestionId(), answer);
                } else {
                    state = 1;
                    myScore = question.getScore();
                    totalScore += myScore;
                }
            } else {
                isDone = false;
            }
            answerMapper.InsertAnswerRecord(RandomUID.getRandomUID(), answer, myScore, state, userId, questionId,
                    taskId);
        }
        if (isDone) {
            tsMapper.UpdateTaskStatus(CurrentTimeUtil.getCurrnetTime(), totalScore, 2, userId, taskId);
        } else {
            tsMapper.UpdateTaskStatus(CurrentTimeUtil.getCurrnetTime(), 0, 1, userId, taskId);
        }

        return RespCode.OK;
    }

}
