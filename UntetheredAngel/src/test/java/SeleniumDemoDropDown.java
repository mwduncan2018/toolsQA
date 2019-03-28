import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDemoDropDown {
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

		// For drop downs, use the Select class.
		// The Select class wraps around the WebElement class.
		WebElement selectElement = driver.findElement(By.id("dropDownDemo"));
		Select select = new Select(selectElement);
		select.selectByVisibleText("Maybe");

		TimeUnit.SECONDS.sleep(1);
		driver.quit();

		System.out.println("\n\nDONE");
	}

}
