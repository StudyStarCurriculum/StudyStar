package com.curriculum.studystar.Controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.CourseEditRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.StudentListRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.CourseDetailsResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.CourseListResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.StudentListResponse;
import com.curriculum.studystar.Service.Impl.TeacherServiceImpl.TeacherServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/admin")
public class TeachController {
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    HttpSession session;

    //获取教授课程列表
    @RequestMapping("/education/subject/page")
    public CourseListResponse courselist(){
        CourseListResponse corresp = new CourseListResponse();
        User teacher = (User)session.getAttribute("user");
        String teacherId = teacher.getUserId();
        
        corresp = teacherService.CourseList(teacherId);
        return corresp;
    }

    //编辑课程
    @RequestMapping("/education/subject/edit")
    public void courseedit(@RequestBody CourseEditRequest req){
        User teacher = (User)session.getAttribute("user");
        String teacherId = teacher.getUserId();

        teacherService.CourseEdit(req, teacherId);
    }

    //课程详情
    @RequestMapping("/education/subject/select")
    public CourseDetailsResponse coursedetails(HttpServletRequest req){
        CourseDetailsResponse resp = new CourseDetailsResponse();
        String id = req.getParameter("id");

        resp = teacherService.CourseDetails(id);
        return resp;
    }

    //获取学生列表
    @RequestMapping("/user/page/list")
    public StudentListResponse studentlist(@RequestBody StudentListRequest req){
        StudentListResponse sturesp = new StudentListResponse();
        User teacher = (User)session.getAttribute("user");
        String teacherId = teacher.getUserId();

        sturesp = teacherService.StudentList(req, teacherId);
        return sturesp;
    }
}

