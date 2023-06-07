package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Message;

public interface MessageMapper extends BaseMapper<Message> {
    @Select("select * from message where  receiverId = #{userId}")
    public ArrayList<Message> SelectMessageByReceiverId(String userId);
}
