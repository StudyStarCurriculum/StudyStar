package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.TaskStatus;

public interface TaskStatusMapper extends BaseMapper<TaskStatus> {
    @Select("select * from task_status where taskId = #{taskId} and studentId = #{userId}")
    public TaskStatus SelectTaskStatusByTaskIdAndUserId(String taskId, String userId);

    //教师端
    @Select("select *from task_status where taskId = #{taskId}")
    public ArrayList<TaskStatus> SelectTaskStatusByTaskId(String taskId);
}
