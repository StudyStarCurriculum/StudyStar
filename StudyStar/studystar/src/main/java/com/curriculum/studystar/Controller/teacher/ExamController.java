package com.curriculum.studystar.Controller.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.EditExamRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.GetTaskDetailsResponse;
import com.curriculum.studystar.Service.Impl.TeacherServiceImpl.TeacherServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/admin/exam/paper")
public class ExamController {
    @Autowired
    HttpSession session;
    @Autowired
    TeacherServiceImpl teacherService;

    @RequestMapping("/edit")
    public RespCode EditExamPaper(@RequestBody EditExamRequest req){
        teacherService.EditExam(req);

        return RespCode.OK;
    }

    @RequestMapping("/select/{id}")
    public GetTaskDetailsResponse GetTaskDetails(@PathVariable String id){
        GetTaskDetailsResponse resp = new GetTaskDetailsResponse();

        resp = teacherService.GetTaskDetail(id);

        return resp;
    }
}
