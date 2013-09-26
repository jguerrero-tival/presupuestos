package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.ProffesionDAO;
import com.presupuestar.model.proffesion.Proffesion;

public class ProffesionDAOImpl extends AbstractHibernateDAO<Proffesion>
		implements ProffesionDAO {

	public ProffesionDAOImpl() {
		super(Proffesion.class);
	}

}
