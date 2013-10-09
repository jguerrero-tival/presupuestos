package com.presupuestar.search.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.CategoryDAO;
import com.presupuestar.db.dao.ProfessionDAO;
import com.presupuestar.db.dao.ProfessionalDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.profession.Category;
import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Professional;
import com.presupuestar.search.service.NavigationService;

@Service
public class NavigationServiceImpl implements NavigationService {

	@Override
	@Transactional(readOnly = true)
	public List<Category> searchCategories() {
		CategoryDAO categoryDao = (CategoryDAO) DAOLocator.getInstance()
				.getDao(CategoryDAO.class);
		return categoryDao.getAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Profession> searchProfessions(Category category) {
		ProfessionDAO professionDao = (ProfessionDAO) DAOLocator.getInstance()
				.getDao(ProfessionDAO.class);
		return professionDao.getByCategory(category);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Professional> searchProfessionals(Category category) {
		ProfessionalDAO professionalDao = (ProfessionalDAO) DAOLocator.getInstance()
				.getDao(ProfessionalDAO.class);
		return professionalDao.getByCategory(category);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Professional> searchProfessionals(Profession profession) {
		ProfessionalDAO professionalDao = (ProfessionalDAO) DAOLocator.getInstance()
				.getDao(ProfessionalDAO.class);
		return professionalDao.getByProfession(profession);
	}

}
