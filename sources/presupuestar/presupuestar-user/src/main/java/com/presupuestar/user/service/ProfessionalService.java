package com.presupuestar.user.service;

import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Professional;
import com.presupuestar.user.exception.InvalidEmailFormatException;

public interface ProfessionalService {

	Professional registerNewCompanyAccount(String email, String password,
			String reason, Profession profession)
			throws InvalidEmailFormatException;

	Professional registerNewProfessionalAccount(String email, String password,
			String firstName, String lastName, Profession profession)
			throws InvalidEmailFormatException;

	Professional userLogin(String email, String password);

}
