package com.xusihan.highschoolmanagementsystem.database.mapper;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.CoursesCustom;

public interface CoursesCustomMapper {

	public List<CoursesCustom> findCoursesCustomList(CoursesCustom coursesCustom) throws Exception;
}
