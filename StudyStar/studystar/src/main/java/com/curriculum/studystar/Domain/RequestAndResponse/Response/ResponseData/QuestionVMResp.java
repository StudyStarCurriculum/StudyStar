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
    private String[] correctArray;
    private Integer score;
    private Integer difficult;
    public void addData(String prefix,String content){
        items.add(new QuestionItem(prefix, content));
    }
}
