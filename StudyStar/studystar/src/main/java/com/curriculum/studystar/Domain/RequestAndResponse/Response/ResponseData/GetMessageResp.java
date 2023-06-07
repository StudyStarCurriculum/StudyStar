package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetMessageResp {
    private String title;
    private String content;
    private Integer readed;
    private String createTime;
    private String sendUserName;
}
