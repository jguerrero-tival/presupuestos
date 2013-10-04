package com.presupuestar.user.service.fixture;

import org.springframework.beans.factory.annotation.Autowired;

import com.presupuestar.db.dao.ProfessionDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Professional;
import com.presupuestar.user.exception.InvalidEmailFormatException;
import com.presupuestar.user.service.CommerceService;
import com.presupuestar.user.service.PersonService;
import com.presupuestar.user.service.ProfessionalService;

public class RegisterProfessionalAccountFixture {

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String reason;
	private String profession;

	@Autowired
	private CommerceService commerceService;
	@Autowired
	private ProfessionalService professionalService;
	@Autowired
	private PersonService personService;

	public RegisterProfessionalAccountFixture() {
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public boolean isCompanyRegistered() throws InvalidEmailFormatException {
		Professional company = professionalService.registerNewCompanyAccount(
				email, password, reason, loadProfession());
		return company == null;
	}

	public boolean isProfessionalRegistered()
			throws InvalidEmailFormatException {
		Professional professional = professionalService
				.registerNewProfessionalAccount(email, password, firstName,
						lastName, loadProfession());
		return professional == null;
	}

	private Profession loadProfession() {
		Profession prof = ((ProfessionDAO) DAOLocator.getInstance().getDao(
				ProfessionDAO.class)).getByName(profession);
		return prof;
	}

}
