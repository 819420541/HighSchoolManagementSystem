package com.xusihan.highschoolmanagementsystem.database.mapper;

import com.xusihan.highschoolmanagementsystem.po.Projects;
import com.xusihan.highschoolmanagementsystem.po.ProjectsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectsMapper {
    int countByExample(ProjectsExample example);

    int deleteByExample(ProjectsExample example);

    int deleteByPrimaryKey(Integer projectid);

    int insert(Projects record);

    int insertSelective(Projects record);

    List<Projects> selectByExample(ProjectsExample example);

    Projects selectByPrimaryKey(Integer projectid);

    int updateByExampleSelective(@Param("record") Projects record, @Param("example") ProjectsExample example);

    int updateByExample(@Param("record") Projects record, @Param("example") ProjectsExample example);

    int updateByPrimaryKeySelective(Projects record);

    int updateByPrimaryKey(Projects record);
}