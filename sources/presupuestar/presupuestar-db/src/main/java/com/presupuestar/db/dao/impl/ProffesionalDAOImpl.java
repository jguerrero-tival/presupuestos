package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.ProffesionalDAO;
import com.presupuestar.model.user.Proffesional;

public class ProffesionalDAOImpl extends AbstractHibernateDAO<Proffesional> implements ProffesionalDAO {

	public ProffesionalDAOImpl() {
		super(Proffesional.class);
	}

}
