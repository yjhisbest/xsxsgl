package com.itheima11.xsxsgl.privilege.dao;

import java.util.Collection;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.domain.privilege.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege>{
	public Collection<Privilege> getPrivilegesByRid(Long rid);
}
