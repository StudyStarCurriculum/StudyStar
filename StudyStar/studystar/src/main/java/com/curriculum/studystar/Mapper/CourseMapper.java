package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Course;

public interface CourseMapper extends BaseMapper<Course> {
    @Select("select * from course where courseId = #{courseId}")
    public Course SelectCourseByCourseId(String courseId);

    @Select("select * from course where courseKey = #{key}")
    public Course SelectCourseByCourseKey(String key);
}
