package com.itheima11.xsxsgl.baseData.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.base.service.BaseServiceImpl;
import com.itheima11.xsxsgl.baseData.dao.CourseDao;
import com.itheima11.xsxsgl.baseData.service.CourseService;
import com.itheima11.xsxsgl.domain.basedata.Course;

@Service("courseService")
public class CourseServiceImpl extends BaseServiceImpl<Course> implements CourseService{
	@Resource(name="courseDao")
	private CourseDao courseDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.courseDao;
	}
	public String checkSetIsNot(String id) {
		return this.courseDao.checkSetIsNot(id);
	}
	public String checkCollegesSetIsNot(String[] ids) {
		String str = "";
		for(String id : ids){
			String str1 = this.courseDao.checkSetIsNot(id);
			if(str.split(",").length<str1.split(",").length && str1.equals("pass")){
				str = str1;
			}
			if(str.split(",").length==1 && !str.equals("")){
				break;
			}
		}
		if(str.equals("")){
			return "pass";
		}else{
			return str;
		}
	}

}
