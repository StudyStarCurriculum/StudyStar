package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionResp {
    private String id;
    private Integer questionType;
    private String title;
    private ArrayList<QuestionItem> items = new ArrayList<QuestionItem>();
    private Integer itemOrder;
}
