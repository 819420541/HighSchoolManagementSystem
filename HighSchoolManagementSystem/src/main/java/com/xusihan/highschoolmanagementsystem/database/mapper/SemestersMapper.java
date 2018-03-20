package com.xusihan.highschoolmanagementsystem.database.mapper;

import com.xusihan.highschoolmanagementsystem.po.Semesters;
import com.xusihan.highschoolmanagementsystem.po.SemestersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SemestersMapper {
    int countByExample(SemestersExample example);

    int deleteByExample(SemestersExample example);

    int deleteByPrimaryKey(Integer semesterid);

    int insert(Semesters record);

    int insertSelective(Semesters record);

    List<Semesters> selectByExample(SemestersExample example);

    Semesters selectByPrimaryKey(Integer semesterid);

    int updateByExampleSelective(@Param("record") Semesters record, @Param("example") SemestersExample example);

    int updateByExample(@Param("record") Semesters record, @Param("example") SemestersExample example);

    int updateByPrimaryKeySelective(Semesters record);

    int updateByPrimaryKey(Semesters record);
}