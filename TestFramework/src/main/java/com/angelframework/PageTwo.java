package com.angelframework;

import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;

public class PageTwo {

	static String url = "http://localhost:54070/Alpha/PageTwo";
	static String title = "Page Two - My ASP.NET Application";

	public void goTo() {
		Browser.goTo(url);
	}

	public Boolean isAt() {
		return Browser.title().equals(title);
	}

	 
	
}
