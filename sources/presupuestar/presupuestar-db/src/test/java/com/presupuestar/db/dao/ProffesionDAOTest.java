package com.presupuestar.db.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.proffesion.Proffesion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:presupuestar-db.xml" })
@Transactional
public class ProffesionDAOTest {

	@Test
	public void getAllProffesionals() {
		ProffesionDAO proffesionDao = (ProffesionDAO) DAOLocator.getInstance()
				.getDao(ProffesionDAO.class);
		List<Proffesion> proffesions = proffesionDao.getAll();
		Assert.assertNotNull(proffesions);
		for (Proffesion proffesion : proffesions) {
			Assert.assertNotNull(proffesion);
			Assert.assertNotNull(proffesion.getCategory());
			for (Proffesion innerProffesion : proffesion.getCategory()
					.getProffesions()) {
				Assert.assertNotNull(innerProffesion);
			}
		}
	}

}
