package com.presupuestar.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.CommerceDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.user.builder.UserBuilder;
import com.presupuestar.user.exception.InvalidEmailFormatException;
import com.presupuestar.user.service.CommerceService;
import com.presupuestar.user.validator.EmailFormatValidator;

@Service
public class CommerceServiceImpl implements CommerceService {

	private EmailFormatValidator emailFormatValidator;

	public EmailFormatValidator getEmailFormatValidator() {
		return emailFormatValidator;
	}

	public void setEmailFormatValidator(
			EmailFormatValidator emailFormatValidator) {
		this.emailFormatValidator = emailFormatValidator;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Commerce registerNewCommerceAccount(String email, String password,
			String reason) throws InvalidEmailFormatException {
		if (!emailFormatValidator.validate(email)) {
			throw new InvalidEmailFormatException(email);
		}
		UserBuilder builder = UserBuilder.forCommerce();
		builder.buildUserAccess(email, password);
		builder.buildReason(reason);
		Commerce commerce = builder.getCommerce();
		CommerceDAO commerceDao = (CommerceDAO) DAOLocator.getInstance()
				.getDao(CommerceDAO.class);
		commerceDao.create(commerce);
		return commerce;
	}

	@Override
	@Transactional(readOnly = true)
	public Commerce userLogin(String email, String password) {
		CommerceDAO commerceDAO = (CommerceDAO) DAOLocator.getInstance()
				.getDao(CommerceDAO.class);
		return commerceDAO.getByLoginAccess(email, password);
	}

}
