package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.ProfessionalDAO;
import com.presupuestar.model.user.Professional;

public class ProfessionalDAOImpl extends AbstractHibernateDAO<Professional>
		implements ProfessionalDAO {

	public ProfessionalDAOImpl() {
		super(Professional.class);
	}

	@Override
	public Professional getByLoginAccess(String email, String password) {
		StringBuilder query = new StringBuilder();
		query.append("from Professional where access.email = '");
		query.append(email);
		query.append("' and password = '");
		query.append(password);
		query.append("'");
		return (Professional) getCurrentSession().createQuery(query.toString())
				.uniqueResult();
	}

}
