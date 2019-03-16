import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo01 {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:\\dev\\tools\\gecko_driver\\geckodriver-v0.24.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.quit();

		System.out.println("DONE");
	}

}
