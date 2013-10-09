package com.presupuestar.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.presupuestar.db.dao.CategoryDAO;
import com.presupuestar.model.profession.Category;

@Repository
public class CategoryDAOImpl extends AbstractHibernateDAO<Category> implements CategoryDAO {

	public CategoryDAOImpl() {
		super(Category.class);
	}

}
