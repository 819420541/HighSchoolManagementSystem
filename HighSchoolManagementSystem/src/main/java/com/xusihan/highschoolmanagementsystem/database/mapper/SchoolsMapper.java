package com.xusihan.highschoolmanagementsystem.database.mapper;

import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.SchoolsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolsMapper {
    int countByExample(SchoolsExample example);

    int deleteByExample(SchoolsExample example);

    int deleteByPrimaryKey(Integer schoolid);

    int insert(Schools record);

    int insertSelective(Schools record);

    List<Schools> selectByExample(SchoolsExample example);

    Schools selectByPrimaryKey(Integer schoolid);

    int updateByExampleSelective(@Param("record") Schools record, @Param("example") SchoolsExample example);

    int updateByExample(@Param("record") Schools record, @Param("example") SchoolsExample example);

    int updateByPrimaryKeySelective(Schools record);

    int updateByPrimaryKey(Schools record);
}