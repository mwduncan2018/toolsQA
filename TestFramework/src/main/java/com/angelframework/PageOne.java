package com.angelframework;

import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageOne {
	
	static String url = "http://localhost:54070/Alpha/PageOne";
	static String title = "Page One - My ASP.NET Application";
	
	public WebElement x;

	public void goTo() {
		Browser.goTo(url);
	}

	public void clickPageTwoLink() {
		Browser.driver.findElement(By.linkText("Page Two")).click();
	}

	public Boolean isAt() {
		return Browser.title().equals(title);
	}

}
