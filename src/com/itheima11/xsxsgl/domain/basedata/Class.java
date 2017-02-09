package com.itheima11.xsxsgl.domain.basedata;

import java.io.Serializable;
import java.util.Set;

public class Class implements Serializable{
	private String bjbh;//班级编号
	private String bjmc;//班级名称
	private int number;//人数
	private Set<Student> students;
	private Major major;//一个班级一个专业
	private Set<Teacher> teachers;//多对多
	private Set<Course> courses;//多对多
	public String getBjbh() {
		return bjbh;
	}
	public void setBjbh(String bjbh) {
		this.bjbh = bjbh;
	}
	public String getBjmc() {
		return bjmc;
	}
	public void setBjmc(String bjmc) {
		this.bjmc = bjmc;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
