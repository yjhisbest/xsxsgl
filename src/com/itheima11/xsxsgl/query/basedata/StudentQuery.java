package com.itheima11.xsxsgl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.itheima11.xsxsgl.query.BaseQuery;

public class StudentQuery extends BaseQuery{
	private String xuehao;//学号
	private String password;//密码
	private String name;//姓名
	private int sex;
	private int statue;//在校状态，1，在读，2，毕业，3，停学，4，退学
	private String cellphone;
	private String zzmm;//政治面貌
	private String syszd;//生源所在地
	private String bjbh;
	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.xuehao)){
			this.getKeyValues().put("xuehao", this.xuehao);
		}
		if(StringUtils.isNotBlank(this.password)){
			this.getKeyValues().put("password", this.password);
		}
		if(StringUtils.isNotBlank(this.name)){
			this.getKeyValues().put("name", this.name);
		}
		if(this.sex>=1 && this.sex<=3){
			this.getKeyValues().put("sex", this.sex);
		}
		if(this.statue>=1 && this.statue<=4){
			this.getKeyValues().put("statue", this.statue);
		}
		if(StringUtils.isNotBlank(this.cellphone)){
			this.getKeyValues().put("cellphone", this.cellphone);
		}
		if(StringUtils.isNotBlank(this.zzmm)){
			this.getKeyValues().put("zzmm", this.zzmm);
		}
		if(StringUtils.isNotBlank(this.syszd)){
			this.getKeyValues().put("syszd", this.syszd);
		}
		if(StringUtils.isNotBlank(this.bjbh)){
			this.getKeyValues().put("bjbh", this.bjbh);
		}
		return this.getKeyValues();
	}
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
	public void setStatue(int statue) {
		this.statue = statue;
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
	public String getBjbh() {
		return bjbh;
	}
	public void setBjbh(String bjbh) {
		this.bjbh = bjbh;
	}

}
