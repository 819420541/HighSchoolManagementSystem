package com.xusihan.highschoolmanagementsystem.exams.mapper;

import com.xusihan.highschoolmanagementsystem.po.Examtypes;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamtypesMapper {
    int countByExample(ExamtypesExample example);

    int deleteByExample(ExamtypesExample example);

    int deleteByPrimaryKey(Integer examtypeid);

    int insert(Examtypes record);

    int insertSelective(Examtypes record);

    List<Examtypes> selectByExample(ExamtypesExample example);

    Examtypes selectByPrimaryKey(Integer examtypeid);

    int updateByExampleSelective(@Param("record") Examtypes record, @Param("example") ExamtypesExample example);

    int updateByExample(@Param("record") Examtypes record, @Param("example") ExamtypesExample example);

    int updateByPrimaryKeySelective(Examtypes record);

    int updateByPrimaryKey(Examtypes record);
}