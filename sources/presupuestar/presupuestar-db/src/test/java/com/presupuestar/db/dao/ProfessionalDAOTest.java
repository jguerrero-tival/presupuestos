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
import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Professional;
import com.presupuestar.model.user.profile.Address;
import com.presupuestar.model.user.profile.Phone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-presupuestar-db.xml" })
@Transactional
public class ProfessionalDAOTest {

	private static final String EMAIL = "professional@presupuestar.com",
			PASSWORD = "password";
	private static final String WRONG_EMAIL = "wrong@presupuestar.com";

	@Test
	public void getAllProfessionals() {
		ProfessionalDAO professionalDao = (ProfessionalDAO) DAOLocator
				.getInstance().getDao(ProfessionalDAO.class);
		List<Professional> professionals = professionalDao.getAll();
		Assert.assertNotNull(professionals);
		for (Professional professional : professionals) {
			Assert.assertNotNull(professional);
			Assert.assertNotNull(professional.getProfile());
			for (Address address : professional.getProfile().getAddresses()) {
				Assert.assertNotNull(address);
			}
			for (Phone phone : professional.getProfile().getPhones()) {
				Assert.assertNotNull(phone);
			}
			Assert.assertNotNull(professional.getAccess());
			Assert.assertNotNull(professional.getType());
			Assert.assertNotNull(professional.getProfession());
			Assert.assertNotNull(professional.getProfession().getCategory());
			for (Profession profession : professional.getProfession()
					.getCategory().getProfessions()) {
				Assert.assertNotNull(profession);
			}
			Assert.assertNotNull(professional.getBudgets());
			for (LaborBudget budget : professional.getBudgets()) {
				Assert.assertNotNull(budget);
			}
			Assert.assertNotNull(professional.getFeedbacks());
			for (Feedback feedback : professional.getFeedbacks()) {
				Assert.assertNotNull(feedback);
			}
		}
	}

	@Test
	public void getPersonByLoginAccess() {
		ProfessionalDAO professionalDao = (ProfessionalDAO) DAOLocator
				.getInstance().getDao(ProfessionalDAO.class);
		Professional professional = professionalDao.getByLoginAccess(EMAIL,
				PASSWORD);
		Assert.assertNotNull(professional);
		Assert.assertNotNull(professional.getAccess());
		Assert.assertEquals(professional.getAccess().getEmail(), EMAIL);
		Assert.assertEquals(professional.getAccess().getPassword(), PASSWORD);
	}

	@Test
	public void getPersonByWrongLoginAccess() {
		ProfessionalDAO professionalDao = (ProfessionalDAO) DAOLocator
				.getInstance().getDao(ProfessionalDAO.class);
		Professional professional = professionalDao.getByLoginAccess(
				WRONG_EMAIL, PASSWORD);
		Assert.assertNull(professional);
	}

}
