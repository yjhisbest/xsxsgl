package com.itheima11.xsxsgl.privilege.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.base.action.BaseAction;
import com.itheima11.xsxsgl.domain.privilege.Privilege;
import com.itheima11.xsxsgl.domain.privilege.Role;
import com.itheima11.xsxsgl.privilege.service.PrivilegeService;
import com.itheima11.xsxsgl.privilege.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege>{
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	@Resource(name="roleService")
	private RoleService roleService;
	private Long rid;
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	
	public String showPrivilegeTree(){
		Collection<Privilege> privileges = this.privilegeService.getPrivilegesByRid(this.rid);
		ActionContext.getContext().getValueStack().push(privileges);
		return SUCCESS;
	}
	
	public String savePrivilege(){
		//根据rid获取到role
		Role role = this.roleService.getEntryById(rid);
		//获取到被选中的权限的集合
		if("".equals(this.getCheckedStr())){//页面上没有选择权限
			role.setPrivileges(null);
		}else{
			Set<Privilege> privileges = this.privilegeService.getEntriesByIds(this.getCheckedStr().split(","));
			//建立角色与权限之间的关系
			role.setPrivileges(privileges);
		}
		this.roleService.updateEntry(role);
		return SUCCESS;
	}
	
}
