package com.presupuestar.user.validator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.presupuestar.user.exception.InvalidEmailFormatException;

@RunWith(Parameterized.class)
public class EmailFormatValidatorTest {

	private static EmailFormatValidator emailFormatValidator = new EmailFormatValidator();
	private String email;
	private Boolean expectedValidation;

	public EmailFormatValidatorTest(String email, Boolean expectedValidation) {
		this.email = email;
		this.expectedValidation = expectedValidation;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				// Invalid email addresses
				{ "slavie@gmail.com.2j", false },
				{ "slavie@slavie@gmail.com", false },
				{ "slavie!!!@gmail.com", false },
				{ "slavie()*@gmail.com", false },
				{ "slavie@%*.com", false },
				{ "slavie123@.com", false },
				{ "slavie", false },
				{ "slavie.com", false },
				{ ".slavie@slavie.com", false },
				{ "slavie..2002@gmail.com", false },
				{ "slavie@.com.my", false },
				{ "slavie123@.com.com", false },
				{ "slavie123@gmail.a", false },
				{ "slavie.@gmail.com", false },
				{ "slavie@gmail.com.1a", false },
				// Valid email addresses
				{ "slavie@gmail.com", true },
				{ "nikos+mylist@gmail.com", true },
				{ "abc.efg-900@gmail-list.com", true },
				{ "abc123@example.com.gr", true },
				{ "slavie@yahoo.com", true },
				{ "slavie.100@yahoo.com", true },
				{ "slavie-100@yahoo.com", true },
				{ "slavie-100@slavie.net", true },
				{ "slavie111@slavie.com", true },
				{ "slavie.100@slavie.com.au", true },
				{ "slavie@1.com", true },
				{ "slavie@gmail.com.com", true },
				{ "slavie+100@gmail.com", true },
				{ "slavie-100@yahoo-test.com", true }};
		return Arrays.asList(data);
	}

	@Test
	public void test() throws InvalidEmailFormatException {
		boolean result = emailFormatValidator.validate(this.email);
		assertEquals(this.expectedValidation, result);
	}

}
