package com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher;

import lombok.Data;

@Data
public class AnswerListRequest {
    private String subjectId;
    private String examId;
}
/*
 * {
          subjectId: null,
          examId: null,
}

 */