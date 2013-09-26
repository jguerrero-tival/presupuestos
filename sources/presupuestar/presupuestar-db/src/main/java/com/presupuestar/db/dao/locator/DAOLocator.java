package com.presupuestar.db.dao.locator;

import java.util.Map;

import com.presupuestar.db.dao.HibernateDAO;
import com.presupuestar.db.dao.exception.LookupDAOException;
import com.presupuestar.model.DomainObject;

public class DAOLocator {

	private static DAOLocator instance;
	private Map<String, HibernateDAO<? extends HibernateDAO<? extends DomainObject>>> daos;

	private DAOLocator() {
		super();
	}

	public static synchronized DAOLocator getInstance() {
		if (instance == null) {
			instance = new DAOLocator();
		}
		return instance;
	}

	public Map<String, HibernateDAO<? extends HibernateDAO<? extends DomainObject>>> getDaos() {
		return daos;
	}

	public void setDaos(Map<String, HibernateDAO<? extends HibernateDAO<? extends DomainObject>>> daos) {
		this.daos = daos;
	}

	public HibernateDAO<? extends HibernateDAO<? extends DomainObject>> getDao(
			Class<? extends HibernateDAO<? extends DomainObject>> clazz) {
		if(clazz == null || !HibernateDAO.class.isAssignableFrom(clazz)) {
			throw new LookupDAOException(clazz);
		}
		return daos.get(clazz.getName());
	}

}
