package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Achievements;

public interface AchievementsService {

	/**
	 * addAchievement:添加成绩安排信息
	 * @param achievements
	 * @return
	 */
	public boolean addAchievement(Achievements achievements);
	
	/**
	 * deleteAchievement:删除成绩安排信息
	 * @param achievementid
	 * @return
	 */
	public boolean deleteAchievement(Integer achievementid);
	
	/**
	 * updateAchievement:更新成绩安排数据
	 * @param achievements
	 * @return
	 */
	public boolean updateAchievement(Achievements achievements);
	
	/**
	 * getAchievements:根据成绩编号查询成绩安排信息
	 * @param achievementid
	 * @return
	 */
	public Achievements getAchievement(Integer achievementid);
	
	/**
	 * getAchievementList:根据相关条件查询成绩安排信息
	 * @param achievements
	 * @return
	 */
	public List<Achievements> getAchievementsList(Achievements achievements);

}
