package com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher;

import lombok.Data;
import java.util.ArrayList;

@Data
public class courseExtra1 {
    private int total;
    private ArrayList<courseExtra2> list=new ArrayList<courseExtra2>(); 

    public void addCourseList(String courseId,String courseName,int courseLevel,String courseKey){
        list.add(new courseExtra2(courseId,courseName,courseLevel,courseKey));
    }
}
