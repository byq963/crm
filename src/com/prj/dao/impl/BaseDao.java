package com.prj.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao extends HibernateDaoSupport{
	
	//添加
	public boolean addT(Object t){
		boolean flag=false;
		try {
			super.getHibernateTemplate().save(t);
			flag=true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//删除
	public boolean deleteT(Object t){
		boolean flag=false;
		try {
			super.getHibernateTemplate().delete(t);
			flag=true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//修改
	public boolean updateT(Object t){
		boolean flag=false;
		try {
			super.getHibernateTemplate().update(t);
			flag=true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//根据id查询对应的对象
	public Object getT(Class cla,long id){
		return super.getHibernateTemplate().get(cla, id);
	}
	//根据id查询对应的对象
		public Object getT(Class cla,int id){
			return super.getHibernateTemplate().get(cla, id);
		}
	//查询所有的对象
	public List queryAllT(String hql){
		return super.getHibernateTemplate().find(hql);
	}
	
	/**
	 * 多条件查询(包含各种字段的查询，例如根据对象的状态进行的查询，登陆时的验证，
	 * 几个文本框输入值进行查询，这里其实还有个条件就是对象的状态，查询时增加对象
	 * 的状态即可等等)
	 */
	
	public List queryByCondition(final String hql,final Map<String,Object> maps){
		return super.getHibernateTemplate().executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery(hql);
				if(maps!=null&&!maps.isEmpty()){
					query.setProperties(maps);
				}
				return query.list();
			}
		});
		
	}
	//分页
	public List queryByPage(final String hql,final Map<String,Object> maps,final int page,final int pagesize){
		return super.getHibernateTemplate().executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				//firstResult是起始位置，maxResult为每页显示的条数
				Query query=session.createQuery(hql);
				if(maps!=null&&!maps.isEmpty()){
					query.setProperties(maps);
				}
				query.setFirstResult((page-1)*pagesize);
				query.setMaxResults(pagesize);
				return query.list();
			}
		});
	}
	
	
}
