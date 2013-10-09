package com.presupuestar.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.presupuestar.db.dao.ProfessionalDAO;
import com.presupuestar.model.profession.Category;
import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Professional;

@Repository
public class ProfessionalDAOImpl extends AbstractHibernateDAO<Professional>
		implements ProfessionalDAO {

	public ProfessionalDAOImpl() {
		super(Professional.class);
	}

	@Override
	public Professional getByLoginAccess(String email, String password) {
		StringBuilder query = new StringBuilder();
		query.append("from Professional where access.email = '");
		query.append(email);
		query.append("' and password = '");
		query.append(password);
		query.append("'");
		return (Professional) getCurrentSession().createQuery(query.toString())
				.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Professional> getByCategory(Category category) {
		StringBuilder query = new StringBuilder();
		query.append("from Professional where profession.category.id = '");
		query.append(category.getId());
		query.append("'");
		return getCurrentSession().createQuery(query.toString()).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Professional> getByProfession(Profession profession) {
		StringBuilder query = new StringBuilder();
		query.append("from Professional where profession.id = '");
		query.append(profession.getId());
		query.append("'");
		return getCurrentSession().createQuery(query.toString()).list();
	}

}
