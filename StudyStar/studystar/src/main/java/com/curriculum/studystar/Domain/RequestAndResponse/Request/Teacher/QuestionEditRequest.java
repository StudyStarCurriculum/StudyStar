package com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher;

import java.util.ArrayList;

import lombok.Data;

@Data
public class QuestionEditRequest {
    private String analyse;
    private String correct;
    private int difficult;
    private String id;
    private ArrayList<questionitem> items = new ArrayList<>();
    private ArrayList<String> correctArray = new ArrayList<>();
    private int questionType;
    private int score;
    private String subjectId;
    private String title;
}
/*
 * //填空题
{
    analyse: "string"
    correct: nul
    difficult: 5
    gradeLevel: 1
    id: 1
    //items中存储正确答案
    items: [
        {
            prefix: 1,
            content: "string",
            score: 2
        },
        {
            prefix: 2,
            content: "string",
            score: 2
        }
    ]
    correctArray:["string","string"]
    questionType: 4
    score: 4
    subjectId: "string"
    title: "string"

}

//简答题
{
    analyse:"string"
    correct:"string"
    difficult: 5
    gradeLevel: 1
    id: 1
    items: [0]
    questionType: 5
    correctArray:["string"],
    score: 1
    subjectId: 1
    title: "string"
}

//判断题
{
    analyse: "string"
    correct: "B"
    difficult: 1
    gradeLevel: 1
    id: 1
    items:[
        {
            content:"对",
            prefix:"A"
        },
        {
            content:"错",
            prefix:"B"
        }
    ]
    questionType:3
    score:1
    subjectId:1
    correctArray:["A"]
    title:"string"
}

//单选题
{
    analyse: "string"
    correct: "B"
    difficult:5
    gradeLevel:1
    correctArray:["A"]
    items:[
        {
            content:"string",
            prefix:"A"
        }
        //其他选项神略
    ]
    questionType:1
    score:1
    subjectId:1
    title:"string"
}

//多选题
{
    analyse: "string"
    correct: ""
    correctArray:[
        "A","B","C"
    ]
    difficult:5
    gradeLevel:1
    items:[
        {
            content:"string",
            prefix:"A"
        }
        //其他选项神略
    ]
    questionType:1
    score:1
    subjectId:1
    title:"string"
}

 */