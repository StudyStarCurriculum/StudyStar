package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Question;

public interface QuestionMapper extends BaseMapper<Question>{
    @Insert("insert into question(questionId,analysis,answer,chapter,courseId,description,difficult,options,questionType,questionFilePath,score) values (#{questionId},#{analysis},#{answer},#{chapter},#{courseId},#{description},#{difficult},#{options},#{questionType},#{questionFilePath},#{score})")
    public void InsertQuestion(String questionId,String analysis,String answer,String chapter,String courseId,String description,int difficult,String options, int questionType,String questionFilePath,int score);

    @Select("select * from question where questionId = #{questionId}")
    public Question SelectQuestionByQuestionId(String questionId);

    @Update("update question set analysis=#{analysis},answer=#{answer},description=#{description},difficult=#{difficult},options=#{options},questionType=#{questionType},score=#{score} where questionId=#{questionId}")
    public void UpdataQuestion(String analysis,String answer,String description,int difficult,String options,int questionType,int score,String questionId);
}
/*
 * @Insert("insert into course_selection (selectionId,studentId,courseId) values (#{selectionId}, #{studentId}, #{courseId})")
    public void InsertCourseSelection(String selectionId,String studentId,String courseId);
    @Update("update user set password = #{newPassword} where userId = #{userId}")
    public void UpdatePassword(String newPassword, String userId);
*/
