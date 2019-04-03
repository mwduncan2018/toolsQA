package com.duncan;

import org.openqa.selenium.By;

public class PageOne {

	public static Boolean isAt() {
		if (Driver.instance.findElement(By.id("pageTitle")).getText().equals("Page One")) {
			return true;
		}
		return false;
	}

}
