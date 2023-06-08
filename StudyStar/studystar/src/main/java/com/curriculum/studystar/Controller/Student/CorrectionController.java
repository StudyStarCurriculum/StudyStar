package com.curriculum.studystar.Controller.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetCorrectionDetailsResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetCorrectionResponse;
import com.curriculum.studystar.Service.Impl.StudentServiceImpl.CorrectionServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/student/question/answer")
public class CorrectionController {
    @Autowired
    HttpSession session;
    @Autowired
    CorrectionServiceImpl correctionService;

    @RequestMapping("/page")
    public GetCorrectionResponse GetWrongQuestion(){
        GetCorrectionResponse resp = new GetCorrectionResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        resp = correctionService.GetWrongQuestion(userId);

        return resp;
    }

    @RequestMapping("/select")
    public GetCorrectionDetailsResponse GetCorrectionDetails(HttpServletRequest req){
        String correctionId = req.getParameter("id");
        GetCorrectionDetailsResponse resp = new GetCorrectionDetailsResponse();

        resp = correctionService.GetCorrectionDetails(correctionId);

        return resp;
    }
}
