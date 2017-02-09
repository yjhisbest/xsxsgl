package com.itheima11.xsxsgl.baseData.service;

import com.itheima11.xsxsgl.base.service.BaseSerivce;
import com.itheima11.xsxsgl.domain.basedata.Class;

public interface ClassService extends BaseSerivce<Class>{

	String checkTeachersSetIsNot(String[] ids);

	String checkSetIsNot(String bjbh);

	Class getClassByName(String bjbh);

}
