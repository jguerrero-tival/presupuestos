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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-presupuestar-db.xml" })
@Transactional
public class CategoryDAOTest {

	@Test
	public void getAllCommerces() {
		CategoryDAO categoryDAO = (CategoryDAO) DAOLocator.getInstance()
				.getDao(CategoryDAO.class);
		List<Category> categories = categoryDAO.getAll();
		Assert.assertNotNull(categories);
		for (Category category : categories) {
			Assert.assertNotNull(category);
		}
	}

}
