package com.duncan;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.angelframework.Pages;

class Demo_01 {

	@Test
	void canGoToPageOne() {
		Pages.pageOne().goTo();
		assertTrue(Pages.pageOne().isAt());
	}

}
