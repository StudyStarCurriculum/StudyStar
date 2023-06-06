package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.CourseSelection;

public interface CourseSelectionMapper extends BaseMapper<CourseSelection> {
    @Select("select courseId from course_selection where studentId = #{userId}")
    public ArrayList<String> SelectCourseIdByUserId(String userId);

    @Insert("insert into course_selection (selectionId,studentId,courseId) values (#{selectionId}, #{studentId}, #{courseId})")
    public void InsertCourseSelection(String selectionId,String studentId,String courseId);
}
