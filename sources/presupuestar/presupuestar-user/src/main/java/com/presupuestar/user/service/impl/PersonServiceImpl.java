package com.presupuestar.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.PersonDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.user.Person;
import com.presupuestar.user.builder.UserBuilder;
import com.presupuestar.user.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Override
	public Person registerNewPersonAccount(String email, String password,
			String firstName, String lastName) {
		UserBuilder builder = UserBuilder.forPerson();
		builder.buildUserAccess(email, password);
		builder.buildName(firstName, lastName);
		Person person = builder.getPerson();
		PersonDAO personDao = (PersonDAO) DAOLocator.getInstance().getDao(
				PersonDAO.class);
		personDao.create(person);
		return person;
	}

	@Override
	public Person userLogin(String email, String password) {
		PersonDAO personDao = (PersonDAO) DAOLocator.getInstance().getDao(
				PersonDAO.class);
		return personDao.getByLoginAccess(email, password);
	}

}
