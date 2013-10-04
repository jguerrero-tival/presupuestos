package com.presupuestar.user.service.fixture;

import org.springframework.beans.factory.annotation.Autowired;

import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.Person;
import com.presupuestar.model.user.Professional;
import com.presupuestar.user.service.CommerceService;
import com.presupuestar.user.service.PersonService;
import com.presupuestar.user.service.ProfessionalService;

public class UserLoginFixture {

	private String email;
	private String password;

	@Autowired
	private CommerceService commerceService;
	@Autowired
	private ProfessionalService professionalService;
	@Autowired
	private PersonService personService;

	public UserLoginFixture() {
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

	public boolean isCommerce() {
		Commerce commerce = new Commerce();
		// Commerce commerce = commerceService.userLogin(email, password);
		return commerce == null;
	}

	public boolean isPerson() {
		Person person = new Person();
		// Person person = personService.userLogin(email, password);
		return person == null;
	}

	public boolean isProfessional() {
		Professional professional = new Professional();
		// Professional professional = professionalService.userLogin(email, password);
		return professional == null;
	}

}
