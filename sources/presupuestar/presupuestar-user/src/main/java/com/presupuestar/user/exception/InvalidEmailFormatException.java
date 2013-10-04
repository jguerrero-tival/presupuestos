package com.presupuestar.user.exception;

public class InvalidEmailFormatException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String email;

	public InvalidEmailFormatException(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
