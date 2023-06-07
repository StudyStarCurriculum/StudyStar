package com.curriculum.studystar.Service.StudentService;

import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetMessageResponse;

public interface MessageService {
    public GetMessageResponse GetMessage(String userId);
}
