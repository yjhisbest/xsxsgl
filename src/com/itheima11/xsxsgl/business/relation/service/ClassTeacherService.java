package com.itheima11.xsxsgl.business.relation.service;

import java.util.List;

import com.itheima11.xsxsgl.basebusiness.service.BaseBusinessSevice;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.TeacherQuery;

public interface ClassTeacherService extends BaseBusinessSevice<Class, Teacher>{

	void saveRelation(String bjbh, List<Teacher> teachers);

	PageResult<Teacher> getTeacherListById(String bjbh, BaseQuery baseQuery);

	String releaseAllTeacher(String bjbh);

	String releaseOneTeacher(Teacher teacher, String bjbh);

}
