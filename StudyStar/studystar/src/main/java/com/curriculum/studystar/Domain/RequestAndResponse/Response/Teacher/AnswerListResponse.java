package com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher;

import lombok.Data;

@Data
public class AnswerListResponse {
    private int code;
    private String message;
    private answerlistExtra1 response = new answerlistExtra1();
}
