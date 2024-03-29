package com.curriculum.studystar.Controller.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.RequestData.AnswerReq;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Student.GetTestListRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Student.SubmitTestRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.AnswerShowResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListFinishedResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.StartTestResponse;
import com.curriculum.studystar.Service.Impl.StudentServiceImpl.TaskServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/student")
public class TaskController {
    @Autowired
    HttpSession session;
    @Autowired
    TaskServiceImpl taskService;

    @RequestMapping("/exam/testList")
    public GetTestListResponse GetTestList(@RequestBody GetTestListRequest req){
        GetTestListResponse resp = new GetTestListResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        resp = taskService.GetTestList(req.getSubjectId(), userId);

        return resp;
    }

    @RequestMapping("/exam/testfinishedList")
    public GetTestListFinishedResponse GetTestListFinished(@RequestBody GetTestListRequest req){
        GetTestListFinishedResponse resp = new GetTestListFinishedResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        resp = taskService.GetTestListFinished(req.getSubjectId(),userId);

        return resp;
    }

    @RequestMapping("/exam/select/{id}")
    public StartTestResponse StartTest(@PathVariable String id){
        StartTestResponse resp = new StartTestResponse();

        resp = taskService.StartTest(id);

        return resp;
    }

    @RequestMapping("/exampaper/answer/answerSubmit")
    public RespCode SubmitTest(@RequestBody SubmitTestRequest req){
        String taskId = req.getTaskId();
        List<AnswerReq> items = req.getAnswerItems();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();
        return taskService.SubmitTest(items, userId, taskId);
    }

    @RequestMapping("/exampaper/answer/read/{id}")
    public AnswerShowResponse AnswerShow(@PathVariable String id){
        AnswerShowResponse resp = new AnswerShowResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        resp = taskService.AnswerShow(id, userId);

        return resp;
    }
}
