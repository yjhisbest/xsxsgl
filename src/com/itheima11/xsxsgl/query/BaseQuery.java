package com.itheima11.xsxsgl.query;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseQuery {
	/**
	 * 当前页数
	 */
	private int currentPage = 1;
	/**
	 * 一页显示的条数
	 */
	private int pageSize = 6;
	/**
	 * 把页面上表单元素封装成map
	 */
	
	public Map<String, Object> keyValues = new HashMap<String, Object>();
	/**
	 * 把页面上查询条件封装成一个Map<String, Object>
	 * @return
	 */
	public abstract Map<String, Object> buildWhere();
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Map<String, Object> getKeyValues() {
		return keyValues;
	}
	public void setKeyValues(Map<String, Object> keyValues) {
		this.keyValues = keyValues;
	}
	
}
