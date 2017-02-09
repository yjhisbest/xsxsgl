package com.itheima11.xsxsgl.baseData.service;

import com.itheima11.xsxsgl.base.service.BaseSerivce;
import com.itheima11.xsxsgl.domain.basedata.College;

public interface CollegeService extends BaseSerivce<College>{

	String checkSetIsNot(Long id);

	String checkCollegesSetIsNot(String[] ids);

	College getCollegeByName(String xymc);

}
