package com.curriculum.studystar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.ChangeInfoRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.ChangePasswordRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.LoginRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.LogoutResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.RegisterRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.ChangeInfoResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.ChangePasswordResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.GetLogResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.LoginResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.RegisterResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.WhoAmIResponse;
import com.curriculum.studystar.Service.Impl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserServiceImpl userServeice;
    @Autowired
    HttpSession session;

    @RequestMapping("/login")
    public LoginResponse Login(@RequestBody LoginRequest req) {
        LoginResponse resp = new LoginResponse();

        if (!req.ParamCheck()) {
            resp.setRespCode(RespCode.ParamInvalid);
        } else {
            resp = userServeice.Login(req);
            session.setAttribute("user", resp.getCurUser());
        }

        return resp;
    }

    @RequestMapping("/register")
    public RegisterResponse Register(@RequestBody RegisterRequest req) {
        RegisterResponse resp = new RegisterResponse();

        if (!req.ParamCheck()) {
            resp.setRespCode(RespCode.ParamInvalid);
        } else {
            resp = userServeice.Register(req);
        }

        return resp;
    }

    @RequestMapping("/current")
    public WhoAmIResponse WhoAmI() {
        WhoAmIResponse resp = new WhoAmIResponse();
        User user = (User) session.getAttribute("user");

        if(user == null){
            resp.setRespCode(RespCode.LoginRequeried);
        }else{
            resp.setRespCode(RespCode.OK);
            resp.setCurUser(user);
        }

        return resp;
    }

    @RequestMapping("/changeInfo")
    public ChangeInfoResponse ChangeInfo(@RequestBody ChangeInfoRequest req){
        ChangeInfoResponse resp = new ChangeInfoResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        resp = userServeice.ChangeInfo(req, userId);

        return resp;
    }

    @RequestMapping("/logout")
    public LogoutResponse Logout(){
        LogoutResponse resp = new LogoutResponse();
        User curUser = (User)session.getAttribute("user");

        if(curUser == null){
            resp.setRespCode(RespCode.LoginRequeried);
        }else{
            session.removeAttribute("user");
            resp.setRespCode(RespCode.OK);
        }

        return resp;
    }

    @RequestMapping("/changePassword")
    public ChangePasswordResponse ChangePassword(@RequestBody ChangePasswordRequest req){
        ChangePasswordResponse resp = new ChangePasswordResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        if(!req.ParamCheck()){
            resp.setRespCode(RespCode.ParamInvalid);
        }else{
            resp = userServeice.ChangePassword(req, userId);
        }

        return resp;
    }

    @RequestMapping("/log")
    public GetLogResponse GetLog(){
        GetLogResponse resp = new GetLogResponse();
        User curUser = (User)session.getAttribute("user");
        String userId = curUser.getUserId();

        resp = userServeice.GetLog(userId);

        return resp;
    }
}
