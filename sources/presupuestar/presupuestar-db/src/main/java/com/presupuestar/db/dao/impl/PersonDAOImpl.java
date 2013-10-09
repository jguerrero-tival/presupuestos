package com.presupuestar.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.presupuestar.db.dao.PersonDAO;
import com.presupuestar.model.user.Person;

@Repository
public class PersonDAOImpl extends AbstractHibernateDAO<Person> implements
		PersonDAO {

	public PersonDAOImpl() {
		super(Person.class);
	}

	@Override
	public Person getByLoginAccess(String email, String password) {
		StringBuilder query = new StringBuilder();
		query.append("from Person where access.email = '");
		query.append(email);
		query.append("' and password = '");
		query.append(password);
		query.append("'");
		return (Person) getCurrentSession().createQuery(query.toString())
				.uniqueResult();
	}

}
