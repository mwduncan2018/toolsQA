package com.duncan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageOne {

	public static String url = "http://localhost:54070/Alpha/PageOne";

	public static void goTo() {
		Driver.instance.get(url);
	}

	public static Boolean isAt() {
		if (Driver.instance.findElement(By.id("pageTitle")).getText().equals("Page One")) {
			return true;
		}
		return false;
	}

	public static void clickButtonClear() {
		Driver.instance.findElement(By.id("btnClear")).click();
	}

	public static void clickButtonReset() {
		Driver.instance.findElement(By.id("btnReset")).click();
	}

	public static Boolean customerListContains(String str) {
		List<WebElement> customerList = Driver.instance.findElements(By.cssSelector("#customerList > li"));

		for (WebElement x : customerList) {
			if (x.getText().equals(str)) {
				return true;
			}
		}

		return false;
	}

	public static Boolean customerListIsEmpty() {
		List<WebElement> customerList = Driver.instance.findElements(By.cssSelector("#customerList > li"));

		if (customerList.size() == 0) {
			return true;
		}

		return false;
	}

	public static Boolean addToDomContains(String str) {
		String y1 = null;
		String y2 = null;
		try {
			y1 = new WebDriverWait(Driver.instance, 7)
					.until(ExpectedConditions.presenceOfElementLocated(By.id("y1")))
					.getText();
		} catch (Exception e) {}
		try {
			y2 = new WebDriverWait(Driver.instance, 7)
					.until(ExpectedConditions.presenceOfElementLocated(By.id("y2")))
					.getText();
		} catch (Exception e) {}
		
		if (y1 != null && y1.equals(str)) {
			return true;
		}
		if (y2 != null && y2.equals(str)) {
			return true;
		}
		return false;
	}

}
