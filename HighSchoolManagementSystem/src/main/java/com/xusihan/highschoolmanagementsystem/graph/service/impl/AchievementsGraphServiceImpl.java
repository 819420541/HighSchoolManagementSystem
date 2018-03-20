package com.xusihan.highschoolmanagementsystem.graph.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jfree.data.category.DefaultCategoryDataset;
import com.xusihan.highschoolmanagementsystem.exams.service.AchievementsService;
import com.xusihan.highschoolmanagementsystem.graph.service.AchievementsGraphService;
import com.xusihan.highschoolmanagementsystem.po.Achievements;

public class AchievementsGraphServiceImpl implements AchievementsGraphService {

	@Resource(name = "achievementsServiceImpl")
	private AchievementsService achievementsService;
	
	@Override
	public DefaultCategoryDataset getdataset() {
		List<Achievements> listOfAchievements = achievementsService.getAchievementsList(null);
		int gradeA = 0;		// >=100
		int gradeB = 0;		// 90<= <100
		int gradeC = 0;		// 80<= <90
		int gradeD = 0;		// 70<= <80
		int gradeE = 0;		// 60<= <70
		int gradeF = 0;		// <60
		
		for(Achievements achievementsList:listOfAchievements) {
			String str = achievementsList.getResult();
			try {
			    int score = Integer.parseInt(str);
			    switch( score/10) {
			    	case 0:
			    	case 1:
			    	case 2:
			    	case 3:
			    	case 4:
			    	case 5:	gradeF = gradeF+1;break;
			    	case 6:	gradeE = gradeE+1;break;
			    	case 7:	gradeD = gradeD+1;break;
			    	case 8:	gradeC = gradeC+1;break;
			    	case 9:	gradeB = gradeB+1;break;
			    	case 10:gradeA = gradeA+1;break;		
				}
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
		}
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.setValue(gradeA, "A", "满分");
		dataset.setValue(gradeB, "B", "优秀");
		dataset.setValue(gradeC, "C", "良好");
		dataset.setValue(gradeD, "D", "一般");
		dataset.setValue(gradeE, "E", "及格");
		dataset.setValue(gradeF, "F", "不及格");
		return dataset;
	}

}
