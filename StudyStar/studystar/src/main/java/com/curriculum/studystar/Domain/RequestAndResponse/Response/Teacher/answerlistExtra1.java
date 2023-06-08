package com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher;

import java.util.ArrayList;

import lombok.Data;

@Data
public class answerlistExtra1 {
    private int total;
    private ArrayList<answerlistExtra2> list = new ArrayList<>();

    public void addData(String id, String createTime, int userScore, int paperScore, String doTime,
                        int papreType, int status, Integer integer, String paperName, String userName)
    {
        list.add(new answerlistExtra2(id, createTime, userScore, paperScore, doTime, papreType, doTime, status, paperName, userName));
    }
}
