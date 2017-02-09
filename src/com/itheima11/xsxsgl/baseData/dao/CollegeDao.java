package com.itheima11.xsxsgl.baseData.dao;

import java.io.Serializable;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.domain.basedata.College;

public interface CollegeDao extends BaseDao<College>{

	String checkSetIsNot(Serializable id);

	College getCollegeByName(String xymc);

}
