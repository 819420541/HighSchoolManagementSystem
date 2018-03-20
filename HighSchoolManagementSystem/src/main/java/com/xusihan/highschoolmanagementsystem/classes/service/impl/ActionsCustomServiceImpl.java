package com.xusihan.highschoolmanagementsystem.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.classes.mapper.ActionsMapper;
import com.xusihan.highschoolmanagementsystem.classes.mapper.ClassesMapper;
import com.xusihan.highschoolmanagementsystem.classes.service.ActionsCustomService;
import com.xusihan.highschoolmanagementsystem.po.Actions;
import com.xusihan.highschoolmanagementsystem.po.ActionsCustom;
import com.xusihan.highschoolmanagementsystem.po.ActionsExample;
import com.xusihan.highschoolmanagementsystem.po.ActionsExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.ClassesExample;

@Service("actionsCustomServiceImpl")
public class ActionsCustomServiceImpl implements ActionsCustomService {

	@Resource(name = "actionsMapper")
	private ActionsMapper actionsMapper;
	
	@Resource(name = "classesMapper")
	private ClassesMapper classesMapper;
	
	@Override
	public ActionsCustom getActionCustom(Integer actionid) {
		// 需要封装的属性
		ActionsCustom actionCustom = new ActionsCustom();
		
		// 查询与活动编号相对应的活动信息并封装
		Actions actions = actionsMapper.selectByPrimaryKey(actionid);
		actionCustom.setActions(actions);
		
		// 查询与班级编号相对应的班级信息并封装
		Integer classId = actions.getClassid();
		Classes classesInfo = classesMapper.selectByPrimaryKey(classId);
		String className = classesInfo.getClassname();
		actionCustom.setClassname(className);
		
		return actionCustom;
	}

	@Override
	public List<ActionsCustom> getActionsCustomList(ActionsCustom actionsCustom) {
		
		ActionsExample actionsExample = new ActionsExample();
		Criteria criteriaOfActions = actionsExample.createCriteria();
		
		// 通过条件查询符合条件的活动信息
		ClassesExample classesExample = new ClassesExample();
		com.xusihan.highschoolmanagementsystem.po.ClassesExample.Criteria criteriaOfClasses = classesExample.createCriteria();
		if(actionsCustom!=null) {
			// 模糊查询班级名称
			if(actionsCustom.getClassname()!=null && !actionsCustom.getClassname().equals("")) {
				// 通过模糊查询来获得符合条件的班级编号
				actionsCustom.setClassname("%"+actionsCustom.getClassname()+"%");
				criteriaOfClasses.andClassnameLike(actionsCustom.getClassname());
				List<Classes> listOfClasses = classesMapper.selectByExample(classesExample);
				// 查询得到的活动信息对应的活动编号
				List<Integer> listOfClassesId = new ArrayList<>();
				for(Classes classes:listOfClasses) {
					listOfClassesId.add(classes.getClassid());
				}
				
				if(listOfClassesId.isEmpty()) {
					criteriaOfActions.andClassidIn(null);
				}else {
					criteriaOfActions.andClassidIn(listOfClassesId);
				}
			}
			
			if(actionsCustom.getActions()!=null) {
				
				// 查询班级编号
				if(actionsCustom.getActions().getClassid()!=null) {
					criteriaOfActions.andClassidEqualTo(actionsCustom.getActions().getClassid());
				}
				
				// 查询活动编号
				if(actionsCustom.getActions().getActionid()!=null) {
					criteriaOfActions.andActionidEqualTo(actionsCustom.getActions().getActionid());
				}
				
				// 查询活动名称
				if(actionsCustom.getActions().getActionname()!=null &&
						!actionsCustom.getActions().getActionname().equals("")) {
					actionsCustom.getActions().setActionname("%"+actionsCustom.getActions().getActionname()+"%");
					criteriaOfActions.andActionnameLike(actionsCustom.getActions().getActionname());
				}				
			}
		}
		// 查询符合条件的活动信息
		List<Actions> listOfActions = actionsMapper.selectByExample(actionsExample);
		if(listOfActions!=null) {
			List<ActionsCustom> listOfActionsCustom = new ArrayList<>();
			for(Actions actionsList:listOfActions) {
				ActionsCustom actionsCustomInfo = this.getActionCustom(actionsList.getActionid());
				listOfActionsCustom.add(actionsCustomInfo);
			}
			return listOfActionsCustom;
		}else {
			return null;
		}
	}

}
