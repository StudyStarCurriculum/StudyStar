package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Task;

public interface TaskMapper extends BaseMapper<Task>{
    @Select("select * from task where courseId = #{courseId}")
    public ArrayList<Task> SelectTaskByCourseId(String courseId);

    //教师端
    @Select("select courseId from task where taskId = #{taskId}")
    public String SelectCourseIdByTaskId(String taskId);

    @Select("select * from task where taskId = #{taskId}")
    public Task SelectTaskByTaskId(String taskId);
}
