package com.curriculum.studystar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Config.Status;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.LoginRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.LoginResponse;
import com.curriculum.studystar.Service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserServiceImpl userServeice;

    @RequestMapping("/login")
    public LoginResponse Login(@RequestBody LoginRequest req){
        LoginResponse resp = new LoginResponse();

        if(!req.ParamCheck()){
            resp.setStaus(Status.ParamInvalid);
        }else{
            resp = userServeice.Login(req);
        }

        return resp;
    }
}
