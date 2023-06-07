package com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher;

import java.util.ArrayList;

import com.curriculum.studystar.Domain.Entity.User;

import lombok.Data;

@Data
public class studentExtra1 {
    private int total;
    private ArrayList<User> list = new ArrayList<>();
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