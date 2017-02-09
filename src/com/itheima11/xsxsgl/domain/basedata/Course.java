package com.itheima11.xsxsgl.domain.basedata;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Course implements Serializable{
	private String kcbh;//课程编号
	private String kcmc;//课程名称
	private String jsmc;//教师名称
	private Date kksj;//开课时间
	private float classHour;//学时
	private String kaohe;//考查或考试
	private float credit;//学分
	private Teacher teacher;//一对多
	private Set<Class> classes;
	public String getKcbh() {
		return kcbh;
	}
	public void setKcbh(String kcbh) {
		this.kcbh = kcbh;
	}
	public String getKcmc() {
		return kcmc;
	}
	public void setKcmc(String kcmc) {
		this.kcmc = kcmc;
	}
	public String getJsmc() {
		return jsmc;
	}
	public void setJsmc(String jsmc) {
		this.jsmc = jsmc;
	}
	public Date getKksj() {
		return kksj;
	}
	public void setKksj(Date kksj) {
		this.kksj = kksj;
	}
	public float getClassHour() {
		return classHour;
	}
	public void setClassHour(float classHour) {
		this.classHour = classHour;
	}
	public String getKaohe() {
		return kaohe;
	}
	public void setKaohe(String kaohe) {
		this.kaohe = kaohe;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Set<Class> getClasses() {
		return classes;
	}
	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}
	
}
