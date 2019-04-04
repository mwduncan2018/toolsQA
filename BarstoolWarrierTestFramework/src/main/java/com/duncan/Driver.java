package com.duncan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Driver {
	public static WebDriver instance;
	
	public static void initialize() {
		instance = TheDriverFactory.driverFor(TheDriverFactory.BROWSER.FIREFOX);
		instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		instance.manage().window().maximize();
	}
	
	public static void close() {
		instance.close();
	}
}
