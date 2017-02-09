package com.itheima11.xsxsgl.baseData.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.base.service.BaseServiceImpl;
import com.itheima11.xsxsgl.baseData.dao.StudentDao;
import com.itheima11.xsxsgl.baseData.service.StudentService;
import com.itheima11.xsxsgl.domain.basedata.Student;

@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService{
	@Resource(name="studentDao")
	private StudentDao studentDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.studentDao;
	}

}
