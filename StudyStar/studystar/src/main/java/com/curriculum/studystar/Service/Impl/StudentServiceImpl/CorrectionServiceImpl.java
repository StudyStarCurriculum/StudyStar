package com.curriculum.studystar.Service.Impl.StudentServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Domain.Entity.Correction;
import com.curriculum.studystar.Domain.Entity.Question;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetCorrectionResponse;
import com.curriculum.studystar.Mapper.CorrectionMapper;
import com.curriculum.studystar.Mapper.CourseMapper;
import com.curriculum.studystar.Mapper.QuestionMapper;
import com.curriculum.studystar.Service.StudentService.CorrectionService;

@Service
public class CorrectionServiceImpl implements CorrectionService {
    @Autowired
    CorrectionMapper correctionMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired 
    CourseMapper courseMapper;

    @Override
    public GetCorrectionResponse GetWrongQuestion(String userId) {
        GetCorrectionResponse resp = new GetCorrectionResponse();
        ArrayList<Correction> wrongQuestion = correctionMapper.SelectCorrectionByUserId(userId);
        Integer total = 0;

        for(Correction item : wrongQuestion){
            String correctionId = item.getCorrectionId();
            String createTime = item.getCreateTime();

            String questionId = item.getQuestionId();
            Question question = questionMapper.SelectQuestionByQuestionId(questionId);
            Integer questionType = question.getQuestionType();
            String subjectName = courseMapper.SelectCourseByCourseId(question.getCourseId()).getCourseName();
            
            String title = question.getDescription();
            String shortTitle;
            if(title.length()<=10)
                shortTitle = title;
            else
                shortTitle = title.substring(0, 9) + "……";

            resp.addData(correctionId, questionType, createTime, subjectName, shortTitle);
            total++;
        }
        resp.setTotal(total);

        return resp;
    }
    
}
