package com.curriculum.studystar.Domain.RequestAndResponse.Response.Student;

import java.util.ArrayList;

import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.WrongQuestionResp;

import lombok.Data;

@Data
public class GetCorrectionResponse {
    private Integer total;
    private ArrayList<WrongQuestionResp> list = new ArrayList<WrongQuestionResp>();

    public void addData(
            String id,
            Integer questionType,
            String createTime,
            String subjectName,
            String shortTitle) {
        list.add(new WrongQuestionResp(id, questionType, createTime, subjectName, shortTitle));
    }
}
