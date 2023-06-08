package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.StartTestResponse;

import lombok.Data;

@Data
public class AnswerShowResp {
    StartTestResponse paper;
    MyAnswerShowResp answer;
}
