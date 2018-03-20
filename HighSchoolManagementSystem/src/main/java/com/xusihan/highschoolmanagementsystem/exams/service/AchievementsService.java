package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Achievements;

public interface AchievementsService {

	/**
	 * addAchievement:��ӳɼ�������Ϣ
	 * @param achievements
	 * @return
	 */
	public boolean addAchievement(Achievements achievements);
	
	/**
	 * deleteAchievement:ɾ���ɼ�������Ϣ
	 * @param achievementid
	 * @return
	 */
	public boolean deleteAchievement(Integer achievementid);
	
	/**
	 * updateAchievement:���³ɼ���������
	 * @param achievements
	 * @return
	 */
	public boolean updateAchievement(Achievements achievements);
	
	/**
	 * getAchievements:���ݳɼ���Ų�ѯ�ɼ�������Ϣ
	 * @param achievementid
	 * @return
	 */
	public Achievements getAchievement(Integer achievementid);
	
	/**
	 * getAchievementList:�������������ѯ�ɼ�������Ϣ
	 * @param achievements
	 * @return
	 */
	public List<Achievements> getAchievementsList(Achievements achievements);

}
