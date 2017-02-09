package com.itheima11.xsxsgl.login.dao;

import com.itheima11.xsxsgl.domain.basedata.Teacher;

public interface LoginDao {
	public Teacher authentication(String jsmc, String password);
}
