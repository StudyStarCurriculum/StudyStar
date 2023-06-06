package com.curriculum.studystar.Service.Impl.StudentServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Config.RespCode;
import com.curriculum.studystar.Domain.Entity.Course;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetSubjectResponse;
import com.curriculum.studystar.Mapper.CourseMapper;
import com.curriculum.studystar.Mapper.CourseSelectionMapper;
import com.curriculum.studystar.Mapper.UserMapper;
import com.curriculum.studystar.Service.StudentService.DashboardService;
import com.curriculum.studystar.Utils.RandomUID;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    CourseSelectionMapper csMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public GetSubjectResponse GetSubject(String userId) {
        GetSubjectResponse resp = new GetSubjectResponse();
        ArrayList<String> courseId = csMapper.SelectCourseIdByUserId(userId);
        resp.setRespCode(RespCode.OK);
        for(String item : courseId){
            Course c = courseMapper.SelectCourseByCourseId(item);
            String teacherName = userMapper.SelectUserByUserId(c.getTeacherId()).getUserName();
            resp.addData(c.getCourseId(),c.getCourseKey(),c.getCourseName(),teacherName,c.getCourseImagePath(),c.getCourseLevel());
        }
        return resp;
    }

    @Override
    public RespCode JoinSubject(String userId, String key) {
        String subjectId = courseMapper.SelectCourseByCourseKey(key).getCourseId();
        csMapper.InsertCourseSelection(RandomUID.getRandomUID(), userId, subjectId);
        return RespCode.OK;
    }
    
}
