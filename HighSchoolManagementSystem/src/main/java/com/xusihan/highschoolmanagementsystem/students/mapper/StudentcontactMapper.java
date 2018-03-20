package com.xusihan.highschoolmanagementsystem.students.mapper;

import com.xusihan.highschoolmanagementsystem.po.Studentcontact;
import com.xusihan.highschoolmanagementsystem.po.StudentcontactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentcontactMapper {
    int countByExample(StudentcontactExample example);

    int deleteByExample(StudentcontactExample example);

    int deleteByPrimaryKey(Integer studentcontactid);

    int insert(Studentcontact record);

    int insertSelective(Studentcontact record);

    List<Studentcontact> selectByExample(StudentcontactExample example);

    Studentcontact selectByPrimaryKey(Integer studentcontactid);

    int updateByExampleSelective(@Param("record") Studentcontact record, @Param("example") StudentcontactExample example);

    int updateByExample(@Param("record") Studentcontact record, @Param("example") StudentcontactExample example);

    int updateByPrimaryKeySelective(Studentcontact record);

    int updateByPrimaryKey(Studentcontact record);
}