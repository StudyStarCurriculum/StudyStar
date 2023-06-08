package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.CourseSelection;
import com.curriculum.studystar.Domain.Entity.User;

import org.apache.ibatis.annotations.Insert;

public interface CourseSelectionMapper extends BaseMapper<CourseSelection>{
    @Select("select * from course_selection where courseId = #{courseId}")
    public ArrayList<User> SelectStudentByCourseId(String courseId);

    @Select("select * from course_selection where courseId = #{courseId} and studentId = #{studentId}")
    public CourseSelection SelectStudentByAll(String courseId, String studentId);

    @Select("select courseId from course_selection where studentId = #{userId}")
    public ArrayList<String> SelectCourseIdByUserId(String userId);

    @Insert("insert into course_selection (selectionId,studentId,courseId) values (#{selectionId}, #{studentId}, #{courseId})")
    public void InsertCourseSelection(String selectionId,String studentId,String courseId);
    
}
/*
 * public interface LogMapper extends BaseMapper<Log> {
    @Select("select * from log where userId = #{userId}")
    public ArrayList<Log> SelectLogsByUserId(String userId);

    @Insert("insert into log (logId, userId, content, createTime) values (#{logId}, #{userId}, #{content}, #{createTime})")
    public void InsertLog(String logId, String userId, String content, String createTime);
} 
 */
