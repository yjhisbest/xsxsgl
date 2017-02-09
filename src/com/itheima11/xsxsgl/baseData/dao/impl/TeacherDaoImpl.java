package com.itheima11.xsxsgl.baseData.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.base.dao.impl.BaseDaoImpl;
import com.itheima11.xsxsgl.baseData.dao.TeacherDao;
import com.itheima11.xsxsgl.domain.basedata.Teacher;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;
import com.itheima11.xsxsgl.query.basedata.TeacherQuery;

@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao{

	public String checkSetIsNot(Serializable jsbh) {
		String str = "";
		Teacher teacher = this.getEntryBId(jsbh);
		if(!teacher.getCourses().isEmpty()){
			str += "请先解除教师与对应的课程的关系";
		}
		if(!teacher.getClasses().isEmpty()){
			str += ",解除教师与对应的班级的关系";
		}
		if(str.equals("")){
			return "pass";
		}else{
			return str;
		}
	}
	
	public PageResult<Teacher> findClassPageResult(final String bjbh, final BaseQuery baseQuery) {
		//返回根据查询条件查询的总的记录数
		final int totalRows = this.getClassCount(bjbh,baseQuery);
		//创建PageResult对象
		final PageResult<Teacher> pageResult = new PageResult<Teacher>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), totalRows); 
		return  this.hibernateTemplate.execute(new HibernateCallback<PageResult<Teacher>>() {
			public PageResult<Teacher> doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("from Teacher t inner join fetch t.classes c where c.bjbh=:bjbh");
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
				List<Teacher> rows = query.list();
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
				stringBuffer.append("select count(*) from Teacher t inner join t.classes c where c.bjbh=:bjbh");

				Query query = session.createQuery(stringBuffer.toString());
				query.setParameter("bjbh", bjbh);
				Long count = (Long) query.uniqueResult();
				return count.intValue();
			}
		});
	}

	public Teacher getTeacherByKJ(String kcbh, String jsmc) {
		List list = this.hibernateTemplate.find("from Teacher t left join fetch t.courses c where c.kcbh=? and t.jsmc=?", 
				kcbh, jsmc);
		if(list.isEmpty()){
			return null;
		}else{
			return (Teacher) list.get(0);
		}
	}
}
