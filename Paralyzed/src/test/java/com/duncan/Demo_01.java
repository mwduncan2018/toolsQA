package com.duncan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.angelframework.Browser;
import com.angelframework.Pages;

class Demo_01 {

	@Test
	void canGoToPageOne() {
		Pages.pageOne().goTo();
		assertTrue(Pages.pageOne().isAt());
	}
	
	@Test
	void canGoFromPageOneToPageTwo() {
		Pages.pageOne().goTo();
		Pages.pageOne().clickPageTwoLink();
		
		assertTrue(Pages.pageTwo().isAt());
	}

	@AfterAll
	public static void cleanUp() {
		Browser.close();
	}
}
