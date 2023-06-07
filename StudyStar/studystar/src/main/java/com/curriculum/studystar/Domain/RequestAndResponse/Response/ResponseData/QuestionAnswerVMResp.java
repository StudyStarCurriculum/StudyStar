package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import java.util.ArrayList;

import lombok.Data;

@Data
public class QuestionAnswerVMResp {
    private boolean doRight;
    private String content;
    private ArrayList<String> contentArray = new ArrayList<String>();
    private Integer score;
}
