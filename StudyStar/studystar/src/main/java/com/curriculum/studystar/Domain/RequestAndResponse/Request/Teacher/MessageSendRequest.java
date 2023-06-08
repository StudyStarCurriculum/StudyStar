package com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher;

import java.util.ArrayList;

import lombok.Data;

@Data
public class MessageSendRequest {
    private String titile;
    private String content;
    private ArrayList<String> receiveUserIds = new ArrayList<>();
}
/*
 * {
          title: '标题',
          content: '内容',
          receiveUserIds: ["wwww","Wwwwww"]//这是userName
}

 */