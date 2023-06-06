package com.curriculum.studystar.Domain.RequestAndResponse.Response.Student;

import java.util.ArrayList;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.ResponseData.GetCourseResp;

import lombok.Data;

@Data
public class GetSubjectResponse {
    private RespCode respCode;
    private ArrayList<GetCourseResp> courses = new ArrayList<GetCourseResp>();

    public void addData(String courseId,
            String courseKey,
            String courseName,
            String teacherName,
            String courseImagePath,
            Integer courseLevel) {
        courses.add(new GetCourseResp(
            courseId,
            courseKey,
            courseName,
            teacherName,
            courseImagePath,
            courseLevel
        ));
    }
}
