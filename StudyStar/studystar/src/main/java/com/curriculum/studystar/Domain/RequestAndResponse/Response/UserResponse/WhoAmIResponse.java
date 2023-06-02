package com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.Entity.User;

import lombok.Data;

@Data
public class WhoAmIResponse {
    private RespCode respCode; 
    private User curUser;
}
