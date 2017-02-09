package com.itheima11.xsxsgl.login.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.login.dao.LoginDao;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	public Teacher authentication(String jsmc, String password) {
		List<Teacher> teachers = this.hibernateTemplate.find("from Teacher where jsmc=? and password=?", jsmc, password);
		if(teachers.size()==0){
			return null;
		}else{
			return teachers.get(0);
		}
	}

}
