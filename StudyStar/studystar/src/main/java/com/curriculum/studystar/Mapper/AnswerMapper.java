package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Insert;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Answer;

public interface AnswerMapper extends BaseMapper<Answer> {
    @Insert("insert into answer (answerId,myAnswer,myScore,state,userId,questionId,taskId) values (#{answerId},#{myAnswer},#{myScore},#{state},#{userId},#{questionId},#{taskId})")
    public void InsertAnswerRecord(String answerId,String myAnswer,Integer myScore,Integer state,String userId,String questionId,String taskId);
}
