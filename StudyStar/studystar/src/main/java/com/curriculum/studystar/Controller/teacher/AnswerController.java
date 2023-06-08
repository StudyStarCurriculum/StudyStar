package com.curriculum.studystar.Controller.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.AnswerListRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.SubmitCorrectionRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.AnswerShowResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.AnswerListResponse;
import com.curriculum.studystar.Service.Impl.TeacherServiceImpl.TeacherServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/admin")
public class AnswerController {
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    HttpSession session;

    @RequestMapping("/examPaperAnswer/page")
    public AnswerListResponse AnswerList(@RequestBody AnswerListRequest req) {
        AnswerListResponse resp = new AnswerListResponse();
        User teacher = (User) session.getAttribute("user");
        String teacherId = teacher.getUserId();

        resp = teacherService.AnswerList(req, teacherId);
        return resp;
    }

    @RequestMapping("/exampaper/answer/read/{id}")
    public AnswerShowResponse ShowAnswer(@PathVariable String id) {
        AnswerShowResponse resp = new AnswerShowResponse();

        resp = teacherService.AnswerShow(id);

        return resp;
    }

    @RequestMapping("/exampaper/answer/edit")
    public RespCode SubmitCorrection(@RequestBody SubmitCorrectionRequest req){

        teacherService.SubmitCorrection(req);

        return RespCode.OK;
    }
}
