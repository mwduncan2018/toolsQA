import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumDemo1 {

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = DriverFactory.driverFor(DriverFactory.BROWSER.IE32);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:54070/Alpha/PageOne");
		System.out.println("Maximizing the window.");
		driver.manage().window().maximize();
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Title: " + driver.findElement(By.id("pageTitle")).getText());
		driver.findElement(By.cssSelector("#btnReset")).click();

		driver.findElement(By.linkText("Page Two")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Travis");
		driver.findElement(By.id("LastName")).sendKeys("Duncan");
		driver.findElement(By.id("Age")).sendKeys("36");
		driver.findElement(By.id("Job")).sendKeys("Help Desk");
		driver.findElement(By.id("Salary")).sendKeys("28000");
		driver.findElement(By.cssSelector("#btnCreate")).click();

		System.out.println();
		System.out.println("--- Customer List ---");
		List<WebElement> customerList = driver.findElements(By.cssSelector("#customerList > li"));
		customerList.stream().forEach(x -> System.out.println(x.getText()));

		System.out.println();
		System.out.println("--- Guitar Manufacturers ---");
		driver.findElements(By.cssSelector("#guitarManufacturersList > li"))
				.forEach(x -> System.out.println(x.getText()));

		System.out.println();
		System.out.println("--- Amp Manufacturers ---");
		driver.findElements(By.cssSelector("#ampManufacturersList > li")).forEach(y -> System.out.println(y.getText()));

		System.out.println();
		System.out.println("--- Footer ---");
		System.out.println(driver.findElement(By.cssSelector("footer > p")).getText());

		TimeUnit.SECONDS.sleep(1);
		driver.quit();

		System.out.println("\n\nDONE");
	}



}
