package com.itheima11.xsxsgl.baseData.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.base.service.BaseServiceImpl;
import com.itheima11.xsxsgl.baseData.dao.ClassDao;
import com.itheima11.xsxsgl.baseData.service.ClassService;
import com.itheima11.xsxsgl.domain.basedata.Class;

@Service("classService")
public class ClassServiceImpl extends BaseServiceImpl<Class> implements ClassService{
	@Resource(name="classDao")
	private ClassDao classDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.classDao;
	}
	public String checkTeachersSetIsNot(String[] ids) {
		String str = "";
		for(String id : ids){
			String str1 = this.classDao.checkSetIsNot(id);
			if(str.split(",").length<str1.split(",").length && !str1.equals("pass")){
				str = str1;
			}
			if(str.split(",").length==3){
				break;
			}
		}
		if(str.equals("")){
			return "pass";
		}else{
			return str;
		}
	}
	public String checkSetIsNot(String bjbh) {
		return this.classDao.checkSetIsNot(bjbh);
	}
	public Class getClassByName(String bjbh) {
		// TODO Auto-generated method stub
		return this.classDao.getClassByName(bjbh);
	}

}
