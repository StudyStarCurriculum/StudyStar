package com.curriculum.studystar.Service.Impl.StudentServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Domain.Entity.Task;
import com.curriculum.studystar.Domain.Entity.TaskStatus;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListFinishedResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListResponse;
import com.curriculum.studystar.Mapper.CourseMapper;
import com.curriculum.studystar.Mapper.TaskMapper;
import com.curriculum.studystar.Mapper.TaskStatusMapper;
import com.curriculum.studystar.Service.StudentService.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TaskStatusMapper tsMapper;

    @Override
    public GetTestListResponse GetTestList(String subjectId, String userId) {
        GetTestListResponse resp = new GetTestListResponse();
        ArrayList<Task> task = taskMapper.SelectTaskByCourseId(subjectId);

        Integer total = 0;
        for(Task item : task){
            TaskStatus taskStatus = tsMapper.SelectTaskStatusByTaskIdAndUserId(item.getTaskId(),userId);
            if(taskStatus.getStatus() == 0){
                total += 1;
                String subjectName = courseMapper.SelectCourseByCourseId(item.getCourseId()).getCourseName();
                resp.addData(item.getTaskId(), item.getTaskName(), item.getScore(), item.getCreateTime(), subjectId, subjectName, item.getEndTime());
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
        for(Task item : task){
            TaskStatus taskStatus = tsMapper.SelectTaskStatusByTaskIdAndUserId(item.getTaskId(),userId);
            if(taskStatus.getStatus() != 0){
                total += 1;
                String subjectName = courseMapper.SelectCourseByCourseId(item.getCourseId()).getCourseName();
                resp.addData(item.getTaskId(),item.getTaskName(),taskStatus.getStatus(),item.getCreateTime(),subjectName,taskStatus.getTotalScore(),item.getScore());
            }
        }
        resp.setTotal(total);

        return resp;
    }
    
}
