package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Answer;

public interface AnswerMapper extends BaseMapper<Answer> {
    @Insert("insert into answer (answerId,myAnswer,myScore,state,userId,questionId,taskId) values (#{answerId},#{myAnswer},#{myScore},#{state},#{userId},#{questionId},#{taskId})")
    public void InsertAnswerRecord(String answerId,String myAnswer,Integer myScore,Integer state,String userId,String questionId,String taskId);

    @Select("select * from answer where userId = #{userId} and taskId = #{taskId} and questionId = #{questionId}")
    public Answer SelectAnswerById(String userId,String taskId,String questionId);

    @Update("update answer set myScore = #{myScore}, state = #{state} where userId = #{userId} and taskId = #{taskId} and questionId = #{questionId}")
    public void UpdateAnswerAfterCorrection(Integer myScore, Integer state, String userId, String taskId, String questionId);
}
