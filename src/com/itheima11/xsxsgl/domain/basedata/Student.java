package com.itheima11.xsxsgl.domain.basedata;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	private String xuehao;//学号
	private String password;//密码
	private String name;//姓名
	private int sex;
	private Date csrq;//出生日期
	private int statue;//在校状态，1，在读，2，毕业，3，停学，4，退学
	private Date rxrq;//入学日期
	private String cellphone;
	private String zzmm;//政治面貌
	private String syszd;//生源所在地
	private float yxxf;//已修学分
	private Class clazz;//一对多
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getStatue() {
		return statue;
	}
	public Date getCsrq() {
		return csrq;
	}
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}
	public void setStatue(int statue) {
		this.statue = statue;
	}
	public Date getRxrq() {
		return rxrq;
	}
	public void setRxrq(Date rxrq) {
		this.rxrq = rxrq;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getSyszd() {
		return syszd;
	}
	public void setSyszd(String syszd) {
		this.syszd = syszd;
	}
	public float getYxxf() {
		return yxxf;
	}
	public void setYxxf(float yxxf) {
		this.yxxf = yxxf;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
}
