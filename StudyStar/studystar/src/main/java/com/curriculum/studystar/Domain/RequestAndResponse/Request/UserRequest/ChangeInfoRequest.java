package com.curriculum.studystar.Domain.RequestAndResponse.Request.UserRequest;

import lombok.Data;

@Data
public class ChangeInfoRequest {
    private String realName;
    private Integer userLevel;
    private Integer sex;
    private Integer age;
    private String phone;
    private String userImagePath;
}
