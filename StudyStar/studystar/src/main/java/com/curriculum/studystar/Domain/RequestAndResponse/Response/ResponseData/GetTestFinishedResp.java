package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetTestFinishedResp {
    private String id;
    private String name;
    private Integer status;
    private String createTime;
    private String subjectName;
    private Integer userScore;
    private Integer paperScore;
}
