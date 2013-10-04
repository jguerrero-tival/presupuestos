package com.presupuestar.user.service.fixture;

import org.springframework.beans.factory.annotation.Autowired;

import com.presupuestar.model.user.Person;
import com.presupuestar.user.exception.InvalidEmailFormatException;
import com.presupuestar.user.service.PersonService;

public class RegisterPersonAccountFixture {

	private String email;
	private String password;
	private String firstName;
	private String lastName;

	@Autowired
	private PersonService personService;

	public RegisterPersonAccountFixture() {
		super();
		new PresupuestarUserFixtureWirer().wire(this);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isPersonRegistered() throws InvalidEmailFormatException {
		Person person = personService.registerNewPersonAccount(email, password,
				firstName, lastName);
		return person == null;
	}

}
