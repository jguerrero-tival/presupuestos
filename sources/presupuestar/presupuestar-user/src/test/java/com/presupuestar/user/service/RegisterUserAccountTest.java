package com.presupuestar.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.ProffesionDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.proffesion.Proffesion;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.Person;
import com.presupuestar.model.user.Proffesional;
import com.presupuestar.model.user.User;
import com.presupuestar.user.exception.InvalidEmailFormatException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:presupuestar-user.xml" })
@Transactional
public class RegisterUserAccountTest {

	private static final String EMAIL = "sebastianlavie@gmail.com",
			PASSWORD = "password";
	private static final String WRONG_EMAIL = "..wrong@email.com.";
	private static final String FIRST_NAME = "Sebastian", LAST_NAME = "Lavie";
	private static final String REASON = "My Company S.A.";

	@Autowired
	private CommerceService commerceService;
	@Autowired
	private ProffesionalService proffesionalService;
	@Autowired
	private PersonService personService;

	@Test
	public void registerNewCommerceAccount() throws InvalidEmailFormatException {
		Commerce commerce = commerceService.registerNewCommerceAccount(EMAIL,
				PASSWORD, REASON);
		Assert.assertNotNull(commerce);
		assertUserAccess(commerce);
	}

	@Test(expected = InvalidEmailFormatException.class)
	public void registerNewCommerceUsingWrongEmail()
			throws InvalidEmailFormatException {
		commerceService.registerNewCommerceAccount(WRONG_EMAIL, PASSWORD,
				REASON);
	}

	@Test
	public void refisterNewProffesionalAccount()
			throws InvalidEmailFormatException {
		ProffesionDAO proffesionDao = (ProffesionDAO) DAOLocator.getInstance()
				.getDao(ProffesionDAO.class);
		Proffesion proffesion = proffesionDao.getById(Long.valueOf(1));
		Proffesional proffesional = proffesionalService
				.registerNewProffesionalAccount(EMAIL, PASSWORD, FIRST_NAME,
						LAST_NAME, proffesion);
		Assert.assertNotNull(proffesional);
		assertUserAccess(proffesional);
	}

	@Test(expected = InvalidEmailFormatException.class)
	public void registerNewProffesionalUsingWrongEmail()
			throws InvalidEmailFormatException {
		ProffesionDAO proffesionDao = (ProffesionDAO) DAOLocator.getInstance()
				.getDao(ProffesionDAO.class);
		Proffesion proffesion = proffesionDao.getById(Long.valueOf(1));
		proffesionalService.registerNewProffesionalAccount(WRONG_EMAIL,
				PASSWORD, FIRST_NAME, LAST_NAME, proffesion);
	}

	@Test
	public void refisterNewCompanyAccount() throws InvalidEmailFormatException {
		ProffesionDAO proffesionDao = (ProffesionDAO) DAOLocator.getInstance()
				.getDao(ProffesionDAO.class);
		Proffesion proffesion = proffesionDao.getById(Long.valueOf(1));
		Proffesional company = proffesionalService.registerNewCompanyAccount(
				EMAIL, PASSWORD, REASON, proffesion);
		Assert.assertNotNull(company);
		assertUserAccess(company);
	}

	@Test(expected = InvalidEmailFormatException.class)
	public void refisterNewCompanyUsingWrongEmail()
			throws InvalidEmailFormatException {
		ProffesionDAO proffesionDao = (ProffesionDAO) DAOLocator.getInstance()
				.getDao(ProffesionDAO.class);
		Proffesion proffesion = proffesionDao.getById(Long.valueOf(1));
		proffesionalService.registerNewCompanyAccount(WRONG_EMAIL, PASSWORD,
				REASON, proffesion);
	}

	@Test
	public void registerNewPersonAccount() throws InvalidEmailFormatException {
		Person person = personService.registerNewPersonAccount(EMAIL, PASSWORD,
				FIRST_NAME, LAST_NAME);
		Assert.assertNotNull(person);
		assertUserAccess(person);
	}

	@Test(expected = InvalidEmailFormatException.class)
	public void registerNewPersonUsingWrongEmail()
			throws InvalidEmailFormatException {
		personService.registerNewPersonAccount(WRONG_EMAIL, PASSWORD,
				FIRST_NAME, LAST_NAME);
	}

	private void assertUserAccess(User user) {
		Assert.assertNotNull(user.getAccess());
		Assert.assertEquals(EMAIL, user.getAccess().getEmail());
		Assert.assertEquals(PASSWORD, user.getAccess().getPassword());
	}

}
