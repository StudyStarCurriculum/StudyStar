package com.curriculum.studystar.Domain.RequestAndResponse.Response.Student;

import java.util.ArrayList;

import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.GetTestFinishedResp;

import lombok.Data;

@Data
public class GetTestListFinishedResponse {
    private Integer total;
    private ArrayList<GetTestFinishedResp> list = new ArrayList<GetTestFinishedResp>();

    public void addData(
        String taskId,
        String taskName,
        Integer status,
        String createTime,
        String subjectName,
        Integer userScore,
        Integer paperScore
    ){
        list.add(new GetTestFinishedResp(
            taskId,
            taskName,
            status,
            createTime,
            subjectName,
            userScore,
            paperScore
        ));
    }
}
