package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.database.mapper.SchoolsMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamtypesMapper;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamtypesCustomService;
import com.xusihan.highschoolmanagementsystem.po.Examtypes;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesCustom;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesExample;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.SchoolsExample;

@Service("examtypesCustomServiceImpl")
public class ExamtypesCustomServiceImpl implements ExamtypesCustomService {

	@Resource(name = "examtypesMapper")
	private ExamtypesMapper examtypesMapper;
	
	@Resource(name = "schoolsMapper")
	private SchoolsMapper schoolsMapper;
	
	@Override
	public ExamtypesCustom getExamtypesCustom(Integer examtypeid) {
		
		// 需要封装的属性
		ExamtypesCustom examtypesCustom = new ExamtypesCustom();
		
		// 查询与考试类型编号相对应的考试类型信息并封装
		Examtypes examtypes = examtypesMapper.selectByPrimaryKey(examtypeid);
		examtypesCustom.setExamtypes(examtypes);
		
		// 查询与学校编号相对应的学校名称并封装
		Integer schoolId = examtypes.getSchoolid();
		Schools schoolInfo = schoolsMapper.selectByPrimaryKey(schoolId);
		String schoolName = schoolInfo.getSchoolname();
		examtypesCustom.setSchoolname(schoolName);
		
		return examtypesCustom;
	}

	@Override
	public List<ExamtypesCustom> getExamtypesCustomList(ExamtypesCustom examtypesCustom) {
		
		ExamtypesExample examtypesExample = new ExamtypesExample();
		Criteria criteriaOfExamtypes = examtypesExample.createCriteria();
		criteriaOfExamtypes.andExamtypestateEqualTo(1);
		
		//通过条件查询符合条件的考试类型信息
		SchoolsExample schoolsExample = new SchoolsExample();
		com.xusihan.highschoolmanagementsystem.po.SchoolsExample.Criteria criteriaOfSchools = schoolsExample.createCriteria();
		criteriaOfSchools.andSchoolstateEqualTo(1);
		if(examtypesCustom!=null) {
			// 模糊查询学校名称
			if(examtypesCustom.getSchoolname()!= null && !examtypesCustom.getSchoolname().equals("") ) {
				// 通过模糊查询来获得符合条件的教材编号
				examtypesCustom.setSchoolname("%"+examtypesCustom.getSchoolname()+"%");
				criteriaOfSchools.andSchoolnameLike(examtypesCustom.getSchoolname());
				List<Schools> listOfSchools = schoolsMapper.selectByExample(schoolsExample);
				// 查询得到的教材信息对应的教材编号
				List<Integer> listOfSchoolIds = new ArrayList<>();
				for(Schools schoolsList:listOfSchools) {
					listOfSchoolIds.add(schoolsList.getSchoolid());
				}
				
				if(!listOfSchoolIds.isEmpty()) {
					criteriaOfExamtypes.andSchoolidIn(listOfSchoolIds);
				}
			}
			
			if(examtypesCustom.getExamtypes()!=null) {
				
				// 查询学校编号
				if(examtypesCustom.getExamtypes().getSchoolid()!=null ) {
					criteriaOfExamtypes.andSchoolidEqualTo(examtypesCustom.getExamtypes().getSchoolid());
				}
				
				// 查询考试类型编号
				if(examtypesCustom.getExamtypes().getExamtypeid()!= null ) {
					criteriaOfExamtypes.andExamtypeidEqualTo(examtypesCustom.getExamtypes().getExamtypeid());
				}
				
				// 查询考试类型名称
				if(examtypesCustom.getExamtypes().getExamtypename()!=null && !examtypesCustom.getExamtypes().getExamtypename().equals("")) {
					examtypesCustom.getExamtypes().setExamtypename("%"+examtypesCustom.getExamtypes().getExamtypename()+"%");
					criteriaOfExamtypes.andExamtypenameLike(examtypesCustom.getExamtypes().getExamtypename());
				}
			}
		}
		// 查询符合条件的考试类型信息
		List<Examtypes> listOfExamtypes = examtypesMapper.selectByExample(examtypesExample);
		if(listOfExamtypes!=null) {
			List<ExamtypesCustom> listOfExamtypesCustom = new ArrayList<>();
			for(Examtypes examtypesList:listOfExamtypes) {
				ExamtypesCustom examtypesCustomInfo = this.getExamtypesCustom(examtypesList.getExamtypeid());
				listOfExamtypesCustom.add(examtypesCustomInfo);
			}
			return listOfExamtypesCustom;
		}else {
			return null;
		}
		
	}

}
