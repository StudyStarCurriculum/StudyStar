package com.curriculum.studystar.Controller.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.QuestionEditRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.QuestionDetailsResponse;
import com.curriculum.studystar.Service.Impl.TeacherServiceImpl.TeacherServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/admin/question")
public class QuestionController {
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    HttpSession session;

    @RequestMapping("/edit")
    public void questionedit(@RequestBody QuestionEditRequest req){
        teacherService.EditQuestion(req);
    }

    @RequestMapping("/select/{id}")
    public QuestionDetailsResponse questiondetails(@PathVariable String id){
        QuestionDetailsResponse resp = new QuestionDetailsResponse();

        resp = teacherService.QuestionDetail(id);
        return resp;
    }
}
/*
 * @RequestMapping("/education/subject/select")
    public CourseDetailsResponse coursedetails(HttpServletRequest req){
        CourseDetailsResponse resp = new CourseDetailsResponse();
        String id = req.getParameter("id");

        resp = teacherService.CourseDetails(id);
        return resp;
    }
 */