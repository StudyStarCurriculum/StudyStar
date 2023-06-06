package com.curriculum.studystar.Domain.RequestAndResponse.Response.Student;

import java.util.ArrayList;

import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.GetTestResp;

import lombok.Data;

@Data
public class GetTestListResponse {
    private Integer total;
    private ArrayList<GetTestResp> list = new ArrayList<GetTestResp>();

    public void addData(
            String taskId,
            String taskName,
            Integer score,
            String createTime,
            String subjectId,
            String subjectName,
            String endTime) {
        list.add(new GetTestResp(
                taskId,
                taskName,
                score,
                createTime,
                subjectId,
                subjectName,
                endTime));
    }
}
