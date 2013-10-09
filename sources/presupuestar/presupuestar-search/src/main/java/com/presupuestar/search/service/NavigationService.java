package com.presupuestar.search.service;

import java.util.List;

import com.presupuestar.model.profession.Category;
import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Professional;

public interface NavigationService {

	List<Category> searchCategories();

	List<Profession> searchProfessions(Category category);

	List<Professional> searchProfessionals(Category category);
	
	List<Professional> searchProfessionals(Profession profession);
	
}
