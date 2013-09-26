package com.presupuestar.db.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.user.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:presupuestar-db.xml" })
@Transactional
public class PersonDAOTest {

	@Test
	public void getAllPersons() {
		PersonDAO personDao = (PersonDAO) DAOLocator.getInstance().getDao(
				PersonDAO.class);
		List<Person> persons = personDao.getAll();
		Assert.assertNotNull(persons);
		for (Person person : persons) {
			Assert.assertNotNull(person);
			Assert.assertNotNull(person.getProfile());
			Assert.assertNotNull(person.getAccess());
		}
	}

}
