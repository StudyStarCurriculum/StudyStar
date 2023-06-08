package com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher;


import com.curriculum.studystar.Domain.RequestAndResponse.Request.RequestData.EditExamSetReq;

import lombok.Data;

@Data
public class EditExamRequest {
    private String id;
    private String[] limitDateTime;
    private String name;
    private String subjectId;
    private Integer totalScore;
    private EditExamSetReq[] titleItems;
}
