package com.itheima11.xsxsgl.baseData.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.base.service.BaseServiceImpl;
import com.itheima11.xsxsgl.baseData.dao.TeacherDao;
import com.itheima11.xsxsgl.baseData.service.TeacherService;
import com.itheima11.xsxsgl.domain.basedata.Teacher;

@Service("teacherService")
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements TeacherService{
	@Resource(name="teacherDao")
	private TeacherDao teacherDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.teacherDao;
	}
	public String checkTeachersSetIsNot(String[] ids) {
		String str = "";
		for(String id : ids){
			String str1 = this.teacherDao.checkSetIsNot(id);
			if(str.split(",").length<str1.split(",").length && !str1.equals("pass")){
				str = str1;
			}
			if(str.split(",").length==2){
				break;
			}
		}
		if(str.equals("")){
			return "pass";
		}else{
			return str;
		}
	}
	public String checkSetIsNot(String jsbh) {
		return this.teacherDao.checkSetIsNot(jsbh);
	}

}
