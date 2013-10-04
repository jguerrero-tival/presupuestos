package com.presupuestar.db.dao;

import com.presupuestar.model.user.Professional;

public interface ProfessionalDAO extends HibernateDAO<Professional> {

	Professional getByLoginAccess(String email, String password);
	
}
