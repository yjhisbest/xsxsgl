package com.itheima11.xsxsgl.privilege.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.base.dao.impl.BaseDaoImpl;
import com.itheima11.xsxsgl.domain.privilege.Privilege;
import com.itheima11.xsxsgl.privilege.dao.PrivilegeDao;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	public Collection<Privilege> getPrivilegesByRid(Long rid) {
		Collection<Privilege> allPrivileges = this.hibernateTemplate.find("from Privilege");
		Collection<Privilege> rolePrivileges = this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r where r.rid=?",rid);
		for(Privilege privilege : allPrivileges){
			for(Privilege privilege2 : rolePrivileges){
				if(privilege.getId().longValue()==privilege2.getId().longValue()){
					privilege.setChecked(true);
				}
			}
		}
		return allPrivileges;
	}

}
