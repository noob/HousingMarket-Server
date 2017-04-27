package com.dale.ms.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.dale.ms.model.Pagenation;

/**
 * 
 * @author Dale'
 * @date 2016-3-2 下午12:12:27
 * @description
 */
@Transactional
public abstract class BaseDaoImpl {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	/**
	 * hibernate保存
	 * @param obj
	 * @return
	 */
	public boolean save(Object obj) {
		boolean flag = true;
		Session session = getCurrentSession();
		try {
			session.save(obj);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		clearSession(session);
		return flag;
	}
	
	/**
	 * hibernate merge
	 * @param obj
	 * @return
	 */
	public boolean merge(Object obj) {
		boolean flag = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.merge(obj);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		clearSession(session);
		return flag;
	}

	/**
	 * hibernate更新
	 * @param obj
	 * @return
	 */
	public boolean update(Object obj) {
		boolean flag = true;
		Session session = getCurrentSession();
		try {
			session.update(obj);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		clearSession(session);
		return flag;
	}
	
	/**
	 * hibernate保存或更新
	 * @param obj
	 * @return
	 */
	public boolean saveOrUpdate(Object obj) {
		boolean flag = true;
		Session session = getCurrentSession();
		try {
			session.saveOrUpdate(obj);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		clearSession(session);
		return flag;
	}

	/**
	 * hibernate删除
	 * @param obj
	 * @return
	 */
	public boolean delete(Object obj) {
		boolean flag = true;
		Session session = getCurrentSession();
		try {
			session.delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		clearSession(session);
		return flag;
	}

	/**
	 * 查询List<?>
	 * @param hql
	 * @param params
	 * @return list
	 */
	public List<?> getResult(String hql, Object[] params) {
		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List<?> list = query.list();
		clearSession(session);
		return list;
	}

	/**
	 * 查询单个对象
	 * @param hql
	 * @param params
	 * @return obj
	 */
	public Object getResultOne(String hql, Object[] params) {
		
		Session session= getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		Object obj = query.uniqueResult();
		clearSession(session);
		return obj;
	}
	
	/**
	 * 原生sql语句获得查询对象列表
	 * @param sql		查询语句
	 * @param clazz	对象类型
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<?> createSQLQueryList(String sql,Class clazz,Object[] params){
		Session session= getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		query.setResultTransformer(Transformers.aliasToBean(clazz));
		List<?> list = query.list();
		clearSession(session);
		return list;
	}
	/**
	 * 创建SQL查询单个对象语句
	 * @param sql		
	 * @param clazz
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object createSQLQueryOne(String sql,Class clazz,Object[] params,Map<String,?> transform){
		
		Session session= getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		if(transform != null){
			for(String key : transform.keySet()){
				query.addScalar(key,(Type) transform.get(key));
			}
		}
		Object object = query.setResultTransformer(Transformers.aliasToBean(clazz)).uniqueResult();
		clearSession(session);
		return object;
	}
	
	/**
	 * 模糊查询
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<?> fuzzyQuery(String hql, Object[] params) {
		Session session= getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length-1; i++){
				query.setParameter(i, params[i]);
			}
			query.setString("value", "%" + params[params.length-1] + "%");
		}
		List<?> list = query.list();
		clearSession(session);
		return list;
	}
	

	/**
	 * 分页模糊查询
	 * @return
	 */
	public List<?> fuzzyQueryByPage(String hql, Object[] params,Pagenation pagenation) {
		Session session= getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.length > 0){
			int length = params.length;
			if(hql.contains(":value") && hql.contains("like")){
				query.setString("value", "%" + params[params.length-1] + "%");
				length -= 1;
			}
			for(int i=0; i < length; i++){
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult((pagenation.getPage() - 1) * pagenation.getPageSize());
		query.setMaxResults(pagenation.getPageSize());
		List<?> list = query.list();
		clearSession(session);
		return list;
	}
	
	/**
	 * 模糊查询记录数
	 * @return
	 */
	public int fuzzyResultCount(String hql,Object[] params){
		Session session= getCurrentSession();
		Query query = session.createQuery(hql);
		if (params != null && params.length > 0) {
			int length = params.length;
			if(hql.contains(":value") && hql.contains("like")){
				query.setString("value", "%" + params[params.length-1] + "%");
				length -= 1;
			}
			for (int i = 0; i < length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		int count = ((Long)query.uniqueResult()).intValue();
		clearSession(session);;
		return count;
	}

	/**
	 * 执行原生SQL语句更新
	 * @return
	 */
	public Integer nativeUpdate(String sql){
		Session session= getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		Integer colunms = query.executeUpdate();
		clearSession(session);
		return colunms;
	}
	
	/**
	 * 根据ID查询
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object findById(@SuppressWarnings("rawtypes") Class clazz, Serializable id) {
		Session session= sessionFactory.getCurrentSession();
		Object obj = session.load(clazz, id);
		clearSession(session);
		return obj;
	}
	
	public void clearSession(Session session) {
		session.flush();
		// session.clear();
	}
	
}
