package com.itheima11.xsxsgl.baseData.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.base.dao.impl.BaseDaoImpl;
import com.itheima11.xsxsgl.baseData.dao.ClassDao;
import com.itheima11.xsxsgl.domain.basedata.Class;

@Repository("classDao")
public class ClassDaoImpl extends BaseDaoImpl<Class> implements ClassDao{

	public String checkSetIsNot(String bjbh) {
		String str = "";
		Class clazz = this.getEntryBId(bjbh);
		if(!clazz.getCourses().isEmpty()){
			str += "请先解除班级与对应的课程的关系";
		}
		if(!clazz.getStudents().isEmpty()){
			str += ",解除班级与对应的学生的关系";
		}
		if(!clazz.getTeachers().isEmpty()){
			str += ",解除班级与对应的老师的关系";
		}
		if(str.equals("")){
			return "pass";
		}else{
			return str;
		}
	}

	public boolean checkUnionKey(String bjbh, String jsbh) {
		List list = this.hibernateTemplate.find("from Class c inner join fetch c.teachers t where c.bjbh=? and t.jsbh=?", bjbh, jsbh);
		if(list.isEmpty()){
			return true;
		}else{
			return false;
		}
		
	}

	public boolean checkUnionKeyCC(String bjbh, String kcbh) {
		List list = this.hibernateTemplate.find("from Class c inner join fetch c.courses cs where c.bjbh=? and cs.kcbh=?", bjbh, kcbh);
		if(list.isEmpty()){
			return true;
		}else{
			return false;
		}
	}


	public Class getClassByName(String bjbh) {
		List<Class> list = this.hibernateTemplate.find("from Class where bjbh=?", bjbh);
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}

}
