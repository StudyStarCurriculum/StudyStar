package com.curriculum.studystar.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Domain.Entity.testObject;
import com.curriculum.studystar.Mapper.testMapper;
import com.curriculum.studystar.Service.testService;

@Service
public class testServiceImpl implements testService{
    @Autowired
    testMapper tMapper;

    @Override
    public testObject getText(Integer id) {
        return tMapper.getText(id);
    }
    
}
