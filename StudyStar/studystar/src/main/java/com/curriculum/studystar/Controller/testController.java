package com.curriculum.studystar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.studystar.Domain.Entity.testObject;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.testRequest;
import com.curriculum.studystar.Service.Impl.testServiceImpl;

@RestController
public class testController {
    @Autowired
    testServiceImpl testserver;
    
    @RequestMapping("/hello")
    public testObject sayHello(@RequestBody testRequest req){
        return testserver.getText(req.getId());
    }
}
