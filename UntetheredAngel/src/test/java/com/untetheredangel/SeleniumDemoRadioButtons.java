package com.untetheredangel;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumDemoRadioButtons {

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

		List<WebElement> radioButtons = driver.findElements(By.name("superRadio"));
		radioButtons.forEach(z -> {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				z.click();
				TimeUnit.MILLISECONDS.sleep(500);
				driver.findElement(By.cssSelector("#btnSelectSong")).click();
				TimeUnit.MILLISECONDS.sleep(500);
				Alert alert = driver.switchTo().alert();
				alert.accept();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		TimeUnit.SECONDS.sleep(1);
		driver.quit();

		System.out.println("\n\nDONE");
	}

}
