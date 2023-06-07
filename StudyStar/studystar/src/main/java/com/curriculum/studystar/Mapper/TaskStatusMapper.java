package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.TaskStatus;

public interface TaskStatusMapper extends BaseMapper<TaskStatus> {
    @Select("select * from task_status where taskId = #{taskId} and studentId = #{userId}")
    public TaskStatus SelectTaskStatusByTaskIdAndUserId(String taskId, String userId);

    @Update("update task_status set submitTime = #{submitTime}, totalScore = #{totalScore}, status = #{status} where studentId = #{studentId} and taskId = #{taskId}")
    public void UpdateTaskStatus(String submitTime, Integer totalScore, Integer status, String studentId,
            String taskId);
}
