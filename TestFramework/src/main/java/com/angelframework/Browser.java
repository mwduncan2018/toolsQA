package com.angelframework;

import org.openqa.selenium.WebDriver;

public class Browser {
	static WebDriver driver = MyDriverFactory.driverFor(MyDriverFactory.BROWSER.FIREFOX);
	
	public static void goTo(String url) {
		driver.get(url);
	}

	public static String title() {
		return driver.getTitle();
	}

	public static void close() {
		driver.close();
	}
	
}
