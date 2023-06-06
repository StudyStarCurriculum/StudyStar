package com.curriculum.studystar.Service.StudentService;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetSubjectResponse;

public interface DashboardService {
    public GetSubjectResponse GetSubject(String userId);

    public RespCode JoinSubject(String userId, String key);
}
