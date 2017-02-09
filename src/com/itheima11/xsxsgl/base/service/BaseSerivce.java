package com.itheima11.xsxsgl.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;

public interface BaseSerivce<T> {
	public PageResult<T> getPageResult(final BaseQuery baseQuery);
	public Collection<T> getEntries();
	public void saveEntry(T t);
	public void updateEntry(T t);
	public Set<T> getEntriesByIds(Serializable[] ids);
	public T getEntryById(Serializable id);
	public void deleteEntriesByIds(Serializable[] ids);
	public void deleteEntyById(Serializable id);
}
