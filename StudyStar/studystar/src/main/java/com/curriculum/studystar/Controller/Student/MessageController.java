package com.curriculum.studystar.Controller.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetMessageResponse;
import com.curriculum.studystar.Service.Impl.StudentServiceImpl.MessageServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/student/user/message")
public class MessageController {
    @Autowired
    HttpSession session;
    @Autowired
    MessageServiceImpl messageService;

    @RequestMapping("/messageList")
    public GetMessageResponse GetMessage(){
        GetMessageResponse resp = new GetMessageResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        resp = messageService.GetMessage(userId);

        return resp;
    }
}
