package com.itheima11.xsxsgl.business.relation.service;

import java.util.List;

import com.itheima11.xsxsgl.basebusiness.service.BaseBusinessSevice;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.CourseQuery;


public interface ClassCourseService extends BaseBusinessSevice<Class, Course>{

	void saveRelation(String bjbh, List<Course> courses);

	PageResult<Course> getCourseListById(String bjbh, BaseQuery baseQuery);

	String relationAllCourse(String bjbh);

	String releaseOneCourse(Course course, String bjbh);


}
