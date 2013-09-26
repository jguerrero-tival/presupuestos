package com.presupuestar.model.user;

import com.presupuestar.model.DomainObject;
import com.presupuestar.model.user.profile.Profile;

public abstract class User extends DomainObject {

	private static final long serialVersionUID = 1L;

	private UserAccess access;

	public User() {
		super();
	}

	public User(UserAccess access) {
		super();
		this.access = access;
	}

	public UserAccess getAccess() {
		return access;
	}

	public void setAccess(UserAccess access) {
		this.access = access;
	}

	public abstract Profile getProfile();

}
