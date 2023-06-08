package com.curriculum.studystar.Domain.RequestAndResponse.Request.RequestData;

import lombok.Data;

@Data
public class EditExamSetReq {
    private String id;
    private String name;
    private QuestionIdReq[] questionItems;

}
