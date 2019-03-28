import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumDemoCheckBoxes {
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

		WebElement checkBoxDreamTheater = driver.findElement(By.id("checkBoxDreamTheater"));
		WebElement checkBoxPantera = driver.findElement(By.id("checkBoxPantera"));
		WebElement checkBoxMetallica = driver.findElement(By.id("checkBoxMetallica"));

		checkBoxDreamTheater.click();
		TimeUnit.MILLISECONDS.sleep(200);
		checkBoxPantera.click();
		TimeUnit.MILLISECONDS.sleep(200);
		checkBoxMetallica.click();
		TimeUnit.MILLISECONDS.sleep(200);

		driver.findElement(By.id("btnSelectBand")).click();
		TimeUnit.MILLISECONDS.sleep(400);
		driver.switchTo().alert().accept();
		TimeUnit.MILLISECONDS.sleep(400);
		driver.switchTo().alert().accept();
		
		TimeUnit.SECONDS.sleep(1);
		driver.quit();

		System.out.println("\n\nDONE");
	}
}