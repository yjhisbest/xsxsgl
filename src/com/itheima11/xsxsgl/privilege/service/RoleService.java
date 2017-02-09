package com.itheima11.xsxsgl.privilege.service;

import java.util.Collection;

import com.itheima11.xsxsgl.base.service.BaseSerivce;
import com.itheima11.xsxsgl.domain.privilege.Privilege;
import com.itheima11.xsxsgl.domain.privilege.Role;

public interface RoleService extends BaseSerivce<Role>{

	Collection<Privilege> getMenuitemTree(String jsbh);

}
