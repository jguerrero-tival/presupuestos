package com.presupuestar.db.dao;

import com.presupuestar.model.user.Person;

public interface PersonDAO extends HibernateDAO<Person> {

	Person getByLoginAccess(String email, String password);

}
