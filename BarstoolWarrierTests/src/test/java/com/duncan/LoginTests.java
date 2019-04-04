package com.duncan;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginTests extends AbstractTestClass {

	@Test
	public void mduncan_can_login() {
		LoginPage.goTo();
		LoginPage.loginAs("mduncan").withPassword("Test12#$").login();
		assertTrue("ERROR --> mduncan was unable to login", PageOne.isAt());
	}

	@Test
	public void validation_displays_for_invalid_username_password_combination_01() {
		LoginPage.goTo();
		LoginPage.loginAs("invalidUser").withPassword("Test12#$").login();
		String validationMessage = LoginPage.getValidationSummary();
		assertTrue(validationMessage.equals("Invalid username and password combination"));
	}

	@Test
	public void validation_displays_for_invalid_username_password_combination_02() {
		LoginPage.goTo();
		LoginPage.loginAs("sharford").withPassword("invalidPassword").login();
		String validationMessage = LoginPage.getValidationSummary();
		assertTrue(validationMessage.equals("Invalid username and password combination"));
	}

	@Test
	public void validation_displays_when_username_field_is_empty() {
		LoginPage.goTo();
		LoginPage.loginAs("").withPassword("Test12#$").login();
		String validationMessage = LoginPage.getUsernameValidationMessage();
		assertTrue(validationMessage.equals("Username is required."));
	}

	@Test
	public void validation_displays_when_password_field_is_empty() {
		LoginPage.goTo();
		LoginPage.loginAs("mduncan").withPassword("").login();
		String validationMessage = LoginPage.getPasswordValidationMessage();
		assertTrue(validationMessage.equals("Password is required."));
	}

}