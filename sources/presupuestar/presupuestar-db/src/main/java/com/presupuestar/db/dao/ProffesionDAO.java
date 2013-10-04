package com.presupuestar.db.dao;

import com.presupuestar.model.proffesion.Proffesion;

public interface ProffesionDAO extends HibernateDAO<Proffesion> {

	Proffesion getByName(String proffesion);

}
