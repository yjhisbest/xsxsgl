package com.itheima11.xsxsgl.business.relation.service;

import java.util.Collection;
import java.util.List;

import com.itheima11.xsxsgl.basebusiness.service.BaseBusinessSevice;
import com.itheima11.xsxsgl.domain.basedata.College;
import com.itheima11.xsxsgl.domain.basedata.Major;

public interface CollegeMajorService extends BaseBusinessSevice<College, Major>{

	public Collection<College> getColleges();

	public Major getMajorByName(String zymc);

	public void saveRelation(Long id, List<Major> majors);

	public String releaseAll(Long id);

	public String releaseOne(Major major);

}
