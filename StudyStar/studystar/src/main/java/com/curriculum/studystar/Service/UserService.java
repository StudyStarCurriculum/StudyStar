package com.curriculum.studystar.Service;

import com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest.LoginRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse.LoginResponse;

public interface UserService {
    public LoginResponse Login(LoginRequest req);
}
