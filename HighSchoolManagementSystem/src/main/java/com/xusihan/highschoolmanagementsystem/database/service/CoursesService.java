package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Course;
import com.xusihan.highschoolmanagementsystem.po.CoursesCustom;

public interface CoursesService {
	
	/**
	 * addCourse:��ӿγ���Ϣ
	 * @param course
	 * @return
	 */
	public boolean addCourse(Course course);
	
	/**
	 * deleteCourse:ɾ���γ���Ϣ
	 * @param courseid
	 * @return
	 */
	public boolean deleteCourse(Integer courseid);
	
	/**
	 * updateCourse:���¿γ�����
	 * @param course
	 * @return
	 */
	public boolean updateCourse(Course course);

	/**
	 * getCourses:���ݿγ̱�Ų�ѯ�γ���Ϣ
	 * @param courseid
	 * @return
	 */
	public Course getCourses(Integer courseid);
	
	/**
	 * getCoursesList:�������������ѯ�γ���Ϣ
	 * @param course
	 * @return
	 */
	public List<Course> getCoursesList(Course course);
	
	/**
	 * findCoursesCustomList: ��ѯ�γ̹�����Ϣ
	 * @param coursesCustom
	 * @return
	 */
	public List<CoursesCustom> findCoursesCustomList(CoursesCustom coursesCustom) throws Exception;

}
