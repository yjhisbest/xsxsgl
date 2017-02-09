package com.itheima11.xsxsgl.privilege.service;

import java.util.Collection;

import com.itheima11.xsxsgl.base.service.BaseSerivce;
import com.itheima11.xsxsgl.domain.privilege.Privilege;

public interface PrivilegeService extends BaseSerivce<Privilege>{
	public Collection<Privilege> getPrivilegesByRid(Long rid);
}
