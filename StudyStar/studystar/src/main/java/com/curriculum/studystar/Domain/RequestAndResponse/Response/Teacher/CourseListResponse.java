package com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher;

import lombok.Data;

@Data
public class CourseListResponse {
    private int code;
    private courseExtra1 response = new courseExtra1();
    
}

/*
 * "code": 1,
    "response": {
      "total": 2,
      "list": [
        {
          "id": "12312",
          "name": "数据结构",
          "level": 2,
          "key":"1222241242sadlkhfa",
          //"itemOrder": null,
          //"deleted": false
        },
        {
          "id": "11231212",
          "name": "大数据",
          "level": 3,
          "key":"122224sfsafdlkhfa",
          //"itemOrder": null,
          //"deleted": false
        }
      ]
    }

 */