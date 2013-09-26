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
import com.presupuestar.db.dao.ProffesionDAO;
import com.presupuestar.db.dao.ProffesionalDAO;
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
		Assert.notNull(DAOLocator.getInstance().getDao(ProffesionalDAO.class));
		Assert.isInstanceOf(ProffesionalDAO.class, DAOLocator.getInstance()
				.getDao(ProffesionalDAO.class));
		Assert.notNull(DAOLocator.getInstance().getDao(ProffesionDAO.class));
		Assert.isInstanceOf(ProffesionDAO.class, DAOLocator.getInstance()
				.getDao(ProffesionDAO.class));
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
