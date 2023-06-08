package com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher;

import lombok.Data;

@Data
public class QuestionDetailsResponse {
    private questiondetails response = new questiondetails();
}
/*
 * {
    "response": {
      "id": 8,
      "questionType": 1,
      "subjectId": 1,
      "title": "124",
      "gradeLevel": 1,
      "items": [
        {
          "prefix": "1",
          "content": "鹅鹅鹅",
          "score": "2"
        },
        {
          "prefix": "2",
          "content": "白毛浮绿水",
          "score": "2"
        }
      ],
      "analyze": "咏鹅",
      "correctArray": [
        "2",
        "1"
      ],
      "correct":"1",
      "score": "4",
      "difficult": 4,
      "itemOrder": 1
    }
  }

 */