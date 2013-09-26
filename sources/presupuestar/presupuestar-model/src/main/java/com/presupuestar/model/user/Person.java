package com.presupuestar.model.user;

import com.presupuestar.model.user.profile.BasicProfile;

public class Person extends User {

	private static final long serialVersionUID = 1L;
	
	private BasicProfile profile;

	public Person() {
		super();
	}

	public Person(UserAccess access) {
		super(access);
	}

	public BasicProfile getProfile() {
		return profile;
	}

	public void setProfile(BasicProfile profile) {
		this.profile = profile;
	}

}
