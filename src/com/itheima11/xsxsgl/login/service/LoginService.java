package com.itheima11.xsxsgl.login.service;

import com.itheima11.xsxsgl.domain.basedata.Teacher;

public interface LoginService {
	public Teacher authentication(String jsmc, String password);
}
