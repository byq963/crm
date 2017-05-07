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
	
	//���
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
	//ɾ��
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
	//�޸�
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
	//����id��ѯ��Ӧ�Ķ���
	public Object getT(Class cla,long id){
		return super.getHibernateTemplate().get(cla, id);
	}
	//����id��ѯ��Ӧ�Ķ���
		public Object getT(Class cla,int id){
			return super.getHibernateTemplate().get(cla, id);
		}
	//��ѯ���еĶ���
	public List queryAllT(String hql){
		return super.getHibernateTemplate().find(hql);
	}
	
	/**
	 * ��������ѯ(���������ֶεĲ�ѯ��������ݶ����״̬���еĲ�ѯ����½ʱ����֤��
	 * �����ı�������ֵ���в�ѯ��������ʵ���и��������Ƕ����״̬����ѯʱ���Ӷ���
	 * ��״̬���ɵȵ�)
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
	//��ҳ
	public List queryByPage(final String hql,final Map<String,Object> maps,final int page,final int pagesize){
		return super.getHibernateTemplate().executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				//firstResult����ʼλ�ã�maxResultΪÿҳ��ʾ������
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
