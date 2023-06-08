package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import java.util.ArrayList;

import lombok.Data;

@Data
public class MyAnswerShowResp {
    private String doTime;
    private Integer score;
    private ArrayList<MyAnswerResp> answerItems = new ArrayList<MyAnswerResp>();
    public void addData(Integer doRight,Integer itemOrder,String[] contentArray){
        answerItems.add(new MyAnswerResp(doRight, itemOrder, contentArray));
    }
}
