package com.itheima11.xsxsgl.privilege.dao;

import java.util.Collection;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.domain.privilege.Privilege;
import com.itheima11.xsxsgl.domain.privilege.Role;

public interface RoleDao extends BaseDao<Role>{

	Collection<Privilege> getMenuitemTree(String jsbh);

}
