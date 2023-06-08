package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.TaskQuestionSet;

public interface TaskQuestionSetMapper extends BaseMapper<TaskQuestionSet> {
    @Select("select * from task_question_set where taskId = #{taskId}")
    public ArrayList<TaskQuestionSet> SelectQuestionSetByTaskId(String taskId);

    @Delete("delete from task_question_set where taskId = #{taskId}")
    public void DeleteQuestionSetByTaskId(String taskId);

    @Insert("insert into task_question_set (taskQuestionSetId, taskId, title) values (#{taskQuestionSetId}, #{taskId}, #{title})")
    public void InsertNewSet(String taskQuestionSetId, String taskId, String title);
}
