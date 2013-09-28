package com.presupuestar.user.service;

import com.presupuestar.model.user.Person;

public interface PersonService {

	Person registerNewPersonAccount(String email, String password,
			String firstName, String lastName);

	Person userLogin(String email, String password);

}
