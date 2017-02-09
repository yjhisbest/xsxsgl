package com.itheima11.xsxsgl.query.basedata;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.itheima11.xsxsgl.query.BaseQuery;

public class CourseQuery extends BaseQuery{
	private String kcbh;//课程编号
	private String kcmc;//课程名称
	private String jsmc;//教师名称
	private Date kksj;//开课时间
	private float classHour;//学时
	private String kaohe;//考查或考试
	private float credit;//学分
	private String jsbh;//教师编号
	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.kcbh)){
			this.getKeyValues().put("kcbh", this.kcbh);
		}
		if(StringUtils.isNotBlank(this.kcmc)){
			this.getKeyValues().put("kcmc", this.kcmc);
		}
		if(StringUtils.isNotBlank(this.jsmc)){
			this.getKeyValues().put("jsmc", this.jsmc);
		}
		if(kksj!=null){
			this.getKeyValues().put("kksj", this.kksj);
		}
		if(this.classHour>0){
			this.getKeyValues().put("classHour", this.classHour);
		}
		if(StringUtils.isNotBlank(this.kaohe)){
			this.getKeyValues().put("kaohe", this.kaohe);
		}
		if(this.credit>0){
			this.getKeyValues().put("credit", this.credit);
		}
		if(StringUtils.isNotBlank(this.jsbh)){
			this.getKeyValues().put("jsbh", this.jsbh);
		}
		return this.getKeyValues();
	}
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
	public String getJsbh() {
		return jsbh;
	}
	public void setJsbh(String jsbh) {
		this.jsbh = jsbh;
	}


}
