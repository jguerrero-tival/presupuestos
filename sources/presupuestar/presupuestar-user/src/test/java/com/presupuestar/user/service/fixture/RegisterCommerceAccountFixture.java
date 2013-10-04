package com.presupuestar.user.service.fixture;

import org.springframework.beans.factory.annotation.Autowired;

import com.presupuestar.model.user.Commerce;
import com.presupuestar.user.exception.InvalidEmailFormatException;
import com.presupuestar.user.service.CommerceService;

public class RegisterCommerceAccountFixture {

	private String email;
	private String password;
	private String reason;

	@Autowired
	private CommerceService commerceService;

	public RegisterCommerceAccountFixture() {
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isCommerceRegistered() throws InvalidEmailFormatException {
		Commerce commerce = commerceService.registerNewCommerceAccount(email,
				password, reason);
		return commerce == null;
	}
}
