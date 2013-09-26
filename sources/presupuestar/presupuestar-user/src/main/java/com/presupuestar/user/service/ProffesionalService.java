package com.presupuestar.user.service;

import com.presupuestar.model.proffesion.Proffesion;
import com.presupuestar.model.user.Proffesional;
import com.presupuestar.model.user.ProffesionalType;

public interface ProffesionalService {

	Proffesional registerNewProffesionalAccount(String email, String password,
			String firstName, String lastName, ProffesionalType type,
			Proffesion proffesion);

}
