package com.curriculum.studystar.Controller.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.MessageSendRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.MessageSendResponse;
import com.curriculum.studystar.Service.Impl.TeacherServiceImpl.TeacherServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping()
public class TMessageController {
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    HttpSession session;

    @RequestMapping("/api/admin/message/send")
    public MessageSendResponse sendmessage(@RequestBody MessageSendRequest req){
        MessageSendResponse resp = new MessageSendResponse();
        User teacher = (User)session.getAttribute("user");
        String teacherId = teacher.getUserId();

        resp = teacherService.SendMessage(req,teacherId);
        return resp;
    }
}
/*
 * @RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserServiceImpl userServeice;
    @Autowired
    HttpSession session;

    @RequestMapping("/login")
    public LoginResponse Login(@RequestBody LoginRequest req) {
 */