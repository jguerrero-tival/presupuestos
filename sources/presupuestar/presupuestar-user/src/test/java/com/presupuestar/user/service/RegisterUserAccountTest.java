package com.presupuestar.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.ProffesionDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.proffesion.Proffesion;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.Person;
import com.presupuestar.model.user.Proffesional;
import com.presupuestar.model.user.ProffesionalType;
import com.presupuestar.model.user.User;
import com.presupuestar.user.service.impl.CommerceServiceImpl;
import com.presupuestar.user.service.impl.PersonServiceImpl;
import com.presupuestar.user.service.impl.ProffesionalServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:presupuestar-user.xml" })
@Transactional
public class RegisterUserAccountTest {

	private static final String EMAIL = "sebastianlavie@gmail.com",
			PASSWORD = "password";
	private static final String FIRST_NAME = "Sebastian", LAST_NAME = "Lavie";
	private static final String REASON = "My Company S.A.";

	private CommerceService commerceService = new CommerceServiceImpl();
	private ProffesionalService proffesionalService = new ProffesionalServiceImpl();
	private PersonService personService = new PersonServiceImpl();

	@Test
	public void registerNewCommerceAccount() {
		Commerce commerce = commerceService.registerNewCommerceAccount(EMAIL,
				PASSWORD, REASON);
		Assert.assertNotNull(commerce);
		assertUserAccess(commerce);
	}

	@Test
	public void refisterNewProffesionalAccount() {
		ProffesionDAO proffesionDao = (ProffesionDAO) DAOLocator.getInstance()
				.getDao(ProffesionDAO.class);
		Proffesion proffesion = proffesionDao.getById(Long.valueOf(1));
		Proffesional proffesional = proffesionalService
				.registerNewProffesionalAccount(EMAIL, PASSWORD, FIRST_NAME,
						LAST_NAME, ProffesionalType.SELF_EMPLOYED, proffesion);
		Assert.assertNotNull(proffesional);
		assertUserAccess(proffesional);
	}

	@Test
	public void registerNewPersonAccount() {
		Person person = personService.registerNewPersonAccount(EMAIL, PASSWORD,
				FIRST_NAME, LAST_NAME);
		Assert.assertNotNull(person);
		assertUserAccess(person);
	}

	private void assertUserAccess(User user) {
		Assert.assertNotNull(user.getAccess());
		Assert.assertEquals(EMAIL, user.getAccess().getEmail());
		Assert.assertEquals(PASSWORD, user.getAccess().getPassword());
	}

}
