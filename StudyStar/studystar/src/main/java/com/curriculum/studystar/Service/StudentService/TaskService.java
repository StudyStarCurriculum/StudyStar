package com.curriculum.studystar.Service.StudentService;

import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListFinishedResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListResponse;

public interface TaskService {
    public GetTestListResponse GetTestList(String subjectId, String userId);

    public GetTestListFinishedResponse GetTestListFinished(String subjectId, String userId);
}
