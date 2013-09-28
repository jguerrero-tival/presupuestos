package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.CommerceDAO;
import com.presupuestar.model.user.Commerce;

public class CommerceDAOImpl extends AbstractHibernateDAO<Commerce> implements
		CommerceDAO {

	public CommerceDAOImpl() {
		super(Commerce.class);
	}

	@Override
	public Commerce getByLoginAccess(String email, String password) {
		StringBuilder query = new StringBuilder();
		query.append("from Commerce where access.email = '");
		query.append(email);
		query.append("' and password = '");
		query.append(password);
		query.append("'");
		return (Commerce) getCurrentSession().createQuery(query.toString())
				.uniqueResult();
	}

}
