/**
 * Copyright(c) 2014 Dialog-University of Moratuwa Mobile Communications Research Laboratory. All
 * Rights Reserved. This software is the proprietary information of Dialog-University of Moratuwa
 * Mobile Communications Research Laboratory(Dialog-UOM Lab).
 *
 * Dialog-UOM Lab or Dialog Axiata PLC reserves to right to modify, update and/or enhance the
 * software as it sees fit.
 *
 */
package lk.dialoglab.ezcash.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import lk.dialoglab.ezcash.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	protected HibernateUtil hibernateUtil;

	public GenericDAOImpl() {

	}

	@Autowired
	public GenericDAOImpl(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	protected Session getSession() {

		return hibernateUtil.getSession();
	}

	public void save(Object object) {
		Session hibernateSession = this.getSession();
		hibernateSession.saveOrUpdate(object);
		hibernateSession.flush();
	 
	}

	public void update(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.update(entity);
		hibernateSession.flush();
	}

	public void delete(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.delete(entity);
		hibernateSession.flush();
	}

	public List<T> findMany(Query query) {
		List<T> t;
		t = (List<T>) query.list();
		return t;
	}

	public T findOne(Query query) {
		T t;
		t = (T) query.uniqueResult();
		return t;
	}

	public T findByID(Class clazz, Number id) {
		Session hibernateSession = this.getSession();
		T t = null;
		t = (T) hibernateSession.get(clazz, id);
		return t;
	}

	public List findAll(Class clazz) {
		Session hibernateSession = this.getSession();
		List T = null;
		Query query = hibernateSession.createQuery("from " + clazz.getName());
		T = query.list();
		return T;
	}
}
