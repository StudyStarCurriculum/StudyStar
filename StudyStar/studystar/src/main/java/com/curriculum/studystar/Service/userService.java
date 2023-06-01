package com.curriculum.studystar.Service;

import com.curriculum.studystar.Domain.RequestAndResponse.Request.testRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.signInResponse;

public interface userService {
    public signInResponse userSignIn(testRequest test);
}
