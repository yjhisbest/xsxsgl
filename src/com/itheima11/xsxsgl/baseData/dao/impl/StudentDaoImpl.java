package com.itheima11.xsxsgl.baseData.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.base.dao.impl.BaseDaoImpl;
import com.itheima11.xsxsgl.baseData.dao.StudentDao;
import com.itheima11.xsxsgl.domain.basedata.Student;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{
	
}
