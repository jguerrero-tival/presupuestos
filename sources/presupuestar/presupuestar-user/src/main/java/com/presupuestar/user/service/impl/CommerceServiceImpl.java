package com.presupuestar.user.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.CommerceDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.user.builder.UserBuilder;
import com.presupuestar.user.service.CommerceService;

@Transactional
public class CommerceServiceImpl implements CommerceService {

	@Override
	public Commerce registerNewCommerceAccount(String email, String password,
			String reason) {
		UserBuilder builder = UserBuilder.forCommerce();
		builder.buildUserAccess(email, password);
		builder.buildReason(reason);
		Commerce commerce = builder.getCommerce();
		CommerceDAO commerceDao = (CommerceDAO) DAOLocator.getInstance()
				.getDao(CommerceDAO.class);
		commerceDao.create(commerce);
		return commerce;
	}

}
