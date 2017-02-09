package com.itheima11.xsxsgl.baseData.service;

import com.itheima11.xsxsgl.base.service.BaseSerivce;
import com.itheima11.xsxsgl.domain.basedata.Course;

public interface CourseService extends BaseSerivce<Course>{
	String checkSetIsNot(String id);

	String checkCollegesSetIsNot(String[] ids);
}
