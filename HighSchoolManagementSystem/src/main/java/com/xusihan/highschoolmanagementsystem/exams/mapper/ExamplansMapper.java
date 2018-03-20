package com.xusihan.highschoolmanagementsystem.exams.mapper;

import com.xusihan.highschoolmanagementsystem.po.Examplans;
import com.xusihan.highschoolmanagementsystem.po.ExamplansExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamplansMapper {
    int countByExample(ExamplansExample example);

    int deleteByExample(ExamplansExample example);

    int deleteByPrimaryKey(Integer examplanid);

    int insert(Examplans record);

    int insertSelective(Examplans record);

    List<Examplans> selectByExample(ExamplansExample example);

    Examplans selectByPrimaryKey(Integer examplanid);

    int updateByExampleSelective(@Param("record") Examplans record, @Param("example") ExamplansExample example);

    int updateByExample(@Param("record") Examplans record, @Param("example") ExamplansExample example);

    int updateByPrimaryKeySelective(Examplans record);

    int updateByPrimaryKey(Examplans record);
}