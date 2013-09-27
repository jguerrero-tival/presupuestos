package com.presupuestar.user.service;

import com.presupuestar.model.proffesion.Proffesion;
import com.presupuestar.model.user.Proffesional;

public interface ProffesionalService {

	Proffesional registerNewCompanyAccount(String email, String password,
			String reason, Proffesion proffesion);

	Proffesional registerNewProffesionalAccount(String email, String password,
			String firstName, String lastName, Proffesion proffesion);

}
