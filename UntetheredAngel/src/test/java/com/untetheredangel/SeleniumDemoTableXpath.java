package com.untetheredangel;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumDemoTableXpath {

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = DriverFactory.driverFor(DriverFactory.BROWSER.CHROME);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:54070/Alpha/PageOne");
		System.out.println("Maximizing the window.");
		driver.manage().window().maximize();
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Title: " + driver.findElement(By.id("pageTitle")).getText());
		driver.findElement(By.cssSelector("#btnReset")).click();

		System.out.println();
		WebElement row = driver.findElement(By.xpath("/html/body/div/div[11]/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
		System.out.println("Row Value = " + row.getText());
		
		TimeUnit.SECONDS.sleep(1);
		driver.quit();

		System.out.println("\n\nDONE");
	}

}
