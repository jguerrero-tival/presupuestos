package com.presupuestar.db.dao;

import java.util.List;

import com.presupuestar.model.profession.Category;
import com.presupuestar.model.profession.Profession;

public interface ProfessionDAO extends HibernateDAO<Profession> {

	Profession getByName(String profession);

	List<Profession> getByCategory(Category category);

}
