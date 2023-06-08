package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import java.util.ArrayList;

import lombok.Data;

@Data
public class TaskDetailsResp {
    private String id;
    private Integer score;
    private String[] limitDateTime;
    private String name;
    private String subjectId;
    private Integer paperType;
    private String suggestTime;
    private ArrayList<TaskSetResp> titleItems = new ArrayList<TaskSetResp>();

    public void addData(TaskSetResp set){
        titleItems.add(set);
    }
}
