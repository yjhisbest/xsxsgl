package com.itheima11.xsxsgl.privilege.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.base.service.BaseServiceImpl;
import com.itheima11.xsxsgl.domain.privilege.Privilege;
import com.itheima11.xsxsgl.privilege.dao.PrivilegeDao;
import com.itheima11.xsxsgl.privilege.service.PrivilegeService;

@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService{
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.privilegeDao;
	}
	public Collection<Privilege> getPrivilegesByRid(Long rid) {
		// TODO Auto-generated method stub
		return this.privilegeDao.getPrivilegesByRid(rid);
	}

}
