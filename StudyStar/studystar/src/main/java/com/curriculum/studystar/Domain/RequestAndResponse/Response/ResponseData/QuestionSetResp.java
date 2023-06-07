package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import java.util.ArrayList;

import lombok.Data;

@Data
public class QuestionSetResp {
    private String name;
    private ArrayList<QuestionResp> questionItems = new ArrayList<QuestionResp>();

    public void addData(QuestionResp item) {
        questionItems.add(item);
    }
}
