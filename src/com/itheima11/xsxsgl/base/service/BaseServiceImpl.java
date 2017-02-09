package com.itheima11.xsxsgl.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;

public abstract class BaseServiceImpl<T> implements BaseSerivce<T>{
	/**
	 * public BaseDao baseDao;不能使用@Resource,应为baseDao是不确定的，不能写具体的
	 * 
	 * @return
	 * 
	 * 所以得通过该类的集成类使用public BaseDao baseDao；@Resource这种注入确定的base，
	 * 在实现getBaseDao()方法返回baseDao
	 */
	public abstract BaseDao getBaseDao();
	
	@Transactional
	public PageResult<T> getPageResult(BaseQuery baseQuery) {
		return this.getBaseDao().findPageResult(baseQuery);
	}
	@Transactional
	public Collection<T> getEntries() {
		return this.getBaseDao().findEntry();
	}
	@Transactional
	public void saveEntry(T t) {
		this.getBaseDao().saveEntry(t);
	}
	@Transactional
	public void updateEntry(T t) {
		this.getBaseDao().updateEntry(t);
	}
	@Transactional
	public Set<T> getEntriesByIds(Serializable[] ids) {
		return this.getBaseDao().getEntriesByIds(ids);
	}
	@Transactional
	public T getEntryById(Serializable id) {
		return (T) this.getBaseDao().getEntryBId(id);
	}
	@Transactional
	public void deleteEntriesByIds(Serializable[] ids) {
		this.getBaseDao().deleteEntriesByIDS(ids);
	}
	@Transactional
	public void deleteEntyById(Serializable id) {
		this.getBaseDao().deleteEntry(id);
	}
	
}
