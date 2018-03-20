package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.AchievementsCustom;

public interface AchievementsCustomService {


	/**
	 * getAchievementsCustom:��ѯ���԰�����Ϣ
	 * @param achievementid
	 * @return
	 */
	public AchievementsCustom getAchievementsCustom(Integer achievementid);
	
	/**
	 * getAchievementsCustomList:��ѯ���԰�����Ϣ
	 * @param achievementsCustom
	 * @return
	 */
	public List<AchievementsCustom> getAchievementsCustomList(AchievementsCustom achievementsCustom);
	
}
