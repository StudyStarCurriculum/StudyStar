package com.curriculum.studystar.Domain.RequestAndResponse.Request.Student;

import java.util.List;

import com.curriculum.studystar.Domain.RequestAndResponse.Request.RequestData.AnswerReq;

import lombok.Data;

@Data
public class SubmitTestRequest {
    private String taskId;
    private List<AnswerReq> answerItems;
}
