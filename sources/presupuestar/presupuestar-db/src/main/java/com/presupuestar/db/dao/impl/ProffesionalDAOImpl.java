package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.ProffesionalDAO;
import com.presupuestar.model.user.Proffesional;

public class ProffesionalDAOImpl extends AbstractHibernateDAO<Proffesional>
		implements ProffesionalDAO {

	public ProffesionalDAOImpl() {
		super(Proffesional.class);
	}

	@Override
	public Proffesional getByLoginAccess(String email, String password) {
		StringBuilder query = new StringBuilder();
		query.append("from Proffesional where access.email = '");
		query.append(email);
		query.append("' and password = '");
		query.append(password);
		query.append("'");
		return (Proffesional) getCurrentSession().createQuery(query.toString())
				.uniqueResult();
	}

}
