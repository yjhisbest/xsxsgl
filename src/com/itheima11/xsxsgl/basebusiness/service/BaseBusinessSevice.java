package com.itheima11.xsxsgl.basebusiness.service;

import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;

public interface BaseBusinessSevice<T, E> {
	public PageResult<T> getEntries_zhu(BaseQuery baseQuery);
	public PageResult<E> getEntries_zi(BaseQuery baseQuery);

}
