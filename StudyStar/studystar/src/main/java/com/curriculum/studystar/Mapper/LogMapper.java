package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Log;

public interface LogMapper extends BaseMapper<Log> {
    @Select("select * from log where userId = #{userId}")
    public ArrayList<Log> SelectLogsByUserId(String userId);

    @Insert("insert into log (logId, userId, content, createTime) values (#{logId}, #{userId}, #{content}, #{createTime})")
    public void InsertLog(String logId, String userId, String content, String createTime);
}
