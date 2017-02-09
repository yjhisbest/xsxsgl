package com.itheima11.xsxsgl.test.basedata;

import org.junit.Test;


import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.baseData.dao.TeacherDao;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.test.SpringUtils;

public class BaseDaoTest extends SpringUtils{
	@Test
	public void testBaseQuery_Count(){

	}
	@Test
	public void testSave(){
		
	}
	@Test
	public void testTeacherBYKJ(){
		TeacherDao teacherDao = (TeacherDao) context.getBean("teacherDao");
		Teacher teacher = teacherDao.getTeacherByKJ("c0001", "ye1");
		System.out.println(teacher+"\n"+teacher.getJsbh());
	}
}
