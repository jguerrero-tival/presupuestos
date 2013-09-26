package com.presupuestar.model.user.profile;

import com.presupuestar.model.DomainObject;

public class Profile extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;

	public Profile() {
		super();
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

}
