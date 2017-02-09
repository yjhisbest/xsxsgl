package com.itheima11.xsxsgl.baseData.dao;

import java.io.Serializable;
import java.util.List;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.TeacherQuery;

public interface TeacherDao extends BaseDao<Teacher>{

	String checkSetIsNot(Serializable jsbh);

	public PageResult<Teacher> findClassPageResult(final String bjbh, final BaseQuery baseQuery);

	Teacher getTeacherByKJ(String kcbh, String jsmc);

}
