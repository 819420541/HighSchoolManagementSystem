package com.xusihan.highschoolmanagementsystem.students.mapper;

import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentsbaseMapper {
    int countByExample(StudentsbaseExample example);

    int deleteByExample(StudentsbaseExample example);

    int deleteByPrimaryKey(Integer studentid);

    int insert(Studentsbase record);

    int insertSelective(Studentsbase record);

    List<Studentsbase> selectByExample(StudentsbaseExample example);

    Studentsbase selectByPrimaryKey(Integer studentid);

    int updateByExampleSelective(@Param("record") Studentsbase record, @Param("example") StudentsbaseExample example);

    int updateByExample(@Param("record") Studentsbase record, @Param("example") StudentsbaseExample example);

    int updateByPrimaryKeySelective(Studentsbase record);

    int updateByPrimaryKey(Studentsbase record);
}