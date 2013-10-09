package com.presupuestar.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.presupuestar.db.dao.CommerceDAO;
import com.presupuestar.model.user.Commerce;

@Repository
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
