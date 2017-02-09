package com.itheima11.xsxsgl.baseData.dao;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;

public interface CourseDao extends BaseDao<Course>{

	String checkSetIsNot(String id);

	PageResult<Course> findClassPageResult(String bjbh, BaseQuery baseQuery);

}
