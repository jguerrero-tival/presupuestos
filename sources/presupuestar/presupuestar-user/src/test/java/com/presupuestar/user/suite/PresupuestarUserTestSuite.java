package com.presupuestar.user.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.presupuestar.user.builder.UserBuilderTest;
import com.presupuestar.user.service.RegisterUserAccountTest;
import com.presupuestar.user.service.UserLoginTest;
import com.presupuestar.user.validator.EmailFormatValidatorTest;

@RunWith(Suite.class)
@SuiteClasses(value = { 
		UserBuilderTest.class, 
		RegisterUserAccountTest.class,
		UserLoginTest.class, 
		EmailFormatValidatorTest.class
		})
public class PresupuestarUserTestSuite {

}
