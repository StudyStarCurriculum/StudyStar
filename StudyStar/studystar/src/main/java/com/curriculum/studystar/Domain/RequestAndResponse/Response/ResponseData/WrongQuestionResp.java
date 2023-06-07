package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WrongQuestionResp {
    private String id;
    private Integer questionType;
    private String createTime;
    private String subjectName;
    private String shortTitle;
}
