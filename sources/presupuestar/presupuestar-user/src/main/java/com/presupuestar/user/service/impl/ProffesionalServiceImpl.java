package com.presupuestar.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.ProffesionalDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.proffesion.Proffesion;
import com.presupuestar.model.user.Proffesional;
import com.presupuestar.model.user.ProffesionalType;
import com.presupuestar.user.builder.UserBuilder;
import com.presupuestar.user.exception.InvalidEmailFormatException;
import com.presupuestar.user.service.ProffesionalService;
import com.presupuestar.user.validator.EmailFormatValidator;

@Service
public class ProffesionalServiceImpl implements ProffesionalService {

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
	public Proffesional registerNewCompanyAccount(String email,
			String password, String reason, Proffesion proffesion)
			throws InvalidEmailFormatException {
		if (!emailFormatValidator.validate(email)) {
			throw new InvalidEmailFormatException(email);
		}
		UserBuilder builder = UserBuilder.forProffesional();
		builder.buildUserAccess(email, password);
		builder.buildReason(reason);
		builder.buildProffesionalType(ProffesionalType.COMPANY);
		builder.buildProffesion(proffesion);
		Proffesional proffesional = builder.getProffesional();
		ProffesionalDAO proffesionalDao = (ProffesionalDAO) DAOLocator
				.getInstance().getDao(ProffesionalDAO.class);
		proffesionalDao.create(proffesional);
		return proffesional;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Proffesional registerNewProffesionalAccount(String email,
			String password, String firstName, String lastName,
			Proffesion proffesion) throws InvalidEmailFormatException {
		if (!emailFormatValidator.validate(email)) {
			throw new InvalidEmailFormatException(email);
		}
		UserBuilder builder = UserBuilder.forProffesional();
		builder.buildUserAccess(email, password);
		builder.buildName(firstName, lastName);
		builder.buildProffesionalType(ProffesionalType.SELF_EMPLOYED);
		builder.buildProffesion(proffesion);
		Proffesional proffesional = builder.getProffesional();
		ProffesionalDAO proffesionalDao = (ProffesionalDAO) DAOLocator
				.getInstance().getDao(ProffesionalDAO.class);
		proffesionalDao.create(proffesional);
		return proffesional;
	}

	@Override
	@Transactional(readOnly = true)
	public Proffesional userLogin(String email, String password) {
		ProffesionalDAO proffesionalDao = (ProffesionalDAO) DAOLocator
				.getInstance().getDao(ProffesionalDAO.class);
		return proffesionalDao.getByLoginAccess(email, password);
	}

}
