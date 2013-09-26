package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.PersonDAO;
import com.presupuestar.model.user.Person;

public class PersonDAOImpl extends AbstractHibernateDAO<Person> implements PersonDAO {

	public PersonDAOImpl() {
		super(Person.class);
	}

}
