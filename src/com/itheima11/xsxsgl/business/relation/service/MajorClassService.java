package com.itheima11.xsxsgl.business.relation.service;

import java.util.List;

import com.itheima11.xsxsgl.basebusiness.service.BaseBusinessSevice;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Major;

public interface MajorClassService extends BaseBusinessSevice<Major, Class>{

	void saveRelation(Long mid, List<Class> classes);

	String releaseAllClass(Long mid);

	String releaseOneClass(Class clazz);

}
