package com.itheima11.xsxsgl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.itheima11.xsxsgl.query.BaseQuery;

public class LearnMessageQuery extends BaseQuery{
	private String xuehao;//学号
	private String kcbh;//课程编号
	private String jsbh;//教师编号
	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.xuehao)){
			this.getKeyValues().put("xuehao", this.xuehao);
		}
		if(StringUtils.isNotBlank(this.kcbh)){
			this.getKeyValues().put("kcbh", this.kcbh);
		}
		if(StringUtils.isNotBlank(this.jsbh)){
			this.getKeyValues().put("jsbh", this.jsbh);
		}
		return this.getKeyValues();
	}
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	public String getKcbh() {
		return kcbh;
	}
	public void setKcbh(String kcbh) {
		this.kcbh = kcbh;
	}
	public String getJsbh() {
		return jsbh;
	}
	public void setJsbh(String jsbh) {
		this.jsbh = jsbh;
	}

}
