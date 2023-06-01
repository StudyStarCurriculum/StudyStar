package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.User;

public interface UserMapper extends BaseMapper<User>{
    @Select("select * from user where user_name = #{username}")
    public User FindUserByUserName(String username);
}
