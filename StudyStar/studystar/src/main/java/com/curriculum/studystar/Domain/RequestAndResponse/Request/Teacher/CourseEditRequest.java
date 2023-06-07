package com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher;

import lombok.Data;

@Data
public class CourseEditRequest {
    private String id;
    private int level;
    private String name;
}
/*
 * {
    "id":null,
    "level":1
    "name":"大数据"
}

 */