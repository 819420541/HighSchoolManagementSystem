package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.AchievementsCustom;

public interface AchievementsCustomService {


	/**
	 * getAchievementsCustom:查询考试安排信息
	 * @param achievementid
	 * @return
	 */
	public AchievementsCustom getAchievementsCustom(Integer achievementid);
	
	/**
	 * getAchievementsCustomList:查询考试安排信息
	 * @param achievementsCustom
	 * @return
	 */
	public List<AchievementsCustom> getAchievementsCustomList(AchievementsCustom achievementsCustom);
	
}
