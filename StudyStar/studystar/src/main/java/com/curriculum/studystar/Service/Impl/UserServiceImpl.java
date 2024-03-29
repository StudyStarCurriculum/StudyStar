package com.curriculum.studystar.Service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.Entity.Log;
import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.ChangeInfoRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.ChangePasswordRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.LoginRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.RegisterRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.ChangeInfoResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.ChangePasswordResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.GetLogResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.LoginResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.RegisterResponse;
import com.curriculum.studystar.Mapper.LogMapper;
import com.curriculum.studystar.Mapper.UserMapper;
import com.curriculum.studystar.Service.UserService;
import com.curriculum.studystar.Utils.CurrentTimeUtil;
import com.curriculum.studystar.Utils.RandomUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    LogMapper logMapper;

    @Override
    public LoginResponse Login(LoginRequest req){
        LoginResponse resp = new LoginResponse();
        String username = req.getUsername();
        String password = req.getPassword();
        Integer role = req.getRole();

        User user = userMapper.SelectUserByUserName(username);
        if(user == null){
            resp.setRespCode(RespCode.UserNotExisted);
        }else if(!user.getPassword().equals(password)){
            resp.setRespCode(RespCode.WrongPassword);
        }else if(user.getRole() != role){
            resp.setRespCode(RespCode.WrongRole);
        }else{
            String logId = RandomUID.getRandomUID();
            logMapper.InsertLog(logId, user.getUserId(), user.getUserName()+"登录系统", CurrentTimeUtil.getCurrnetTime());
            resp.setRespCode(RespCode.OK);
            resp.setCurUser(user);
        }

        return resp;
    }

    @Override
    public RegisterResponse Register(RegisterRequest req) {
        RegisterResponse resp = new RegisterResponse();
        String username = req.getUsername();
        String password = req.getPassword();
        Integer role = req.getRole();

        User user = userMapper.SelectUserByUserName(username);
        if(user != null){
            resp.setRespCode(RespCode.UserHasExisted);
        }else{
            userMapper.InsertUser(RandomUID.getRandomUID(), username, password, role);
            resp.setRespCode(RespCode.OK);
        }

        return resp;
    }

    @Override
    public ChangeInfoResponse ChangeInfo(ChangeInfoRequest req, String userId) {
        ChangeInfoResponse resp = new ChangeInfoResponse();
        String realName = req.getRealName();
        Integer userLevel = req.getUserLevel();
        Integer sex = req.getSex();
        Integer age = req.getAge();
        String phone = req.getPhone();
        String userImagePath = req.getUserImagePath();

        userMapper.UpdateUserInfo(realName, userLevel, sex, age, phone, userImagePath, userId);
        resp.setUpdatedUser(userMapper.SelectUserByUserId(userId));
        resp.setRespCode(RespCode.OK);

        return resp;
    }

    @Override
    public ChangePasswordResponse ChangePassword(ChangePasswordRequest req, String userId) {
        ChangePasswordResponse resp = new ChangePasswordResponse();
        User curUser = userMapper.SelectUserByUserId(userId);

        if(!curUser.getPassword().equals(req.getOldPassword())){
            resp.setRespCode(RespCode.WrongPassword);
        }else{
            userMapper.UpdatePassword(req.getNewPassword(),userId);
            resp.setRespCode(RespCode.OK);
        }
        return resp;
    }

    @Override
    public GetLogResponse GetLog(String userId) {
        GetLogResponse resp = new GetLogResponse();
        ArrayList<Log> logs = logMapper.SelectLogsByUserId(userId);

        resp.setRespCode(RespCode.OK);
        for(Log item : logs)
            resp.addData(item);

        return resp;
    }
    
}
