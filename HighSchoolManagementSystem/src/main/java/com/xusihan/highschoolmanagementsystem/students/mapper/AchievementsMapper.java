package com.xusihan.highschoolmanagementsystem.students.mapper;

import com.xusihan.highschoolmanagementsystem.po.Achievements;
import com.xusihan.highschoolmanagementsystem.po.AchievementsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AchievementsMapper {
    int countByExample(AchievementsExample example);

    int deleteByExample(AchievementsExample example);

    int deleteByPrimaryKey(Integer achievementid);

    int insert(Achievements record);

    int insertSelective(Achievements record);

    List<Achievements> selectByExample(AchievementsExample example);

    Achievements selectByPrimaryKey(Integer achievementid);

    int updateByExampleSelective(@Param("record") Achievements record, @Param("example") AchievementsExample example);

    int updateByExample(@Param("record") Achievements record, @Param("example") AchievementsExample example);

    int updateByPrimaryKeySelective(Achievements record);

    int updateByPrimaryKey(Achievements record);
}