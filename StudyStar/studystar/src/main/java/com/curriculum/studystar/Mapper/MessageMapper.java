package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Insert;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Message;

public interface MessageMapper extends BaseMapper<Message>{
    @Insert("insert into message(messageId,content,isRead,receiverId,sendTime,senderId,title) values (#{messageId},#{content},#{isRead},#{receiverId},#{sendTime},#{senderId},#{title})")
    public void InsertMessage(String messageId,String content,int isRead,String receiverId,String sendTime,String senderId,String title);
}
/*
 * @Insert("insert into course_selection (selectionId,studentId,courseId) values (#{selectionId}, #{studentId}, #{courseId})")
    public void InsertCourseSelection(String selectionId,String studentId,String courseId);
    @Update("update user set password = #{newPassword} where userId = #{userId}")
    public void UpdatePassword(String newPassword, String userId);
*/