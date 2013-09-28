package com.presupuestar.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.Person;
import com.presupuestar.model.user.Proffesional;
import com.presupuestar.user.service.impl.CommerceServiceImpl;
import com.presupuestar.user.service.impl.PersonServiceImpl;
import com.presupuestar.user.service.impl.ProffesionalServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:presupuestar-user.xml" })
@Transactional
public class UserLoginTest {

	private static final String COMMERCE_EMAIL = "commerce@presupuestar.com",
			PROFFESIONAL_EMAIL = "proffesional@presupuestar.com",
			PERSON_EMAIL = "person@presupuestar.com", PASSWORD = "password";
	private static String WRONG_EMAIL = "wrong@presupuestar.com",
			WRONG_PASSWORD = "wrong-password";

	private CommerceService commerceService = new CommerceServiceImpl();
	private ProffesionalService proffesionalService = new ProffesionalServiceImpl();
	private PersonService personService = new PersonServiceImpl();

	@Test
	public void commerceLogin() {
		Commerce commerce = commerceService.userLogin(COMMERCE_EMAIL, PASSWORD);
		Assert.assertNotNull(commerce);
		Assert.assertNotNull(commerce.getAccess());
		Assert.assertEquals(COMMERCE_EMAIL, commerce.getAccess().getEmail());
		Assert.assertEquals(PASSWORD, commerce.getAccess().getPassword());
	}

	@Test
	public void commerceLoginWithWrongEmail() {
		Commerce commerce = commerceService.userLogin(WRONG_EMAIL, PASSWORD);
		Assert.assertNull(commerce);
	}

	@Test
	public void commerceLoginWithWrongPassword() {
		Commerce commerce = commerceService.userLogin(PERSON_EMAIL,
				WRONG_PASSWORD);
		Assert.assertNull(commerce);
	}

	@Test
	public void proffesionalUserLogin() {
		Proffesional proffesional = proffesionalService.userLogin(
				PROFFESIONAL_EMAIL, PASSWORD);
		Assert.assertNotNull(proffesional);
		Assert.assertNotNull(proffesional.getAccess());
		Assert.assertEquals(PROFFESIONAL_EMAIL, proffesional.getAccess()
				.getEmail());
		Assert.assertEquals(PASSWORD, proffesional.getAccess().getPassword());
	}

	@Test
	public void proffesionalLoginWithWrongEmail() {
		Proffesional proffesional = proffesionalService.userLogin(WRONG_EMAIL,
				PASSWORD);
		Assert.assertNull(proffesional);
	}

	@Test
	public void proffesionalLoginWithWrongPassword() {
		Proffesional proffesional = proffesionalService.userLogin(PERSON_EMAIL,
				WRONG_PASSWORD);
		Assert.assertNull(proffesional);
	}

	@Test
	public void personLogin() {
		Person person = personService.userLogin(PERSON_EMAIL, PASSWORD);
		Assert.assertNotNull(person);
		Assert.assertNotNull(person.getAccess());
		Assert.assertEquals(PERSON_EMAIL, person.getAccess().getEmail());
		Assert.assertEquals(PASSWORD, person.getAccess().getPassword());
	}

	@Test
	public void personLoginWithWrongEmail() {
		Person person = personService.userLogin(WRONG_EMAIL, PASSWORD);
		Assert.assertNull(person);
	}

	@Test
	public void personLoginWithWrongPassword() {
		Person person = personService.userLogin(PERSON_EMAIL, WRONG_PASSWORD);
		Assert.assertNull(person);
	}

}
