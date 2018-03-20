package com.xusihan.highschoolmanagementsystem.classes.mapper;

import com.xusihan.highschoolmanagementsystem.po.Actions;
import com.xusihan.highschoolmanagementsystem.po.ActionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActionsMapper {
    int countByExample(ActionsExample example);

    int deleteByExample(ActionsExample example);

    int deleteByPrimaryKey(Integer actionid);

    int insert(Actions record);

    int insertSelective(Actions record);

    List<Actions> selectByExample(ActionsExample example);

    Actions selectByPrimaryKey(Integer actionid);

    int updateByExampleSelective(@Param("record") Actions record, @Param("example") ActionsExample example);

    int updateByExample(@Param("record") Actions record, @Param("example") ActionsExample example);

    int updateByPrimaryKeySelective(Actions record);

    int updateByPrimaryKey(Actions record);
}