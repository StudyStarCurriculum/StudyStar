package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import java.util.ArrayList;

import lombok.Data;

@Data
public class QuestionVMResp {
    private Integer questionType;
    private String subjectId;
    private String title;
    private ArrayList<QuestionItem> items = new ArrayList<QuestionItem>();
    private String analyze;
    private ArrayList<String> correctArray = new ArrayList<String>();
    private Integer score;
    private Integer difficult;
}
