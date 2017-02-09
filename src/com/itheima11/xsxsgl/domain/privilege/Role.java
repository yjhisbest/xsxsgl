package com.itheima11.xsxsgl.domain.privilege;

import java.io.Serializable;
import java.util.Set;

import com.itheima11.xsxsgl.domain.basedata.Teacher;

public class Role implements Serializable{
	private Long rid;
	private String name;
	private String description;//角色描述
	private Set<Teacher> teachers;
	private Set<Privilege> privileges;
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}
