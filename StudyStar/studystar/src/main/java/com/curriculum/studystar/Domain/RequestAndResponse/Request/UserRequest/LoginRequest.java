package com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;

    public boolean ParamCheck() {
        if (username == null || password == null) {
            return false;
        }
        return true;
    }
}
