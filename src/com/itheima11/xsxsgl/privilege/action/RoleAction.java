package com.itheima11.xsxsgl.privilege.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima11.xsxsgl.base.action.BaseAction;
import com.itheima11.xsxsgl.baseData.service.TeacherService;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.domain.privilege.Privilege;
import com.itheima11.xsxsgl.domain.privilege.Role;
import com.itheima11.xsxsgl.privilege.service.RoleService;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.TeacherQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	@Resource(name="roleService")
	private RoleService roleService;
	@Resource(name="teacherService")
	private TeacherService teacherService;
	TeacherQuery baseQuery = new TeacherQuery();
	
	private String jsbh; 

	public String getJsbh() {
		return jsbh;
	}

	public void setJsbh(String jsbh) {
		this.jsbh = jsbh;
	}

	public String addUI(){
		return addUI;
	}
	
	public String add(){
		Role role = new Role();
		BeanUtils.copyProperties(this.getModel(), role);
		this.roleService.saveEntry(role);
		return action2action;
	}
	
	public String showRoles(){
		Collection<Role> roles = this.roleService.getEntries();
		ActionContext.getContext().put("roles", roles);
		return listAction;
	}
	
	public String updateUI(){
		Role role = this.roleService.getEntryById(this.getModel().getRid());
		ActionContext.getContext().getValueStack().push(role);
		return updateUI;
	}
	
	public String update(){
		Role role = this.roleService.getEntryById(this.getModel().getRid());
		role.setName(this.getModel().getName());
		role.setDescription(this.getModel().getDescription());
		this.roleService.saveEntry(role);
		return action2action;
	}
	public String deleteRoles(){
		this.roleService.deleteEntriesByIds(this.getCheckedStr().split(","));
		ActionContext.getContext().getValueStack().push("deleteOK");
		return "delJson";
	}
	public String deleteOne(){
		this.roleService.deleteEntyById(this.getModel().getRid());
		ActionContext.getContext().getValueStack().push("deleteOK");
		return "delJson";
	}
	
	//显示主页左侧的菜单栏
	public String getMenuitemTree(){
		Teacher teacher = (Teacher) this.getSession().getAttribute("teacher");
		Collection<Privilege> menuitemTree = this.roleService.getMenuitemTree(teacher.getJsbh());
		ActionContext.getContext().getValueStack().push(menuitemTree);
		return SUCCESS;
	}
	
	//转到设置角色页面
	public String skipSetRole(){
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<Teacher> teachers = this.teacherService.getPageResult(baseQuery);
		ActionContext.getContext().put("teachers", teachers);
		return "setRole";
	}
	//角色框
	public String showRoleFrame(){
		Collection<Role> roles = this.roleService.getEntries();
		ActionContext.getContext().getValueStack().push(roles);
		return "roleFrame";
	}
	//设置角色
	public String setRole(){
		Teacher teacher = this.teacherService.getEntryById(this.jsbh);
		Role role = this.roleService.getEntryById(this.getModel().getRid());
		teacher.setRole(role);
		teacher.setRolename(role.getName());
		this.teacherService.updateEntry(teacher);
		return "roleJson";
	}
	
	//转到设置权限页面
	public String skipSetPrivilege(){
		Collection<Role> roles = this.roleService.getEntries();
		ActionContext.getContext().put("roles", roles);
		return "setPrivilege";
	}
}
