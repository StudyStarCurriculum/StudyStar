package com.curriculum.studystar.Controller.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.AnswerListRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.AnswerListResponse;
import com.curriculum.studystar.Service.TeacherService.TeacherService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/admin/examPaperAnswer")
public class AnswerController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    HttpSession session;

    @RequestMapping("/page")
    public AnswerListResponse AnswerList(@RequestBody AnswerListRequest req){
        AnswerListResponse resp = new AnswerListResponse();
        User teacher = (User)session.getAttribute("user");
        String teacherId =teacher.getUserId();

        resp = teacherService.AnswerList(req, teacherId);
        return resp;
    }
}
