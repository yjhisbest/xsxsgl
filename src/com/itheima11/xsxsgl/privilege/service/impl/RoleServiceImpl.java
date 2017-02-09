package com.itheima11.xsxsgl.privilege.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.base.service.BaseServiceImpl;
import com.itheima11.xsxsgl.domain.privilege.Privilege;
import com.itheima11.xsxsgl.domain.privilege.Role;
import com.itheima11.xsxsgl.privilege.dao.RoleDao;
import com.itheima11.xsxsgl.privilege.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	@Resource(name="roleDao")
	private RoleDao roleDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.roleDao;
	}
	public Collection<Privilege> getMenuitemTree(String jsbh) {
		// TODO Auto-generated method stub
		return this.roleDao.getMenuitemTree(jsbh);
	}

}
