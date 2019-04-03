package com.duncan;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PageTwoTests {

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
	public void verify_add_customer() {
		PageTwo.goTo();
		PageTwo.createCustomer()
				.withAge("21")
				.withFirstName("Kelly")
				.withLastName("Hood")
				.withJob("Jewelry Sales")
				.withSalary("20000")
				.submit();
		assertTrue(PageOne.isAt());
		assertTrue(PageOne.customerListContains("Hood, Kelly (20000)"));
	}

}