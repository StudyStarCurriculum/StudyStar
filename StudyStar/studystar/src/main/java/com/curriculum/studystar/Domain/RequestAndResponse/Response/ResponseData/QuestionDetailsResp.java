package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionDetailsResp {
    private Integer questionType;
    private String subjectId;
    private String title;
    private ArrayList<QuestionItem> items = new ArrayList<QuestionItem>();
    private String analyze;
    private String[] correctArray;
    private Integer score;
    private Integer difficult;
    private Integer itemOrder;
}
