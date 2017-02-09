package com.itheima11.xsxsgl.business.relation.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxtt.a.c;
import com.hxtt.global.t;
import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.baseData.dao.CourseDao;
import com.itheima11.xsxsgl.baseData.dao.TeacherDao;
import com.itheima11.xsxsgl.basebusiness.service.impl.BaseBusinessSeviceImpl;
import com.itheima11.xsxsgl.business.relation.service.TeacherCourseService;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Teacher;

@Service("teacherCourseService")
public class TeacherCourseServiceImpl extends BaseBusinessSeviceImpl<Teacher, Course> implements TeacherCourseService{
	@Resource(name="teacherDao")
	private TeacherDao teacherDao;
	@Resource(name="courseDao")
	private CourseDao courseDao;
	@Override
	public BaseDao<Teacher> getBaseDao_zhu() {
		return this.teacherDao;
	}

	@Override
	public BaseDao<Course> getBaseDao_zi() {
		return this.courseDao;
	}
	@Transactional
	public void saveRelation(String jsbh, List<Course> courses) {
		Teacher teacher = this.teacherDao.getEntryBId(jsbh);
		if(teacher!=null){
			for(Course course : courses){
				if(course.getKcbh()!=null && !course.getKcbh().equals("")){
					Course initcCourse = this.courseDao.getEntryBId(course.getKcbh());
					initcCourse.setTeacher(teacher);
					initcCourse.setJsmc(teacher.getJsmc());
				}
			}
		}
	}
	@Transactional
	public String releaseAllCourse(String jsbh) {
		Teacher teacher = this.teacherDao.getEntryBId(jsbh);
		Set<Course> courses = teacher.getCourses();
		for(Course course : courses){
			course.setJsmc(null);
		}
		teacher.setCourses(null);
		return "deleteOk";
	}
	@Transactional
	public String releaseOneCourse(Course course) {
		course.setTeacher(null);
		course.setJsmc(null);
		return "deleteOk";
	}

}
