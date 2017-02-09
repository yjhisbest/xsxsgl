package com.itheima11.xsxsgl.baseData.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.base.dao.impl.BaseDaoImpl;
import com.itheima11.xsxsgl.baseData.dao.CollegeDao;
import com.itheima11.xsxsgl.domain.basedata.College;
import com.itheima11.xsxsgl.domain.basedata.Major;

@Repository("collegeDao")
public class CollegeDaoImpl extends BaseDaoImpl<College> implements CollegeDao{

	public String checkSetIsNot(Serializable id) {
		String str = "";
		College college = this.getEntryBId(id);
		if(!college.getMajors().isEmpty()){
			str += "请先删除该学院与该专业下的专业的关系";
		}
		if(str.equals("")){
			return "pass";
		}else{
			return str;
		}
	}

	public College getCollegeByName(String xymc) {
		List<College> list = this.hibernateTemplate.find("from College where xymc=?",xymc);
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}

}
