package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyAnswerResp {
    private boolean doRight;
    private Integer itemOrder;
    private String[] contentArray;
}
