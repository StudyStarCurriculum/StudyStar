package com.curriculum.studystar.Controller.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/student/subject")
public class DashboardController {
    @Autowired
    HttpSession session;

    // @RequestMapping("/subjectList")
    // public 
}
