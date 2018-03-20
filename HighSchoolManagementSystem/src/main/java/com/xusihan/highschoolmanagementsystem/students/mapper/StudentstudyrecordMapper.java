package com.xusihan.highschoolmanagementsystem.students.mapper;

import com.xusihan.highschoolmanagementsystem.po.Studentstudyrecord;
import com.xusihan.highschoolmanagementsystem.po.StudentstudyrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentstudyrecordMapper {
    int countByExample(StudentstudyrecordExample example);

    int deleteByExample(StudentstudyrecordExample example);

    int deleteByPrimaryKey(Integer studyrecordid);

    int insert(Studentstudyrecord record);

    int insertSelective(Studentstudyrecord record);

    List<Studentstudyrecord> selectByExample(StudentstudyrecordExample example);

    Studentstudyrecord selectByPrimaryKey(Integer studyrecordid);

    int updateByExampleSelective(@Param("record") Studentstudyrecord record, @Param("example") StudentstudyrecordExample example);

    int updateByExample(@Param("record") Studentstudyrecord record, @Param("example") StudentstudyrecordExample example);

    int updateByPrimaryKeySelective(Studentstudyrecord record);

    int updateByPrimaryKey(Studentstudyrecord record);
}