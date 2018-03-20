package com.xusihan.highschoolmanagementsystem.students.mapper;

import com.xusihan.highschoolmanagementsystem.po.Attendances;
import com.xusihan.highschoolmanagementsystem.po.AttendancesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendancesMapper {
    int countByExample(AttendancesExample example);

    int deleteByExample(AttendancesExample example);

    int deleteByPrimaryKey(Integer attendanceid);

    int insert(Attendances record);

    int insertSelective(Attendances record);

    List<Attendances> selectByExample(AttendancesExample example);

    Attendances selectByPrimaryKey(Integer attendanceid);

    int updateByExampleSelective(@Param("record") Attendances record, @Param("example") AttendancesExample example);

    int updateByExample(@Param("record") Attendances record, @Param("example") AttendancesExample example);

    int updateByPrimaryKeySelective(Attendances record);

    int updateByPrimaryKey(Attendances record);
}