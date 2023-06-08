package com.curriculum.studystar.Service.Impl.StudentServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Domain.Entity.Correction;
import com.curriculum.studystar.Domain.Entity.Question;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.QuestionAnswerVMResp;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.QuestionVMResp;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetCorrectionDetailsResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetCorrectionResponse;
import com.curriculum.studystar.Mapper.CorrectionMapper;
import com.curriculum.studystar.Mapper.CourseMapper;
import com.curriculum.studystar.Mapper.QuestionMapper;
import com.curriculum.studystar.Service.StudentService.CorrectionService;

@Service
public class CorrectionServiceImpl implements CorrectionService {
    @Autowired
    CorrectionMapper correctionMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired 
    CourseMapper courseMapper;

    @Override
    public GetCorrectionResponse GetWrongQuestion(String userId) {
        GetCorrectionResponse resp = new GetCorrectionResponse();
        ArrayList<Correction> wrongQuestion = correctionMapper.SelectCorrectionByUserId(userId);
        Integer total = 0;

        for(Correction item : wrongQuestion){
            String correctionId = item.getCorrectionId();
            String createTime = item.getCreateTime();

            String questionId = item.getQuestionId();
            Question question = questionMapper.SelectQuestionByQuestionId(questionId);
            Integer questionType = question.getQuestionType();
            String subjectName = courseMapper.SelectCourseByCourseId(question.getCourseId()).getCourseName();
            
            String title = question.getDescription();
            String shortTitle;
            if(title.length()<=10)
                shortTitle = title;
            else
                shortTitle = title.substring(0, 9) + "……";

            resp.addData(correctionId, questionType, createTime, subjectName, shortTitle);
            total++;
        }
        resp.setTotal(total);

        return resp;
    }

    @Override
    public GetCorrectionDetailsResponse GetCorrectionDetails(String correctionId) {
        GetCorrectionDetailsResponse resp = new GetCorrectionDetailsResponse();
        QuestionVMResp questionResp = new QuestionVMResp();
        QuestionAnswerVMResp questionAnswerResp = new QuestionAnswerVMResp();
        Correction correction = correctionMapper.SelectCorrectionByCorrectionId(correctionId);
        Question question = questionMapper.SelectQuestionByQuestionId(correction.getQuestionId());

        Integer questionType = question.getQuestionType();
        questionResp.setQuestionType(questionType);
        String subjectId = question.getCourseId();
        questionResp.setSubjectId(subjectId);
        String title = question.getDescription();
        questionResp.setTitle(title);
        String analyze = question.getAnalysis();
        questionResp.setAnalyze(analyze);
        Integer score = question.getScore();
        questionResp.setScore(score);
        Integer difficult = question.getDifficult();
        questionResp.setDifficult(difficult);
        String answer = question.getAnswer();
        String[] correctAnswer = answer.split("\\$");
        questionResp.setCorrectArray(correctAnswer);
        String options = question.getOptions();
        String[] items = options.split("@");
        for(String item : items){
            String[] questionItem = item.split("\\$");
            questionResp.addData(questionItem[0], questionItem[1]);
        }
        resp.setQuestionVM(questionResp);

        String[] myAnswer = correction.getWrongAnswer().split("\\$");
        questionAnswerResp.setContentArray(myAnswer);
        resp.setQuestionAnswerVM(questionAnswerResp);

        return resp;
    }
    
}
