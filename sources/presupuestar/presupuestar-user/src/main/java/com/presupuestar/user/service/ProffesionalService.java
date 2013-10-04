package com.presupuestar.user.service;

import com.presupuestar.model.proffesion.Proffesion;
import com.presupuestar.model.user.Proffesional;
import com.presupuestar.user.exception.InvalidEmailFormatException;

public interface ProffesionalService {

	Proffesional registerNewCompanyAccount(String email, String password,
			String reason, Proffesion proffesion)
			throws InvalidEmailFormatException;

	Proffesional registerNewProffesionalAccount(String email, String password,
			String firstName, String lastName, Proffesion proffesion)
			throws InvalidEmailFormatException;

	Proffesional userLogin(String email, String password);

}
