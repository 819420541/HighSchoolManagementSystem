package com.xusihan.highschoolmanagementsystem.database.mapper;

import com.xusihan.highschoolmanagementsystem.po.Coursebooks;
import com.xusihan.highschoolmanagementsystem.po.CoursebooksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoursebooksMapper {
    int countByExample(CoursebooksExample example);

    int deleteByExample(CoursebooksExample example);

    int deleteByPrimaryKey(Integer coursebookid);

    int insert(Coursebooks record);

    int insertSelective(Coursebooks record);

    List<Coursebooks> selectByExample(CoursebooksExample example);

    Coursebooks selectByPrimaryKey(Integer coursebookid);

    int updateByExampleSelective(@Param("record") Coursebooks record, @Param("example") CoursebooksExample example);

    int updateByExample(@Param("record") Coursebooks record, @Param("example") CoursebooksExample example);

    int updateByPrimaryKeySelective(Coursebooks record);

    int updateByPrimaryKey(Coursebooks record);
}