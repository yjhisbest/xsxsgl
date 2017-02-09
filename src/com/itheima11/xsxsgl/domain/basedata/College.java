package com.itheima11.xsxsgl.domain.basedata;

import java.io.Serializable;
import java.util.Set;

public class College implements Serializable{
	private Long id;//学院id
	private String xymc;//学院名称
	private String yz;//院长
	private String sj;//书记
	private Set<Major> majors;//专业，一对多
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getXymc() {
		return xymc;
	}
	public void setXymc(String xymc) {
		this.xymc = xymc;
	}

	public String getYz() {
		return yz;
	}
	public void setYz(String yz) {
		this.yz = yz;
	}
	public String getSj() {
		return sj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public Set<Major> getMajors() {
		return majors;
	}
	public void setMajors(Set<Major> majors) {
		this.majors = majors;
	}
}
