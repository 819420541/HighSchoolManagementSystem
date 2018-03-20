package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.exams.service.AchievementsService;
import com.xusihan.highschoolmanagementsystem.po.Achievements;
import com.xusihan.highschoolmanagementsystem.po.AchievementsExample;
import com.xusihan.highschoolmanagementsystem.po.AchievementsExample.Criteria;
import com.xusihan.highschoolmanagementsystem.students.mapper.AchievementsMapper;

@Service("achievementsServiceImpl")
public class AchievementsServiceImpl implements AchievementsService {

	@Resource(name = "achievementsMapper")
	private AchievementsMapper achievementsMapper;
	
	@Override
	public boolean addAchievement(Achievements achievements) {
		
		try {
			int i =achievementsMapper.insertSelective(achievements);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteAchievement(Integer achievementid) {

		try {
			int i = achievementsMapper.deleteByPrimaryKey(achievementid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateAchievement(Achievements achievements) {

		try {
			int i = achievementsMapper.updateByPrimaryKeySelective(achievements);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Achievements getAchievement(Integer achievementid) {

		return achievementsMapper.selectByPrimaryKey(achievementid);
	}

	@Override
	public List<Achievements> getAchievementsList(Achievements achievements) {

		AchievementsExample achievementsExample = new AchievementsExample();
		Criteria criteria = achievementsExample.createCriteria();
		
		if(achievements!=null) {
			//根据成绩编号查询
			if(achievements.getAchievementid()!=null) {
				criteria.andAchievementidEqualTo(achievements.getAchievementid());
			}
		}
		return achievementsMapper.selectByExample(achievementsExample);
	}
	
}
