package com.curriculum.studystar.Controller.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetSubjectResponse;
import com.curriculum.studystar.Service.Impl.StudentServiceImpl.DashboardServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/student/subject")
public class DashboardController {
    @Autowired
    HttpSession session;
    @Autowired
    DashboardServiceImpl dashboardService;

    @RequestMapping("/subjectList")
    public GetSubjectResponse GetSubject(){
        GetSubjectResponse resp = new GetSubjectResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        resp = dashboardService.GetSubject(userId);

        return resp;
    }

    @RequestMapping("/join/{key}")
    public RespCode JoinSubject(@PathVariable String key){
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        return dashboardService.JoinSubject(userId, key);
    }
}
