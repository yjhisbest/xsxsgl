package com.itheima11.xsxsgl.baseData.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.base.dao.impl.BaseDaoImpl;
import com.itheima11.xsxsgl.baseData.dao.CourseDao;
import com.itheima11.xsxsgl.domain.basedata.College;
import com.itheima11.xsxsgl.domain.basedata.Course;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;
@Repository("courseDao")
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao{

	public String checkSetIsNot(String id) {
		String str = "";
		Course course = this.getEntryBId(id);
		if(!course.getClasses().isEmpty()){
			str += "请删除相应课程与班级之间的关系";
		}
		if(str.equals("")){
			return "pass";
		}else{
			return str;
		}
	}

	public PageResult<Course> findClassPageResult(final String bjbh,
			final BaseQuery baseQuery) {
		//返回根据查询条件查询的总的记录数
				final int totalRows = this.getClassCount(bjbh,baseQuery);
				//创建PageResult对象
				final PageResult<Course> pageResult = new PageResult<Course>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), totalRows); 
				return  this.hibernateTemplate.execute(new HibernateCallback<PageResult<Course>>() {
					public PageResult<Course> doInHibernate(Session session) throws HibernateException,
							SQLException {
						StringBuffer stringBuffer = new StringBuffer();
						stringBuffer.append("from Course cs inner join fetch cs.classes c where c.bjbh=:bjbh");
						Query query = session.createQuery(stringBuffer.toString());
						query.setParameter("bjbh", bjbh);
						//设置当前页的第一行在集合中的位置
						int firstResult = (baseQuery.getCurrentPage()-1)*baseQuery.getPageSize();
						if(firstResult>totalRows){
							firstResult = (baseQuery.getCurrentPage()-2)*baseQuery.getPageSize();
						}
						//设置每页显示的最多行数
						int maxResult = baseQuery.getPageSize();
						//用hibernate的方式设置分页
						query.setFirstResult(firstResult).setMaxResults(maxResult);
						//返回分页后的结果集
						List<Course> rows = query.list();
						//把结果设置到pageResult
						pageResult.setRows(rows);
						return pageResult;
					}
				});
	}
	public int getClassCount(final String bjbh,final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("select count(*) from Course cs inner join cs.classes c where c.bjbh=:bjbh");

				Query query = session.createQuery(stringBuffer.toString());
				query.setParameter("bjbh", bjbh);
				Long count = (Long) query.uniqueResult();
				return count.intValue();
			}
		});
	}

}
