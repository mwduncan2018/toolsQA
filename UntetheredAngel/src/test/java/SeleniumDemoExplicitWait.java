import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDemoExplicitWait {
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = DriverFactory.driverFor(DriverFactory.BROWSER.CHROME);

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost:54070/Alpha/PageOne");
		System.out.println("Maximizing the window.");
		driver.manage().window().maximize();
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Title: " + driver.findElement(By.id("pageTitle")).getText());
		driver.findElement(By.cssSelector("#btnReset")).click();
		
		WebDriverWait wait; 
		wait = new WebDriverWait(driver, 7);
		WebElement y1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("y1")));		
		System.out.println();
		System.out.println("y1 = " + y1.getText());
		
		WebElement y2 = (new WebDriverWait(driver, 7)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#y2")));
		System.out.println();
		System.out.println("y2 = " + y2.getText());
		
		System.out.println();
		TimeUnit.SECONDS.sleep(2);
		driver.quit();

		System.out.println("\n\nDONE");
	}

}
