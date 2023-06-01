package com.curriculum.studystar.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Config.Status;
import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.LoginRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.LoginResponse;
import com.curriculum.studystar.Mapper.UserMapper;
import com.curriculum.studystar.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public LoginResponse Login(LoginRequest req){
        LoginResponse resp = new LoginResponse();
        String username = req.getUsername();
        String password = req.getPassword();

        User user = userMapper.SelectUserByUserName(username);
        if(user == null){
            resp.setStaus(Status.UserNotExisted);
        }else if(!user.getPassword().equals(password)){
            resp.setStaus(Status.WrongPassword);
        }else{
            resp.setStaus(Status.OK);
        }

        return resp;
    }
}
