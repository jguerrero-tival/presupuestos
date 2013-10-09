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
import com.presupuestar.model.budget.ProductsBudget;
import com.presupuestar.model.feedback.Feedback;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.profile.Address;
import com.presupuestar.model.user.profile.Phone;
import com.presupuestar.model.user.store.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-presupuestar-db.xml" })
@Transactional
public class CommerceDAOTest {

	private static final String EMAIL = "commerce@presupuestar.com",
			PASSWORD = "password";
	private static final String WRONG_EMAIL = "wrong@presupuestar.com";

	private CommerceDAO commerceDAO;

	@Before
	public void setUp() {
		commerceDAO = (CommerceDAO) DAOLocator.getInstance().getDao(
				CommerceDAO.class);
	}

	@Test
	public void getAllCommerces() {
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

	@Test
	public void getPersonByLoginAccess() {
		Commerce commerce = commerceDAO.getByLoginAccess(EMAIL, PASSWORD);
		Assert.assertNotNull(commerce);
		Assert.assertNotNull(commerce.getAccess());
		Assert.assertEquals(commerce.getAccess().getEmail(), EMAIL);
		Assert.assertEquals(commerce.getAccess().getPassword(), PASSWORD);
	}

	@Test
	public void getPersonByWrongLoginAccess() {
		Commerce commerce = commerceDAO.getByLoginAccess(WRONG_EMAIL, PASSWORD);
		Assert.assertNull(commerce);
	}

}
