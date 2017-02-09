package com.itheima11.xsxsgl.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.itheima11.xsxsgl.base.dao.BaseDao;
import com.itheima11.xsxsgl.query.BaseQuery;
import com.itheima11.xsxsgl.query.PageResult;

public class BaseDaoImpl<T> implements BaseDao<T>{
	private Class classt;
	//元数据
	private ClassMetadata classMetadata;
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.classt = (Class)type.getActualTypeArguments()[0];
	}
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	@PostConstruct
	public void init(){//初始化方法加载classMetadata
		this.classMetadata = this.hibernateTemplate.getSessionFactory().getClassMetadata(this.classt);
	}
	public PageResult<T> findPageResult(final BaseQuery baseQuery) {
		//返回根据查询条件查询的总的记录数
		final int totalRows = this.getCount(baseQuery);
		//创建PageResult对象
		final PageResult<T> pageResult = new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), totalRows); 
		return  this.hibernateTemplate.execute(new HibernateCallback<PageResult<T>>() {

			public PageResult<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("from "+classt.getSimpleName()+" where 1=1");
				Map<String, Object> buildWhere = baseQuery.buildWhere();
				for(Entry<String, Object> entry : buildWhere.entrySet()){
					if(entry.getKey().contains(".")){
						stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey().split("\\.")[1]);
					}else{
						stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey());
					}
				}
				Query query = session.createQuery(stringBuffer.toString());
				for(Entry<String, Object> entry : buildWhere.entrySet()){
					if(entry.getKey().contains(".")){
						query.setParameter(entry.getKey().split("\\.")[1], entry.getValue());
					}else{
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
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
				List<T> rows = query.list();
				//把结果设置到pageResult
				pageResult.setRows(rows);
				return pageResult;
			}
		});
	}
	public Collection<T> findEntry() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from "+classt.getSimpleName());
	}
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}
	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}
	public void deleteEntriesByIDS(Serializable[] ids) {
		/**
		 * [1,2,3,4]-->"1,2,3,4"
		 */
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0; i<ids.length; i++){
			if(i==ids.length-1){
				stringBuffer.append("'"+ids[i]+"'");
			}else {
				stringBuffer.append("'"+ids[i]+"',");
			}
		}
			StringBuffer hql = new StringBuffer();
			/**
			 * this.classt.getSimpleName()是持久化类的名称
			 */
			hql.append("from "+this.classt.getSimpleName());
			//this.classMetadata.getIdentifierPropertyName()是持久化类id的名称
			hql.append(" where "+this.classMetadata.getIdentifierPropertyName());
			hql.append(" in("+stringBuffer.toString()+")");
			List<T> list = this.hibernateTemplate.find(hql.toString());
			this.hibernateTemplate.deleteAll(list);
	}
	public void deleteEntry(Serializable id) {
		T t = (T) this.hibernateTemplate.get(classt, id);
		hibernateTemplate.delete(t);
	}
	public T getEntryBId(Serializable id) {
		return (T) this.hibernateTemplate.get(classt, id);
	}
	public Set<T> getEntriesByIds(Serializable[] ids) {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0; i<ids.length; i++){
			if(i==ids.length-1){
				stringBuffer.append(ids[i]);
			}else {
				stringBuffer.append(ids[i]+",");
			}
		}
		StringBuffer hql = new StringBuffer();
		/**
		 * this.classt.getSimpleName()是持久化类的名称
		 */
		hql.append("from "+this.classt.getSimpleName());
		//this.classMetadata.getIdentifierPropertyName()是持久化类id的名称
		hql.append(" where "+this.classMetadata.getIdentifierPropertyName());
		hql.append(" in("+stringBuffer.toString()+")");
		List<T> list = this.hibernateTemplate.find(hql.toString());
		return new HashSet<T>(list);//从list到set的转换
	}
	public int getCount(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("select count("+classMetadata.getIdentifierPropertyName()+") from " + classt.getSimpleName());
				stringBuffer.append(" where 1=1");
				//获取所有的查询条件
				Map<String, Object> buildWhere = baseQuery.buildWhere();
				//拼接查询条件
				for(Entry<String, Object> entry : buildWhere.entrySet()){
					if(entry.getKey().contains(".")){
						stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey().split("\\.")[1]);
					}else{
						stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey());
					}
				}
				Query query = session.createQuery(stringBuffer.toString());
				/**
				 * 把where条件中的参数传递的过程
				 */
				for(Entry<String, Object> entry : buildWhere.entrySet()){
					if(entry.getKey().contains(".")){
						query.setParameter(entry.getKey().split("\\.")[1], entry.getValue());
					}else{
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				Long count = (Long) query.uniqueResult();
				return count.intValue();
			}
		});
	}
	
	
}
