package com.presupuestar.db.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.budget.ProductsBudget;
import com.presupuestar.model.feedback.Feedback;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.profile.Address;
import com.presupuestar.model.user.profile.Phone;
import com.presupuestar.model.user.store.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:presupuestar-db.xml" })
@Transactional
public class CommerceDAOTest {

	@Test
	public void getAllCommerces() {
		CommerceDAO commerceDAO = (CommerceDAO) DAOLocator.getInstance()
				.getDao(CommerceDAO.class);
		List<Commerce> commerces = commerceDAO.getAll();
		Assert.assertNotNull(commerces);
		for (Commerce commerce : commerces) {
			Assert.assertNotNull(commerce);
			Assert.assertNotNull(commerce.getProfile());
			for (Address address : commerce.getProfile().getAddresses()) {
				Assert.assertNotNull(address);
			}
			for (Phone phone : commerce.getProfile().getPhones()) {
				Assert.assertNotNull(phone);
			}
			Assert.assertNotNull(commerce.getAccess());
			Assert.assertNotNull(commerce.getStore());
			for (Product product : commerce.getStore().getProducts()) {
				Assert.assertNotNull(product);
			}
			Assert.assertNotNull(commerce.getBudgets());
			for (ProductsBudget budget : commerce.getBudgets()) {
				Assert.assertNotNull(budget);
			}
			Assert.assertNotNull(commerce.getFeedbacks());
			for (Feedback feedback : commerce.getFeedbacks()) {
				Assert.assertNotNull(feedback);
			}
		}
	}

}
