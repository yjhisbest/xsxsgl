package com.itheima11.xsxsgl.domain.basedata;

import java.io.Serializable;
import java.util.Set;

public class Major implements Serializable{
	private long mid;
	private String zymc;//专业名称
	private String zylb;//专业类别，比如文科，理科，工科
	private College college;//学院
	private Set<Class> classes;//一对多
	public long getMid() {
		return mid;
	}
	public void setMid(long mid) {
		this.mid = mid;
	}
	public String getZymc() {
		return zymc;
	}
	public void setZymc(String zymc) {
		this.zymc = zymc;
	}
	public String getZylb() {
		return zylb;
	}
	public void setZylb(String zylb) {
		this.zylb = zylb;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Set<Class> getClasses() {
		return classes;
	}
	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}
	
}
