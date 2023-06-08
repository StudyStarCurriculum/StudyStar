package com.curriculum.studystar.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.curriculum.studystar.Domain.Entity.Correction;

public interface CorrectionMapper extends BaseMapper<Correction> {
    @Insert("insert into correction (correctionId,createTime,userId,questionId,wrongAnswer) values (#{correctionId},#{createTime},#{userId},#{questionId},#{wrongAnswer})")
    public void InsertCorrectionRecord(String correctionId,String createTime,String userId,String questionId,String wrongAnswer);
    
    @Select("select * from correction where userId = #{userId}")
    public ArrayList<Correction> SelectCorrectionByUserId(String userId); 

    @Select("select * from correction where correctionId = #{correctionId}")
    public Correction SelectCorrectionByCorrectionId(String correctionId);
}
