package com.itheima11.xsxsgl.baseData.service;

import com.itheima11.xsxsgl.base.service.BaseSerivce;
import com.itheima11.xsxsgl.domain.basedata.Teacher;

public interface TeacherService extends BaseSerivce<Teacher>{

	String checkTeachersSetIsNot(String[] ids);

	String checkSetIsNot(String jsbh);

}
