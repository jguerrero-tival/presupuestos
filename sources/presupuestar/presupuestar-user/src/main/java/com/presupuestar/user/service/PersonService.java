package com.presupuestar.user.service;

import com.presupuestar.model.user.Person;
import com.presupuestar.user.exception.InvalidEmailFormatException;

public interface PersonService {

	Person registerNewPersonAccount(String email, String password,
			String firstName, String lastName)
			throws InvalidEmailFormatException;

	Person userLogin(String email, String password);

}
