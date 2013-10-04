package com.presupuestar.user.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.presupuestar.user.exception.InvalidEmailFormatException;

public class EmailFormatValidator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;

	public EmailFormatValidator() {
		super();
		this.pattern = Pattern.compile(EMAIL_PATTERN);
	}

	public boolean validate(final String email) throws InvalidEmailFormatException {
		this.matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
