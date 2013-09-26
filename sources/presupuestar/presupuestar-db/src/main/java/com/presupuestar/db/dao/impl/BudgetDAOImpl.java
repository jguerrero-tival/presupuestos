package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.BudgetDAO;
import com.presupuestar.model.budget.Budget;

public class BudgetDAOImpl extends AbstractHibernateDAO<Budget> implements BudgetDAO {

	public BudgetDAOImpl() {
		super(Budget.class);
	}

}
