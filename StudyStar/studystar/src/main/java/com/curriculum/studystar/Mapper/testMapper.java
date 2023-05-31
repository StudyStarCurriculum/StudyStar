package com.curriculum.studystar.Mapper;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.testObject;

public interface testMapper extends BaseMapper<testObject>{
    @Select("select * from testtable where id = #{id}")
    public testObject getText(Integer id);
}
