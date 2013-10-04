package com.presupuestar.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.ProfessionalDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Professional;
import com.presupuestar.model.user.ProfessionalType;
import com.presupuestar.user.builder.UserBuilder;
import com.presupuestar.user.exception.InvalidEmailFormatException;
import com.presupuestar.user.service.ProfessionalService;
import com.presupuestar.user.validator.EmailFormatValidator;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

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
	public Professional registerNewCompanyAccount(String email,
			String password, String reason, Profession profession)
			throws InvalidEmailFormatException {
		if (!emailFormatValidator.validate(email)) {
			throw new InvalidEmailFormatException(email);
		}
		UserBuilder builder = UserBuilder.forProfessional();
		builder.buildUserAccess(email, password);
		builder.buildReason(reason);
		builder.buildProfessionalType(ProfessionalType.COMPANY);
		builder.buildProfession(profession);
		Professional professional = builder.getProfessional();
		ProfessionalDAO professionalDao = (ProfessionalDAO) DAOLocator
				.getInstance().getDao(ProfessionalDAO.class);
		professionalDao.create(professional);
		return professional;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Professional registerNewProfessionalAccount(String email,
			String password, String firstName, String lastName,
			Profession profession) throws InvalidEmailFormatException {
		if (!emailFormatValidator.validate(email)) {
			throw new InvalidEmailFormatException(email);
		}
		UserBuilder builder = UserBuilder.forProfessional();
		builder.buildUserAccess(email, password);
		builder.buildName(firstName, lastName);
		builder.buildProfessionalType(ProfessionalType.SELF_EMPLOYED);
		builder.buildProfession(profession);
		Professional professional = builder.getProfessional();
		ProfessionalDAO professionalDao = (ProfessionalDAO) DAOLocator
				.getInstance().getDao(ProfessionalDAO.class);
		professionalDao.create(professional);
		return professional;
	}

	@Override
	@Transactional(readOnly = true)
	public Professional userLogin(String email, String password) {
		ProfessionalDAO professionalDao = (ProfessionalDAO) DAOLocator
				.getInstance().getDao(ProfessionalDAO.class);
		return professionalDao.getByLoginAccess(email, password);
	}

}
