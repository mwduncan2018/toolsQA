package com.duncan;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PageOneTests {

	@BeforeAll
	public static void beforeAll() {
	}

	@AfterAll
	public static void afterAll() {
	}

	@BeforeEach
	public void beforeEach() {
		Driver.initialize();
	}

	@AfterEach
	public void afterEach() {
		Driver.close();
	}

	@Test
	public void verify_time_delayed_elements() {
		PageOne.goTo();
		assertTrue(PageOne.addToDomContains("Why I have believed as many as seven things before breakfast!"));
	}
	
	@Test
	public void refresh_button_populates_the_customer_list_with_mike_and_steph() {
		LoginPage.goTo();
		LoginPage.loginAs("mduncan").withPassword("Test12#$").login();
		PageOne.clickButtonClear();
		PageOne.clickButtonReset();
		assertTrue(PageOne.customerListContains("Duncan, Mike (120000)"));
		assertTrue(PageOne.customerListContains("Harford, Stephanie (220000)"));
	}
	
	@Test
	public void clear_button_clears_the_customer_list() {
		LoginPage.goTo();
		LoginPage.loginAs("mduncan").withPassword("Test12#$").login();
		PageOne.clickButtonClear();
		PageOne.clickButtonReset();
		PageOne.clickButtonClear();
		assertTrue(PageOne.customerListIsEmpty());	
	}

}