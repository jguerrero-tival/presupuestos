package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.CategoryDAO;
import com.presupuestar.model.profession.Category;

public class CategoryDAOImpl extends AbstractHibernateDAO<Category> implements CategoryDAO {

	public CategoryDAOImpl() {
		super(Category.class);
	}

}
