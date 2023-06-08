package com.curriculum.studystar.Domain.RequestAndResponse.Response.Student;

import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.QuestionAnswerVMResp;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.QuestionVMResp;

import lombok.Data;

@Data
public class GetCorrectionDetailsResponse {
    private QuestionVMResp questionVM;
    private QuestionAnswerVMResp questionAnswerVM;
}
