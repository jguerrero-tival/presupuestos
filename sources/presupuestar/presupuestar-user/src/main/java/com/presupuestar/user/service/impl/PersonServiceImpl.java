package com.presupuestar.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.PersonDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.user.Person;
import com.presupuestar.user.builder.UserBuilder;
import com.presupuestar.user.exception.InvalidEmailFormatException;
import com.presupuestar.user.service.PersonService;
import com.presupuestar.user.validator.EmailFormatValidator;

@Service
public class PersonServiceImpl implements PersonService {

	private EmailFormatValidator emailFormatValidator;

	public EmailFormatValidator getEmailFormatValidator() {
		return emailFormatValidator;
	}

	public void setEmailFormatValidator(
			EmailFormatValidator emailFormatValidator) {
		this.emailFormatValidator = emailFormatValidator;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Person registerNewPersonAccount(String email, String password,
			String firstName, String lastName)
			throws InvalidEmailFormatException {
		if (!emailFormatValidator.validate(email)) {
			throw new InvalidEmailFormatException(email);
		}
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
	@Transactional(readOnly = true)
	public Person userLogin(String email, String password) {
		PersonDAO personDao = (PersonDAO) DAOLocator.getInstance().getDao(
				PersonDAO.class);
		return personDao.getByLoginAccess(email, password);
	}

}
