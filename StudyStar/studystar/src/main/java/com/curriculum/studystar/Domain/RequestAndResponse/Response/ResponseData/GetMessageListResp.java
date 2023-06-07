package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GetMessageListResp {
    private ArrayList<GetMessageResp> list = new ArrayList<>();

    public void addData(
            String title,
            String content,
            Integer readed,
            String createTime,
            String sendUserName) {
        list.add(new GetMessageResp(
                title,
                content,
                readed,
                createTime,
                sendUserName));
    }
}
