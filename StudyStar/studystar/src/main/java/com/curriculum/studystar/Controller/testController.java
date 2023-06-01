package com.curriculum.studystar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Domain.Entity.testObject;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.testRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.signInResponse;
import com.curriculum.studystar.Service.Impl.testServiceImpl;
import com.curriculum.studystar.Service.Impl.userServiceImpl;

@RestController
public class testController {
    @Autowired
    userServiceImpl testserver;
    
    @RequestMapping("/hello")
    public signInResponse sayHello(@RequestBody testRequest req){
        signInResponse res=new signInResponse();
        if(req.isNUll()){
            res=testserver.userSignIn(req);
        }
        else{
            res.setResult("数据出错");
        }
        return res;
    }
}
