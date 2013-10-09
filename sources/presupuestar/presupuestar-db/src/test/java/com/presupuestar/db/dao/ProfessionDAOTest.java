package com.presupuestar.db.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.profession.Category;
import com.presupuestar.model.profession.Profession;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-presupuestar-db.xml" })
@Transactional
public class ProfessionDAOTest {

	private static final String PROFESSION = "Arquitecto de Software";
	private static final String WRONG_PROFESSION = "Vago";

	@Test
	public void getAllProfessions() {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		List<Profession> professions = professionDao.getAll();
		Assert.assertNotNull(professions);
		for (Profession profession : professions) {
			Assert.assertNotNull(profession);
			Assert.assertNotNull(profession.getCategory());
			for (Profession innerProfession : profession.getCategory()
					.getProfessions()) {
				Assert.assertNotNull(innerProfession);
			}
		}
	}

	@Test
	public void getProfessionByName() {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		Profession profession = professionDao.getByName(PROFESSION);
		Assert.assertNotNull(profession);
		Assert.assertEquals(PROFESSION, profession.getName());
	}

	@Test
	public void getProfessionByWrongName() {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		Profession profession = professionDao.getByName(WRONG_PROFESSION);
		Assert.assertNull(profession);
	}

	@Test
	public void getProfessionByCategory() {
		CategoryDAO categoryDao = (CategoryDAO) DAOLocator.getInstance()
				.getDao(CategoryDAO.class);
		Category category = categoryDao.getById(Long.valueOf(1));
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		List<Profession> professions = professionDao.getByCategory(category);
		Assert.assertNotNull(professions);
		for (Profession profession : professions) {
			Assert.assertNotNull(profession);
		}
	}

	@Test
	public void getProfessionByWrongCategory() {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		List<Profession> professions = professionDao
				.getByCategory(new Category());
		Assert.assertNotNull(professions);
		Assert.assertEquals(0, professions.size());
	}

	@Test(expected = NullPointerException.class)
	public void getProfessionByNullCategory() {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		professionDao.getByCategory(null);
	}

}
