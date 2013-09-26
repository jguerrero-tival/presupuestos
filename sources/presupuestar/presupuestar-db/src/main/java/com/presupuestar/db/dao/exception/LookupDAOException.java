package com.presupuestar.db.dao.exception;

import com.presupuestar.db.dao.HibernateDAO;
import com.presupuestar.model.DomainObject;

public class LookupDAOException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Class<? extends HibernateDAO<? extends DomainObject>> clazz;

	public LookupDAOException(
			Class<? extends HibernateDAO<? extends DomainObject>> clazz) {
		super();
		this.clazz = clazz;
	}

	@Override
	public String getMessage() {
		if (clazz == null) {
			return "Try to get 'null' DAO.";
		}
		return "Try to get DAO of Class: " + clazz.getName();
	}

}
