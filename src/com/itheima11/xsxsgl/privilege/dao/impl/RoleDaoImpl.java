package com.itheima11.xsxsgl.privilege.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.base.dao.impl.BaseDaoImpl;
import com.itheima11.xsxsgl.domain.privilege.Privilege;
import com.itheima11.xsxsgl.domain.privilege.Role;
import com.itheima11.xsxsgl.privilege.dao.RoleDao;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	public Collection<Privilege> getMenuitemTree(String jsbh) {
		if(jsbh.equals("10086")){//说明是超级管理员
			return this.hibernateTemplate.find("from Privilege");
		}else{
			return this.hibernateTemplate.
					find("from Privilege p inner join fetch p.roles r "+
							"inner join fetch r.teachers t where t.jsbh=?", jsbh);
		}
		
	}

}
