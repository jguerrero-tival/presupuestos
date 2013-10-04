package com.presupuestar.db.dao.locator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.presupuestar.db.dao.BudgetDAO;
import com.presupuestar.db.dao.CommerceDAO;
import com.presupuestar.db.dao.FeedbackDAO;
import com.presupuestar.db.dao.HibernateDAO;
import com.presupuestar.db.dao.PersonDAO;
import com.presupuestar.db.dao.ProfessionDAO;
import com.presupuestar.db.dao.ProfessionalDAO;
import com.presupuestar.db.dao.exception.LookupDAOException;
import com.presupuestar.model.DomainObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:presupuestar-db.xml" })
public class DAOLocatorTest {

	@Test
	public void getAllDaos() {
		Assert.notNull(DAOLocator.getInstance().getDao(BudgetDAO.class));
		Assert.isInstanceOf(BudgetDAO.class,
				DAOLocator.getInstance().getDao(BudgetDAO.class));
		Assert.notNull(DAOLocator.getInstance().getDao(CommerceDAO.class));
		Assert.isInstanceOf(CommerceDAO.class,
				DAOLocator.getInstance().getDao(CommerceDAO.class));
		Assert.notNull(DAOLocator.getInstance().getDao(FeedbackDAO.class));
		Assert.isInstanceOf(FeedbackDAO.class,
				DAOLocator.getInstance().getDao(FeedbackDAO.class));
		Assert.notNull(DAOLocator.getInstance().getDao(ProfessionalDAO.class));
		Assert.isInstanceOf(ProfessionalDAO.class, DAOLocator.getInstance()
				.getDao(ProfessionalDAO.class));
		Assert.notNull(DAOLocator.getInstance().getDao(ProfessionDAO.class));
		Assert.isInstanceOf(ProfessionDAO.class, DAOLocator.getInstance()
				.getDao(ProfessionDAO.class));
		Assert.notNull(DAOLocator.getInstance().getDao(PersonDAO.class));
		Assert.isInstanceOf(PersonDAO.class,
				DAOLocator.getInstance().getDao(PersonDAO.class));
	}

	@Test(expected = LookupDAOException.class)
	public void getGetDaoNullClass() {
		DAOLocator.getInstance().getDao(null);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = LookupDAOException.class)
	public void getGetDaoInvalidDaoClass() {
		DAOLocator
				.getInstance()
				.getDao((Class<? extends HibernateDAO<? extends DomainObject>>) DomainObject.class);
	}

}
