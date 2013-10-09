package com.presupuestar.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.presupuestar.db.dao.BudgetDAO;
import com.presupuestar.model.budget.Budget;

@Repository
public class BudgetDAOImpl extends AbstractHibernateDAO<Budget> implements BudgetDAO {

	public BudgetDAOImpl() {
		super(Budget.class);
	}

}
