package com.curriculum.studystar.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Domain.Entity.user;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.testRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.signInResponse;
import com.curriculum.studystar.Mapper.userMapper;
import com.curriculum.studystar.Service.userService;

@Service
public class userServiceImpl implements userService{

    @Autowired
    userMapper usermp;

    @Override
    public signInResponse userSignIn(testRequest test) {
       String username=test.getUsername();
       String pass=test.getPassword();
       signInResponse response=new signInResponse();

       user testuser=usermp.getUserByusername(username);
       if(testuser==null){
            response.setResult("pass");
       }
       else if(testuser.getPassword().equals(pass)){
            response.setResult("yes");
       }
       else if(!testuser.getPassword().equals(pass)){
        response.setResult("no");
       }
       return response;
    }
    
}
