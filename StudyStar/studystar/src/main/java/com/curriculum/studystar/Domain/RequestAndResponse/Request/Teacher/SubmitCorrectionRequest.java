package com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher;

import com.curriculum.studystar.Domain.RequestAndResponse.Request.RequestData.CorrectionReq;

import lombok.Data;

@Data
public class SubmitCorrectionRequest {
    private String id;
    private CorrectionReq[] answerItems;
}
