package com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher;

import java.util.ArrayList;

import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.QuestionItem;

import lombok.Data;

@Data
public class questiondetails {
    private String id;
    private int questionType;
    private String subjectId;
    private String title;
    private int gradeLevel;
    private ArrayList<QuestionItem> items = new ArrayList<>();;
    private String analyze;
    private ArrayList<String> correctArray = new ArrayList<>();
    private String correct;
    private int score;
    private int difficult;    

    public void addList(String correct){
      correctArray.add(correct);
    }

    public void addItem(String prefix,String item){
      final QuestionItem it = new QuestionItem();
      it.setPrefix(prefix);
      it.setContent(item);
      items.add(it);
    }
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