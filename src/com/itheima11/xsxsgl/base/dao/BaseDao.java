package com.itheima11.xsxsgl.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;

public interface BaseDao<T> {
	/**
	 * 分页查询
	 */
	public PageResult<T> findPageResult(final BaseQuery baseQuery);
	/**
	 * 不分页的查询
	 */
	public Collection<T> findEntry();
	/**
	 * 保存
	 */
	public void saveEntry(T t);
	/**
	 * 修改
	 */
	public void updateEntry(T t);
	/**
	 * 根据ids删除一些数据
	 */
	public void deleteEntriesByIDS(Serializable[] ids);
	/**
	 * 根据id删除一条数据
	 */
	public void deleteEntry(Serializable id);
	/**
	 * 根据id提取一条数据
	 */
	public T getEntryBId(Serializable id);
	/**
	 * 根据ids提取数据
	 */
	public Set<T> getEntriesByIds(Serializable[] ids);
	/**
	 * 查询某一张表的总的记录数
	 */
	public int getCount(final BaseQuery baseQuery);
}
