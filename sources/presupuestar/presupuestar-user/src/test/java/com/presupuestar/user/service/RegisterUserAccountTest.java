package com.presupuestar.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.ProfessionDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.Person;
import com.presupuestar.model.user.Professional;
import com.presupuestar.model.user.User;
import com.presupuestar.user.exception.InvalidEmailFormatException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-presupuestar-user.xml" })
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
	private ProfessionalService professionalService;
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
	public void refisterNewProfessionalAccount()
			throws InvalidEmailFormatException {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		Profession profession = professionDao.getById(Long.valueOf(1));
		Professional professional = professionalService
				.registerNewProfessionalAccount(EMAIL, PASSWORD, FIRST_NAME,
						LAST_NAME, profession);
		Assert.assertNotNull(professional);
		assertUserAccess(professional);
	}

	@Test(expected = InvalidEmailFormatException.class)
	public void registerNewProfessionalUsingWrongEmail()
			throws InvalidEmailFormatException {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		Profession profession = professionDao.getById(Long.valueOf(1));
		professionalService.registerNewProfessionalAccount(WRONG_EMAIL,
				PASSWORD, FIRST_NAME, LAST_NAME, profession);
	}

	@Test
	public void refisterNewCompanyAccount() throws InvalidEmailFormatException {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		Profession profession = professionDao.getById(Long.valueOf(1));
		Professional company = professionalService.registerNewCompanyAccount(
				EMAIL, PASSWORD, REASON, profession);
		Assert.assertNotNull(company);
		assertUserAccess(company);
	}

	@Test(expected = InvalidEmailFormatException.class)
	public void refisterNewCompanyUsingWrongEmail()
			throws InvalidEmailFormatException {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		Profession profession = professionDao.getById(Long.valueOf(1));
		professionalService.registerNewCompanyAccount(WRONG_EMAIL, PASSWORD,
				REASON, profession);
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
