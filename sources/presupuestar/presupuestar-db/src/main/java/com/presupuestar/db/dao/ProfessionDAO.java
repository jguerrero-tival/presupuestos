package com.presupuestar.db.dao;

import com.presupuestar.model.profession.Profession;

public interface ProfessionDAO extends HibernateDAO<Profession> {

	Profession getByName(String profession);

}
