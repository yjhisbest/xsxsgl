package com.itheima11.xsxsgl.business.relation.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxtt.b.co;
import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.baseData.dao.ClassDao;
import com.itheima11.xsxsgl.baseData.dao.CourseDao;
import com.itheima11.xsxsgl.baseData.service.ClassService;
import com.itheima11.xsxsgl.basebusiness.service.impl.BaseBusinessSeviceImpl;
import com.itheima11.xsxsgl.business.relation.service.ClassCourseService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.CourseQuery;

@Service("classCourseService")
public class ClassCourseServiceImpl extends BaseBusinessSeviceImpl<Class, Course> implements ClassCourseService{
	@Resource(name="classDao")
	private ClassDao classDao;
	@Resource(name="courseDao")
	private CourseDao courseDao;
	@Override
	public BaseDao<Class> getBaseDao_zhu() {
		return this.classDao;
	}

	@Override
	public BaseDao<Course> getBaseDao_zi() {
		return this.courseDao;
	}
	@Transactional
	public void saveRelation(String bjbh, List<Course> courses) {
		Class clazz = this.classDao.getEntryBId(bjbh);
		if(clazz!=null){
			Set<Course> allcourses = clazz.getCourses();
			for(Course course : courses){
				if(course.getKcbh()!=null && !course.getKcbh().equals("")){
					if(this.classDao.checkUnionKeyCC(clazz.getBjbh(), course.getKcbh())){
						allcourses.add(course);
					}
				}
			}
			clazz.setCourses(allcourses);
		}
		
	}

	public PageResult<Course> getCourseListById(String bjbh,
			BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.courseDao.findClassPageResult(bjbh, baseQuery);
	}
	@Transactional
	public String relationAllCourse(String bjbh) {
		Class clazz = this.classDao.getEntryBId(bjbh);
		clazz.setCourses(null);
		return "deleteOk";
	}
	@Transactional
	public String releaseOneCourse(Course course, String bjbh) {
		Set<Class> classes = course.getClasses();
		Class clazz = this.classDao.getEntryBId(bjbh);
		classes.remove(clazz);
		course.setClasses(classes);
		return "deleteOk";
	}


	
}
