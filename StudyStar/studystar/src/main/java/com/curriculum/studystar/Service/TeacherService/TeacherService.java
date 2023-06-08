package com.curriculum.studystar.Service.TeacherService;

import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.AnswerListRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.CourseEditRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.MessageSendRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.QuestionEditRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.StudentListRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.AnswerListResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.CourseDetailsResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.CourseListResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.MessageSendResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.QuestionDetailsResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.StudentListResponse;


public interface TeacherService {
    //获取课程列表
    public CourseListResponse CourseList(String teacherId);

    //获取学生列表
    public StudentListResponse StudentList(StudentListRequest req, String teacherId);

    //获取答卷列表
    public AnswerListResponse AnswerList(AnswerListRequest req, String teacherId);

    //编辑课程
    public void CourseEdit(CourseEditRequest req, String teacherId);

    //课程详情
    public CourseDetailsResponse CourseDetails(String id);

    //发送消息
    public MessageSendResponse SendMessage(MessageSendRequest req, String teacherId);

    //编辑题目
    public void EditQuestion(QuestionEditRequest req);

    //题目详情
    public QuestionDetailsResponse QuestionDetail(String id);
}
