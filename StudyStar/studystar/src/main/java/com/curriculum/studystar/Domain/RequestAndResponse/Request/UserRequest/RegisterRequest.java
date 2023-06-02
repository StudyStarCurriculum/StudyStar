package com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Integer role;

    public boolean ParamCheck() {
        if (username == null || password == null || role == null) {
            return false;
        }
        return true;
    }
}
