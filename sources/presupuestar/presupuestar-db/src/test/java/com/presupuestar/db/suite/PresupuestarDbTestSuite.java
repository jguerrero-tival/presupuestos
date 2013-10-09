package com.presupuestar.db.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.presupuestar.db.dao.BudgetDAOTest;
import com.presupuestar.db.dao.CategoryDAOTest;
import com.presupuestar.db.dao.CommerceDAOTest;
import com.presupuestar.db.dao.FeedbackDAOTest;
import com.presupuestar.db.dao.PersonDAOTest;
import com.presupuestar.db.dao.ProfessionDAOTest;
import com.presupuestar.db.dao.ProfessionalDAOTest;
import com.presupuestar.db.dao.locator.DAOLocatorTest;

@RunWith(Suite.class)
@SuiteClasses(value = { 
		BudgetDAOTest.class, 
		CategoryDAOTest.class,
		CommerceDAOTest.class,
		FeedbackDAOTest.class, 
		PersonDAOTest.class, 
		ProfessionalDAOTest.class,
		ProfessionDAOTest.class, 
		DAOLocatorTest.class 
		})
public class PresupuestarDbTestSuite {

}
