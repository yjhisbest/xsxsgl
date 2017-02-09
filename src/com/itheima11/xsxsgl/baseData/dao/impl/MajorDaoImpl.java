package com.itheima11.xsxsgl.baseData.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.base.dao.impl.BaseDaoImpl;
import com.itheima11.xsxsgl.baseData.dao.MajorDao;
import com.itheima11.xsxsgl.domain.basedata.Major;

@Repository("majorDao")
public class MajorDaoImpl extends BaseDaoImpl<Major> implements MajorDao{

	public Major getMajorByName(String zymc) {
		List<Major> list = this.hibernateTemplate.find("from Major where zymc=?",zymc);
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}

}
