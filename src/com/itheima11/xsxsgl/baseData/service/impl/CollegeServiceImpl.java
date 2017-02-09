package com.itheima11.xsxsgl.baseData.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.base.service.BaseServiceImpl;
import com.itheima11.xsxsgl.baseData.dao.CollegeDao;
import com.itheima11.xsxsgl.baseData.service.CollegeService;
import com.itheima11.xsxsgl.domain.basedata.College;

@Service("collegeService")
public class CollegeServiceImpl extends BaseServiceImpl<College> implements CollegeService{
	@Resource(name="collegeDao")
	private CollegeDao collegeDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.collegeDao;
	}
	public String checkSetIsNot(Long id) {
		return this.collegeDao.checkSetIsNot(id);
	}
	public String checkCollegesSetIsNot(String[] ids) {
		String str = "";
		for(String id : ids){
			String str1 = this.collegeDao.checkSetIsNot(Long.parseLong(id));
			if(str.split(",").length<str1.split(",").length && !str1.equals("pass")){
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
	public College getCollegeByName(String xymc) {
		return this.collegeDao.getCollegeByName(xymc);
	}

}
