package com.curriculum.studystar.Domain.RequestAndResponse.Request;

import lombok.Data;

@Data
public class testRequest {
    private String username;
    private String password;

    public boolean isNUll(){
        if(username==null||password==null){
            return false;
        }
        else{
            return true;
        }
    }
}
