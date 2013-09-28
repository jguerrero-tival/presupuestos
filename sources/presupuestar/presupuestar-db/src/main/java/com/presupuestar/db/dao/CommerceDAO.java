package com.presupuestar.db.dao;

import com.presupuestar.model.user.Commerce;

public interface CommerceDAO extends HibernateDAO<Commerce> {

	Commerce getByLoginAccess(String email, String password);
	
}
