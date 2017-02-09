package com.itheima11.xsxsgl.baseData.dao;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.domain.basedata.Major;

public interface MajorDao extends BaseDao<Major>{

	public Major getMajorByName(String zymc);

}
