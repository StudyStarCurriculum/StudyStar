package com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher;

import lombok.Data;

@Data
public class StudentListResponse {
    private int code;
    private studentExtra1 response = new studentExtra1();
}

/*
 * "code": 1,
    "response": {
      "total": 2,
      "list": [
        {
          "userName": "wwwwwwww",
          "realName": "梨花",
          "userLevel": 1,
          "phone": null,
          //"status": 1
        }
 */