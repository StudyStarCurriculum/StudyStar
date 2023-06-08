package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into task (taskId, score, courseId, taskName, type, startTime, endTime, createTime) values (#{taskId}, #{score}, #{courseId}, #{taskName}, #{type}, #{startTime}, #{endTime}, #{createTime})")
    public void InsertNewTask(String taskId, Integer score, String courseId, String taskName, Integer type, String startTime, String endTime, String createTime);

    @Delete("delete from task where taskId = #{taskId}")
    public void DeleteTaskById(String taskId);
}
