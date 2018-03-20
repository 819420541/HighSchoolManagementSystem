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
		// ��Ҫ��װ������
		ActionsCustom actionCustom = new ActionsCustom();
		
		// ��ѯ��������Ӧ�Ļ��Ϣ����װ
		Actions actions = actionsMapper.selectByPrimaryKey(actionid);
		actionCustom.setActions(actions);
		
		// ��ѯ��༶������Ӧ�İ༶��Ϣ����װ
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
		
		// ͨ��������ѯ���������Ļ��Ϣ
		ClassesExample classesExample = new ClassesExample();
		com.xusihan.highschoolmanagementsystem.po.ClassesExample.Criteria criteriaOfClasses = classesExample.createCriteria();
		if(actionsCustom!=null) {
			// ģ����ѯ�༶����
			if(actionsCustom.getClassname()!=null && !actionsCustom.getClassname().equals("")) {
				// ͨ��ģ����ѯ����÷��������İ༶���
				actionsCustom.setClassname("%"+actionsCustom.getClassname()+"%");
				criteriaOfClasses.andClassnameLike(actionsCustom.getClassname());
				List<Classes> listOfClasses = classesMapper.selectByExample(classesExample);
				// ��ѯ�õ��Ļ��Ϣ��Ӧ�Ļ���
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
				
				// ��ѯ�༶���
				if(actionsCustom.getActions().getClassid()!=null) {
					criteriaOfActions.andClassidEqualTo(actionsCustom.getActions().getClassid());
				}
				
				// ��ѯ����
				if(actionsCustom.getActions().getActionid()!=null) {
					criteriaOfActions.andActionidEqualTo(actionsCustom.getActions().getActionid());
				}
				
				// ��ѯ�����
				if(actionsCustom.getActions().getActionname()!=null &&
						!actionsCustom.getActions().getActionname().equals("")) {
					actionsCustom.getActions().setActionname("%"+actionsCustom.getActions().getActionname()+"%");
					criteriaOfActions.andActionnameLike(actionsCustom.getActions().getActionname());
				}				
			}
		}
		// ��ѯ���������Ļ��Ϣ
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
