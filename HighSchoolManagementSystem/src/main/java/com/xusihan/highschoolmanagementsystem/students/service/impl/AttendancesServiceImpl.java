package com.xusihan.highschoolmanagementsystem.students.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.po.Attendances;
import com.xusihan.highschoolmanagementsystem.po.AttendancesExample;
import com.xusihan.highschoolmanagementsystem.po.AttendancesExample.Criteria;
import com.xusihan.highschoolmanagementsystem.students.mapper.AttendancesMapper;
import com.xusihan.highschoolmanagementsystem.students.service.AttendancesService;

@Service("attendancesServiceImpl")
public class AttendancesServiceImpl implements AttendancesService {

	@Resource(name = "attendancesMapper")
	private AttendancesMapper attendancesMapper;
	
	@Override
	public boolean addAttendance(Attendances sttendances) {

		try {
			int i =attendancesMapper.insertSelective(sttendances);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteAttendance(Integer attendanceid) {

		try {
			int i = attendancesMapper.deleteByPrimaryKey(attendanceid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateAttendance(Attendances attendances) {

		try {
			int i = attendancesMapper.updateByPrimaryKeySelective(attendances);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Attendances getAttendance(Integer attendanceid) {
		
		return attendancesMapper.selectByPrimaryKey(attendanceid);
		
	}

	@Override
	public List<Attendances> getAttendancesList(Attendances attendances) {

		AttendancesExample attendancesExample = new AttendancesExample();
		Criteria criteria = attendancesExample.createCriteria();
		
		if(attendances!=null) {
			//¸ù¾Ý¿¼ÇÚ±àºÅ²éÑ¯
			if(attendances.getAttendanceid()!=null){
				criteria.andStudentidEqualTo(attendances.getAttendanceid());
			}
		}
		return attendancesMapper.selectByExample(attendancesExample);
	
	}

}
