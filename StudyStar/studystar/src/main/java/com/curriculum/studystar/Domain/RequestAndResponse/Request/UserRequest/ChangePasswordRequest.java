package com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String oldPassword;
    private String newPassword;

    public boolean ParamCheck() {
        if (oldPassword == null || newPassword == null) {
            return false;
        }
        return true;
    }
}
