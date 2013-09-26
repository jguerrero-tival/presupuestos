package com.presupuestar.db.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.budget.LaborBudget;
import com.presupuestar.model.feedback.Feedback;
import com.presupuestar.model.proffesion.Proffesion;
import com.presupuestar.model.user.Proffesional;
import com.presupuestar.model.user.profile.Address;
import com.presupuestar.model.user.profile.Phone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:presupuestar-db.xml" })
@Transactional
public class ProffesionalDAOTest {

	@Test
	public void getAllProffesionals() {
		ProffesionalDAO proffesionalDao = (ProffesionalDAO) DAOLocator
				.getInstance().getDao(ProffesionalDAO.class);
		List<Proffesional> proffesionals = proffesionalDao.getAll();
		Assert.assertNotNull(proffesionals);
		for (Proffesional proffesional : proffesionals) {
			Assert.assertNotNull(proffesional);
			Assert.assertNotNull(proffesional.getProfile());
			for (Address address : proffesional.getProfile().getAddresses()) {
				Assert.assertNotNull(address);
			}
			for (Phone phone : proffesional.getProfile().getPhones()) {
				Assert.assertNotNull(phone);
			}
			Assert.assertNotNull(proffesional.getAccess());
			Assert.assertNotNull(proffesional.getType());
			Assert.assertNotNull(proffesional.getProffesion());
			Assert.assertNotNull(proffesional.getProffesion().getCategory());
			for (Proffesion proffesion : proffesional.getProffesion()
					.getCategory().getProffesions()) {
				Assert.assertNotNull(proffesion);
			}
			Assert.assertNotNull(proffesional.getBudgets());
			for (LaborBudget budget : proffesional.getBudgets()) {
				Assert.assertNotNull(budget);
			}
			Assert.assertNotNull(proffesional.getFeedbacks());
			for (Feedback feedback : proffesional.getFeedbacks()) {
				Assert.assertNotNull(feedback);
			}
		}
	}

}
