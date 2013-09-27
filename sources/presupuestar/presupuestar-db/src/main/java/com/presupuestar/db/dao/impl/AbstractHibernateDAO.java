package com.presupuestar.db.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;
import com.presupuestar.db.dao.HibernateDAO;

@Repository
public abstract class AbstractHibernateDAO<T extends Serializable> implements
		HibernateDAO<T> {

	private final Class<T> clazz;
	private SessionFactory sessionFactory;

	public AbstractHibernateDAO(final Class<T> clazz) {
		this.clazz = clazz;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected final Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getById(final Long id) {
		Preconditions.checkArgument(id != null);
		return (T) this.getCurrentSession().get(this.clazz.getSimpleName(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return this.getCurrentSession()
				.createQuery("from " + this.clazz.getSimpleName()).list();
	}

	public void create(final T entity) {
		Preconditions.checkNotNull(entity);
		this.getCurrentSession().persist(entity.getClass().getSimpleName(), entity);
	}

	public void update(final T entity) {
		Preconditions.checkNotNull(entity);
		this.getCurrentSession().merge(entity);
	}

	public void delete(final T entity) {
		Preconditions.checkNotNull(entity);
		this.getCurrentSession().delete(entity);
	}

	public void deleteById(final Long entityId) {
		final T entity = this.getById(entityId);
		Preconditions.checkState(entity != null);
		this.delete(entity);
	}

}
