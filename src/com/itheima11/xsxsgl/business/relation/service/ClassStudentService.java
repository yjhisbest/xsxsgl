package com.itheima11.xsxsgl.business.relation.service;

import java.util.List;

import com.itheima11.xsxsgl.basebusiness.service.BaseBusinessSevice;
import com.itheima11.xsxsgl.domain.basedata.Student;
import com.itheima11.xsxsgl.domain.basedata.Class;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.StudentQuery;
public interface ClassStudentService extends BaseBusinessSevice<Class, Student>{

	void saveRelation(String bjbh, List<Student> students);

	String releaseAllStudent(String bjbh);

	String releaseOne(Student student, String bjbh);

}
