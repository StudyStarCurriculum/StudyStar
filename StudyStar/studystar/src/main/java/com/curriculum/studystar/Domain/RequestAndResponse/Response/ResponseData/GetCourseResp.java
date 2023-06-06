package com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCourseResp {
    private String courseId;
    private String courseKey;
    private String courseName;
    private String teacherName;
    private String courseImagePath;
    private Integer courseLevel;
}
