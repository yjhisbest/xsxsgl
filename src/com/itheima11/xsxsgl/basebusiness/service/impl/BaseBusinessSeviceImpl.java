package com.itheima11.xsxsgl.basebusiness.service.impl;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.basebusiness.service.BaseBusinessSevice;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;


public abstract class BaseBusinessSeviceImpl<T, E> implements BaseBusinessSevice<T, E>{
	public abstract BaseDao<T> getBaseDao_zhu();//得到主表dao
	public abstract BaseDao<E> getBaseDao_zi();//得到子表dao
	
	public PageResult<T> getEntries_zhu(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageResult<E> getEntries_zi(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
