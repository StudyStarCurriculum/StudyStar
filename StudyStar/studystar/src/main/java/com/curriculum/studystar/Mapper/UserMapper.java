package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.User;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where userName = #{username}")
    public User SelectUserByUserName(String username);

    @Select("select * from user where userId = #{userId}")
    public User SelectUserByUserId(Integer userId);

    @Insert("insert into user (userName, password, role) values (#{username}, #{password}, #{role})")
    public void InsertUser(String username, String password, Integer role);

    @Update("update user set realName = #{realName}, userLevel = #{userLevel}, sex = #{sex}, age = #{age}, phone = #{phone}, userImagePath = #{userImagePath} where userId = #{userId}")
    public void UpdateUserInfo(String realName, Integer userLevel, Integer sex, Integer age, String phone,
            String userImagePath, Integer userId);

    @Update("update user set password = #{newPassword} where userId = #{userId}")
    public void UpdatePassword(String newPassword, Integer userId);
}
