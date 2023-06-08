package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import java.util.ArrayList;

import lombok.Data;

@Data
public class TaskSetResp {
    private String id;
    private String name;
    private ArrayList<QuestionDetailsResp> questionItems = new ArrayList<QuestionDetailsResp>();

    public void addData(QuestionDetailsResp item) {
        questionItems.add(item);
    }
}
