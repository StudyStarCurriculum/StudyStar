package com.curriculum.studystar.Service;

import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.ChangeInfoRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.ChangePasswordRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.LoginRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.RegisterRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.ChangeInfoResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.ChangePasswordResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.GetLogResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.LoginResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.RegisterResponse;

public interface UserService {
    public LoginResponse Login(LoginRequest req);

    public RegisterResponse Register(RegisterRequest req);

    public ChangeInfoResponse ChangeInfo(ChangeInfoRequest req, String userId);

    public ChangePasswordResponse ChangePassword(ChangePasswordRequest req, String userId);

    public GetLogResponse GetLog(String userId);
}
