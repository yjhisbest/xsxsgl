package com.itheima11.xsxsgl.domain.basedata;

import java.io.Serializable;
import java.util.Set;

import com.itheima11.xsxsgl.domain.privilege.Role;

public class Teacher implements Serializable{
	private String jsbh;//教师编号
	private String password;//密码
	private String jsmc;//教师名称
	private int sex;//1,男，2，女，3，不详
	private int age;
	private String jszc;//教师职称
	private String cellphone;
	private Set<Course> courses;//一对多
	private Set<Class> classes;//多对多
	private Role role;
	private String rolename;//教师的角色名称
	public String getJsbh() {
		return jsbh;
	}
	public void setJsbh(String jsbh) {
		this.jsbh = jsbh;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJsmc() {
		return jsmc;
	}
	public void setJsmc(String jsmc) {
		this.jsmc = jsmc;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJszc() {
		return jszc;
	}
	public void setJszc(String jszc) {
		this.jszc = jszc;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Set<Class> getClasses() {
		return classes;
	}
	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
