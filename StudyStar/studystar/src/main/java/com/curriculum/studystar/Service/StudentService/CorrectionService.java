package com.curriculum.studystar.Service.StudentService;

import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetCorrectionDetailsResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Student.GetCorrectionResponse;

public interface CorrectionService {
    public GetCorrectionResponse GetWrongQuestion(String userId);

    public GetCorrectionDetailsResponse GetCorrectionDetails(String correctionId);
}
