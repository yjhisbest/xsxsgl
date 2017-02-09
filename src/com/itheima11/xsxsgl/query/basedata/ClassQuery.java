package com.itheima11.xsxsgl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.itheima11.xsxsgl.query.BaseQuery;

public class ClassQuery extends BaseQuery{
	private String bjbh;//班级编号
	private String bjmc;//班级名称
	private Long mid;//专业的id
	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.bjbh)){
			this.getKeyValues().put("bjbh", bjbh);
		}
		if(StringUtils.isNotBlank(this.bjmc)){
			this.getKeyValues().put("bjmc", bjmc);
		}
		if(this.mid!=null){
			this.getKeyValues().put("mid", this.mid);
		}
		return this.getKeyValues();
	}
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
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}

}
