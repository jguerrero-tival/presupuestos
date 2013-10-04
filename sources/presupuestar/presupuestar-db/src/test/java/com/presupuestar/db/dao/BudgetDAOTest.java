package com.presupuestar.db.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.budget.Budget;
import com.presupuestar.model.budget.Item;
import com.presupuestar.model.budget.ItemBudget;
import com.presupuestar.model.feedback.Feedback;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-presupuestar-db.xml" })
@Transactional
public class BudgetDAOTest {

	@Test
	public void getAllBudgets() {
		BudgetDAO budgetDAO = (BudgetDAO) DAOLocator.getInstance().getDao(
				BudgetDAO.class);
		List<Budget> budgets = budgetDAO.getAll();
		Assert.assertNotNull(budgets);
		for (Budget budget : budgets) {
			Assert.assertNotNull(budget);
			Assert.assertNotNull(budget.getLaborBudget());
			Assert.assertNotNull(budget.getLaborBudget().getLaborDetail());
			Assert.assertNotNull(budget.getLaborBudget().getProductsDetail());
			for (Item item : budget.getLaborBudget().getProductsDetail()
					.getItems()) {
				Assert.assertNotNull(item);
			}
			Assert.assertNotNull(budget.getLaborBudget().getProfessional());
			Assert.assertNotNull(budget.getProductBudget());
			for (ItemBudget itemBudget : budget.getProductBudget()
					.getItemsBudget()) {
				Assert.assertNotNull(itemBudget);
				Assert.assertNotNull(itemBudget.getItem());
			}
			Assert.assertNotNull(budget.getProductBudget().getCommerce());
			Assert.assertNotNull(budget.getFeedbacks());
			for (Feedback feedback : budget.getFeedbacks()) {
				Assert.assertNotNull(feedback);
			}
		}
	}

}
