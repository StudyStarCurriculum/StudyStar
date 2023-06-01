package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.user;

public interface userMapper extends BaseMapper<user>{
    @Select("select * from user where username=#{username}")
    public user getUserByusername(String username);
}
