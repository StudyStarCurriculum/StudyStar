package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.TaskQuestion;

public interface TaskQuestionMapper extends BaseMapper<TaskQuestion> {
    @Select("select * from task_question where taskQusetionSetId = #{setId}")
    public ArrayList<TaskQuestion> SelectTaskQuestionBySetId(String setId);

    @Delete("delete * from task_question where taskQusetionSetId = #{taskQusetionSetId}")
    public void DeleteTaskQuestionBySetId(String taskQusetionSetId);

    @Insert("insert into task_question(taskQuestionId, taskQusetionSetId, questionId) values (#{taskQuestionId}, #{taskQusetionSetId}, #{questionId})")
    public void InsertTaskQuestion(String taskQuestionId, String taskQusetionSetId, String questionId);
}
