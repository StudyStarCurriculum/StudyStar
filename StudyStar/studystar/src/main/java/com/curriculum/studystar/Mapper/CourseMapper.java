package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Course;

public interface CourseMapper extends BaseMapper<Course>{
    @Select("select * from course where teacherId = #{teacherId}")
    public ArrayList<Course> SelectCourseByTeacherId(String teacherId);

    @Select("select teacherId from course where courseId = #{courseId}")
    public String SelectTeacherByCourseId(String courseId);

    @Select("select * from course where courseId = #{courseId}")
    public Course SelectCourseByCourseId(String courseId);

    @Select("select * from course where courseKey = #{key}")
    public Course SelectCourseByCourseKey(String key);

    @Select("select * from course where courseId = #{courseId} and teacherId = #{teacherId}")
    public Course SelectCourseByTeacherIdAndCourseId(String courseId, String teacherId);

    @Insert("insert into course(courseId,coureImagePath,courseKey,courseLevel,courseName,teacherId) values (#{courseId},#{courseImagePath},#{courseKey},#{courseLevel},#{courseName},#{teacherId})")
    public void InsertNewCourse(String courseId,String courseImagePath,String courseKey,int courseLevel,String courseName,String teacherId);

    @Update("update course set courseLevel = #{courseLevel},courseName = #{courseName} where courseId = #{courseId}")
    public void UpdataCourse(int courseLevel, String courseName, String courseId);
}


