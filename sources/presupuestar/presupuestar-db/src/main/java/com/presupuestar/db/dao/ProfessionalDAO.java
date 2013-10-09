package com.presupuestar.db.dao;

import java.util.List;

import com.presupuestar.model.profession.Category;
import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Professional;

public interface ProfessionalDAO extends HibernateDAO<Professional> {

	Professional getByLoginAccess(String email, String password);

	List<Professional> getByCategory(Category category);

	List<Professional> getByProfession(Profession profession);
	
}
