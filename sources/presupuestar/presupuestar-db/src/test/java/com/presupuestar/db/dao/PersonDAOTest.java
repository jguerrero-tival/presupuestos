package com.presupuestar.db.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.user.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-presupuestar-db.xml" })
@Transactional
public class PersonDAOTest {

	private PersonDAO personDao;

	@Before
	public void setUp() {
		personDao = (PersonDAO) DAOLocator.getInstance()
				.getDao(PersonDAO.class);
	}

	private static final String EMAIL = "person@presupuestar.com",
			PASSWORD = "password";
	private static final String WRONG_EMAIL = "wrong@presupuestar.com";

	@Test
	public void getAllPersons() {
		List<Person> persons = personDao.getAll();
		Assert.assertNotNull(persons);
		for (Person person : persons) {
			Assert.assertNotNull(person);
			Assert.assertNotNull(person.getProfile());
			Assert.assertNotNull(person.getAccess());
		}
	}

	@Test
	public void getPersonByLoginAccess() {
		Person person = personDao.getByLoginAccess(EMAIL, PASSWORD);
		Assert.assertNotNull(person);
		Assert.assertNotNull(person.getAccess());
		Assert.assertEquals(person.getAccess().getEmail(), EMAIL);
		Assert.assertEquals(person.getAccess().getPassword(), PASSWORD);
	}

	@Test
	public void getPersonByWrongLoginAccess() {
		Person person = personDao.getByLoginAccess(WRONG_EMAIL, PASSWORD);
		Assert.assertNull(person);
	}

}
