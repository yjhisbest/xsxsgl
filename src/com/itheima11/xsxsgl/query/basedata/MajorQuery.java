package com.itheima11.xsxsgl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.itheima11.xsxsgl.query.BaseQuery;

public class MajorQuery extends BaseQuery{
	private Long mid;
	private String zymc;//专业名称
	private String zylb;//专业类别，比如文科，理科，工科
	private Long id;//学院的id
	@Override
	public Map<String, Object> buildWhere() {
		if(this.mid!=null){
			this.getKeyValues().put("mid", this.mid);
		}
		if(StringUtils.isNotBlank(this.zymc)){
			this.getKeyValues().put("zymc", this.zymc);
		}
		if(StringUtils.isNotBlank(this.zylb)){
			this.getKeyValues().put("zylb", this.zylb);
		}
		//关系list上用到
		if(this.id!=null){
			this.getKeyValues().put("college.id", this.id);
		}
		return this.getKeyValues();
	}
	
	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
