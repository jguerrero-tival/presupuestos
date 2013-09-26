package com.presupuestar.db.dao;

import java.io.Serializable;
import java.util.List;

public interface HibernateDAO<T extends Serializable> {

	T getById(final Long id);

	List<T> getAll();

	void create(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(final Long entityId);

}
