package com.curriculum.studystar.Domain.RequestAndResponse.Request.RequestData;

import lombok.Data;

@Data
public class AnswerReq {
    private String[] contentArray;
    private String questionId;
}
