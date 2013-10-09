package com.presupuestar.search.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.CategoryDAO;
import com.presupuestar.db.dao.ProfessionDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.profession.Category;
import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Professional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-presupuestar-search.xml" })
@Transactional
public class NavigateProfessionsTest {

	@Autowired
	private NavigationService navigationService;

	@Test
	public void navigateCategories() {
		List<Category> categories = navigationService.searchCategories();
		for (Category category : categories) {
			Assert.assertNotNull(category);
		}
	}

	@Test
	public void navigateProfessionsByCategory() {
		CategoryDAO categoryDao = (CategoryDAO) DAOLocator.getInstance()
				.getDao(CategoryDAO.class);
		Category category = categoryDao.getById(Long.valueOf(1));
		List<Profession> professions = navigationService
				.searchProfessions(category);
		for (Profession profession : professions) {
			Assert.assertNotNull(profession);
		}
	}

	@Test(expected = Exception.class)
	public void navigateProfessionsByWrongCategory() {
		navigationService.searchProfessions(new Category());
	}

	@Test(expected = Exception.class)
	public void navigateProfessionsByNullCategory() {
		Category category = null;
		navigationService.searchProfessions(category);
	}

	@Test
	public void navigateProfessionalsByCategory() {
		CategoryDAO categoryDao = (CategoryDAO) DAOLocator.getInstance()
				.getDao(CategoryDAO.class);
		Category category = categoryDao.getById(Long.valueOf(1));
		List<Professional> professionals = navigationService
				.searchProfessionals(category);
		for (Professional professional : professionals) {
			Assert.assertNotNull(professional);
		}
	}

	@Test(expected = Exception.class)
	public void navigateProfessionalsByWrongCategory() {
		navigationService.searchProfessionals(new Category());
	}

	@Test(expected = Exception.class)
	public void navigateProfessionalsByNullCategory() {
		Category category = null;
		navigationService.searchProfessionals(category);
	}

	@Test
	public void navigateProfessionalsByProfession() {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		Profession profession = professionDao.getById(Long.valueOf(1));
		List<Professional> professionals = navigationService
				.searchProfessionals(profession);
		for (Professional professional : professionals) {
			Assert.assertNotNull(professional);
		}
	}

	@Test(expected = Exception.class)
	public void navigateProfessionalsByWrongProfession() {
		navigationService.searchProfessionals(new Profession());
	}

	@Test(expected = Exception.class)
	public void navigateProfessionalsByNullProfession() {
		Profession profession = null;
		navigationService.searchProfessionals(profession);
	}
	
}
