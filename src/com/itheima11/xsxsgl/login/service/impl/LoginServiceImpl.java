package com.itheima11.xsxsgl.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.login.dao.LoginDao;
import com.itheima11.xsxsgl.login.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Resource(name="loginDao")
	private LoginDao loginDao;
	public Teacher authentication(String jsmc, String password) {
		// TODO Auto-generated method stub
		return this.loginDao.authentication(jsmc, password);
	}

}
