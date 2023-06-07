package com.curriculum.studystar.Domain.RequestAndResponse.Response.Student;

import java.util.ArrayList;

import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.QuestionSetResp;

import lombok.Data;

@Data
public class StartTestResponse {
    private String name;
    private String suggestTime;
    private Integer score;
    private ArrayList<QuestionSetResp> titleItems = new ArrayList<QuestionSetResp>();

    public void addData(QuestionSetResp set){
        titleItems.add(set);
    }
}
