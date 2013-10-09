package com.presupuestar.db.dao.impl;

import java.util.List;

import com.presupuestar.db.dao.ProfessionDAO;
import com.presupuestar.model.profession.Category;
import com.presupuestar.model.profession.Profession;

public class ProfessionDAOImpl extends AbstractHibernateDAO<Profession>
		implements ProfessionDAO {

	public ProfessionDAOImpl() {
		super(Profession.class);
	}

	@Override
	public Profession getByName(String profession) {
		StringBuilder query = new StringBuilder();
		query.append("from Profession where name = '");
		query.append(profession);
		query.append("'");
		return (Profession) getCurrentSession().createQuery(query.toString())
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profession> getByCategory(Category category) {
		StringBuilder query = new StringBuilder();
		query.append("from Profession where category.id = '");
		query.append(category.getId());
		query.append("'");
		return getCurrentSession().createQuery(query.toString())
				.list();
	}
	
}
