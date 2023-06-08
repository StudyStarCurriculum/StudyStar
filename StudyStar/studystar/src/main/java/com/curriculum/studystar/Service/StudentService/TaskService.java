package com.curriculum.studystar.Service.StudentService;

import java.util.List;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.RequestData.AnswerReq;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.AnswerShowResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListFinishedResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetTestListResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.StartTestResponse;

public interface TaskService {
    public GetTestListResponse GetTestList(String subjectId, String userId);

    public GetTestListFinishedResponse GetTestListFinished(String subjectId, String userId);

    public StartTestResponse StartTest(String taskId);

    public RespCode SubmitTest(List<AnswerReq> req,String userId,String taskId);

    public AnswerShowResponse AnswerShow(String taskId,String userId);
}
