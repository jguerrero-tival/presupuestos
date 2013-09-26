package com.presupuestar.model.user.profile;

import com.presupuestar.model.DomainObject;

public class Phone extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private String phoneNumber;

	public Phone() {
		super();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
