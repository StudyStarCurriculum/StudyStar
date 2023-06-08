package com.curriculum.studystar.Domain.RequestAndResponse.Request.RequestData;

import lombok.Data;

@Data
public class CorrectionReq {
    private String questionId;
    private boolean doRight;
    private String[] contentArray;
    private Integer score;
}
