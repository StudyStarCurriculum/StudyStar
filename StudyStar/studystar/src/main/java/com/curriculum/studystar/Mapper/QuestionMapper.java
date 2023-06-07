package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Question;

public interface QuestionMapper extends BaseMapper<Question> {
    @Select("select * from question where questionId = #{questionId}")
    public Question SelectQuestionByQuestionId(String questionId);
}
