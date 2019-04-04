package com.duncan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractTestClass {

	@BeforeAll
	public static void beforeAll() {
	}

	@AfterAll
	public static void afterAll() {
	}

	@BeforeEach
	public void beforeEach() {
		Domain.url = "http://localhost:54070";
		Driver.initialize();
	}

	@AfterEach
	public void afterEach() {
		Driver.close();
	}

}
