package com.itheima11.xsxsgl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.itheima11.xsxsgl.query.BaseQuery;

public class TeacherQuery extends BaseQuery{
	private String jsbh;//教师编号
	private String jsmc;//教师名称
	private int sex;//1,男，2，女，3，不详
	private int age;
	private String jszc;//教师职称

	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.jsbh)){
			this.getKeyValues().put("jsbh", this.jsbh);
		}
		if(StringUtils.isNotBlank(this.jsmc)){
			this.getKeyValues().put("jsmc", this.jsmc);
		}
		if(this.sex>=1 && this.sex<=3){
			this.getKeyValues().put("sex", this.sex);
		}
		if(this.age>20 && this.age<70){
			this.getKeyValues().put("age", this.age);
		}
		if(StringUtils.isNotBlank(this.jszc)){
			this.getKeyValues().put("jszc", this.jszc);
		}
		return this.getKeyValues();
	}

	public String getJsbh() {
		return jsbh;
	}
	public void setJsbh(String jsbh) {
		this.jsbh = jsbh;
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

}
