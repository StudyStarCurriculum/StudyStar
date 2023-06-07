package com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class answerlistExtra2 {
    private String id;
    private String createTime;
    private int userScore;
    private int paperScore;
    private String doTime;
    private int paperType;
    private String systemScore; //无用属性
    private int status;
    private String paperName;
    private String userName;
}
