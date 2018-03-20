package com.xusihan.highschoolmanagementsystem.exams.mapper;

import com.xusihan.highschoolmanagementsystem.po.Exams;
import com.xusihan.highschoolmanagementsystem.po.ExamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamsMapper {
    int countByExample(ExamsExample example);

    int deleteByExample(ExamsExample example);

    int deleteByPrimaryKey(Integer examid);

    int insert(Exams record);

    int insertSelective(Exams record);

    List<Exams> selectByExample(ExamsExample example);

    Exams selectByPrimaryKey(Integer examid);

    int updateByExampleSelective(@Param("record") Exams record, @Param("example") ExamsExample example);

    int updateByExample(@Param("record") Exams record, @Param("example") ExamsExample example);

    int updateByPrimaryKeySelective(Exams record);

    int updateByPrimaryKey(Exams record);
}