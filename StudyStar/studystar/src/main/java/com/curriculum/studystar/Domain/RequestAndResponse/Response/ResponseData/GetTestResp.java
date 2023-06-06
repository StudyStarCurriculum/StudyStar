package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetTestResp {
    private String id;
    private String name;
    private Integer score;
    private String createTime;
    private String subjectId;
    private String subjectName;
    private String endTime;
}
