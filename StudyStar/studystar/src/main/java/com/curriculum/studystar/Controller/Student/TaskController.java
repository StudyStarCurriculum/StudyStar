package com.curriculum.studystar.Controller.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Student.GetTestListRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListFinishedResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListResponse;
import com.curriculum.studystar.Service.Impl.StudentServiceImpl.TaskServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/student/exam")
public class TaskController {
    @Autowired
    HttpSession session;
    @Autowired
    TaskServiceImpl taskService;

    @RequestMapping("/testList")
    public GetTestListResponse GetTestList(@RequestBody GetTestListRequest req){
        GetTestListResponse resp = new GetTestListResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        resp = taskService.GetTestList(req.getSubjectId(), userId);

        return resp;
    }

    @RequestMapping("/testfinishedList")
    public GetTestListFinishedResponse GetTestListFinished(@RequestBody GetTestListRequest req){
        GetTestListFinishedResponse resp = new GetTestListFinishedResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        resp = taskService.GetTestListFinished(req.getSubjectId(),userId);

        return resp;
    }
}
