package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.ProffesionDAO;
import com.presupuestar.model.proffesion.Proffesion;

public class ProffesionDAOImpl extends AbstractHibernateDAO<Proffesion>
		implements ProffesionDAO {

	public ProffesionDAOImpl() {
		super(Proffesion.class);
	}

	@Override
	public Proffesion getByName(String proffesion) {
		StringBuilder query = new StringBuilder();
		query.append("from Proffesion where name = '");
		query.append(proffesion);
		query.append("'");
		return (Proffesion) getCurrentSession().createQuery(query.toString())
				.uniqueResult();
	}

}
