package com.presupuestar.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.Person;
import com.presupuestar.model.user.Professional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:presupuestar-user.xml" })
@Transactional
public class UserLoginTest {

	private static final String COMMERCE_EMAIL = "commerce@presupuestar.com",
			PROFESSIONAL_EMAIL = "professional@presupuestar.com",
			PERSON_EMAIL = "person@presupuestar.com", PASSWORD = "password";
	private static String WRONG_EMAIL = "wrong@presupuestar.com",
			WRONG_PASSWORD = "wrong-password";

	@Autowired
	private CommerceService commerceService;
	@Autowired
	private ProfessionalService professionalService;
	@Autowired
	private PersonService personService;
	
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
	public void professionalUserLogin() {
		Professional professional = professionalService.userLogin(
				PROFESSIONAL_EMAIL, PASSWORD);
		Assert.assertNotNull(professional);
		Assert.assertNotNull(professional.getAccess());
		Assert.assertEquals(PROFESSIONAL_EMAIL, professional.getAccess()
				.getEmail());
		Assert.assertEquals(PASSWORD, professional.getAccess().getPassword());
	}

	@Test
	public void professionalLoginWithWrongEmail() {
		Professional professional = professionalService.userLogin(WRONG_EMAIL,
				PASSWORD);
		Assert.assertNull(professional);
	}

	@Test
	public void professionalLoginWithWrongPassword() {
		Professional professional = professionalService.userLogin(PERSON_EMAIL,
				WRONG_PASSWORD);
		Assert.assertNull(professional);
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
