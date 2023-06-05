package com.curriculum.studystar.Domain.RequestAndResponse.Response.UserResponse;

import java.util.ArrayList;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.Entity.Log;

import lombok.Data;

@Data
public class GetLogResponse {
    private RespCode respCode;
    private ArrayList<Log> respData = new ArrayList<Log>();

    public void addData(Log l) {
        respData.add(l);
    }
}
