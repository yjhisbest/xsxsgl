package com.itheima11.xsxsgl.business.relation.service;

import java.util.List;

import com.itheima11.xsxsgl.basebusiness.service.BaseBusinessSevice;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Teacher;

public interface TeacherCourseService extends BaseBusinessSevice<Teacher, Course>{

	void saveRelation(String jsbh, List<Course> courses);

	String releaseAllCourse(String jsbh);

	String releaseOneCourse(Course course);

}
