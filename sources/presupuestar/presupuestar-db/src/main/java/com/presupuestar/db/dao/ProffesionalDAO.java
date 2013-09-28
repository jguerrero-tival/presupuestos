package com.presupuestar.db.dao;

import com.presupuestar.model.user.Proffesional;

public interface ProffesionalDAO extends HibernateDAO<Proffesional> {

	Proffesional getByLoginAccess(String email, String password);
	
}
