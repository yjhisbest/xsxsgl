package com.itheima11.xsxsgl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.itheima11.xsxsgl.query.BaseQuery;

public class CollegeQuery extends BaseQuery{
	private String xymc;//学院名称
	private String yz;//院长
	private String sj;//书记
	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.xymc)){
			this.getKeyValues().put("xymc", xymc);
		}
		if(StringUtils.isNotBlank(this.yz)){
			this.getKeyValues().put("yz", yz);
		}
		if(StringUtils.isNotBlank(this.sj)){
			this.getKeyValues().put("sj", sj);
		}
		return this.getKeyValues();
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

}
