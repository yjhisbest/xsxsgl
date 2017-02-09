package com.itheima11.xsxsgl.business.relation.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.baseData.dao.ClassDao;
import com.itheima11.xsxsgl.baseData.dao.TeacherDao;
import com.itheima11.xsxsgl.basebusiness.service.impl.BaseBusinessSeviceImpl;
import com.itheima11.xsxsgl.business.relation.service.ClassTeacherService;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Major;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.TeacherQuery;

@Service("classTeacherService")
public class ClassTeacherServiceImpl extends BaseBusinessSeviceImpl<Class, Teacher> implements ClassTeacherService{
	@Resource(name="teacherDao")
	private TeacherDao teacherDao;
	@Resource(name="classDao")
	private ClassDao classDao;
	@Override
	public BaseDao<Class> getBaseDao_zhu() {
		// TODO Auto-generated method stub
		return this.classDao;
	}

	@Override
	public BaseDao<Teacher> getBaseDao_zi() {
		// TODO Auto-generated method stub
		return this.teacherDao;
	}

	@Transactional
	public void saveRelation(String bjbh, List<Teacher> teachers) {
		Class clazz = this.classDao.getEntryBId(bjbh);
		if(clazz!=null){
			Set<Teacher> allteachers = clazz.getTeachers();
			for(Teacher teacher : teachers){
				if(teacher.getJsbh()!=null && !teacher.getJsbh().equals("")){
					if(this.classDao.checkUnionKey(clazz.getBjbh(), teacher.getJsbh())){
						allteachers.add(teacher);
					}
				}
			}
			clazz.setTeachers(allteachers);
		}	
	}


	@Transactional
	public String releaseAllTeacher(String bjbh) {
		Class clazz = this.classDao.getEntryBId(bjbh);
		clazz.setTeachers(null);
		return "deleteOk";
	}
	@Transactional
	public String releaseOneTeacher(Teacher teacher, String bjbh) {
		Set<Class> classes = teacher.getClasses();
		Class clazz = this.classDao.getEntryBId(bjbh);
		classes.remove(clazz);
		teacher.setClasses(classes);
		return "deleteOk";
	}

	public PageResult<Teacher> getTeacherListById(String bjbh,
			BaseQuery baseQuery) {
		return this.teacherDao.findClassPageResult(bjbh, baseQuery);
	}


	
}
