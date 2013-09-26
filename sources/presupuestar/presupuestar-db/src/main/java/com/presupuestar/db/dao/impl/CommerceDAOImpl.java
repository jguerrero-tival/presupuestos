package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.CommerceDAO;
import com.presupuestar.model.user.Commerce;

public class CommerceDAOImpl extends AbstractHibernateDAO<Commerce> implements CommerceDAO {

	public CommerceDAOImpl() {
		super(Commerce.class);
	}

}
