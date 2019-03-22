import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class SeleniumDemo {

	public enum BROWSER {
		CHROME, FIREFOX, IE32, IE32_SERVICE_BUILDER, IE64, IE64_SERVICE_BUILDER
	}

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = driverFor(BROWSER.IE32);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:54070/Alpha/PageOne");
		System.out.println("Maximizing the window.");
		driver.manage().window().maximize();
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Title: " + driver.findElement(By.id("pageTitle")).getText());

		System.out.println("--- Guitar Manufacturers ---");
		driver.findElements(By.cssSelector("#guitarManufacturersList > li"))
				.forEach(x -> System.out.println(x.getText()));

		System.out.println("--- Amp Manufacturers ---");
		driver.findElements(By.cssSelector("#ampManufacturersList > li")).forEach(y -> System.out.println(y.getText()));

		System.outprintln();
		System.out.println("--- Footer ---");
		System.out.println(driver.findElement(By.cssSelector("footer > p")).getText());

		TimeUnit.SECONDS.sleep(2);
		driver.quit();

		System.out.println("\n\nDONE");
	}

	private static WebDriver driverFor(BROWSER browser) {
		// FIREFOX
		if (browser.equals(BROWSER.FIREFOX)) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\dev\\tools\\gecko_driver\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			return new FirefoxDriver();
		}
		// CHROME
		else if (browser.equals(BROWSER.CHROME)) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\dev\\tools\\chrome_driver\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
		}
		// IE64
		else if (browser.equals(BROWSER.IE64)) {
			System.setProperty("webdriver.ie.driver",
					"C:\\dev\\tools\\ie_driver_64\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		// IE64_SERVICE_BUILDER
		else if (browser.equals(BROWSER.IE64_SERVICE_BUILDER)) {
			String exePath = "C:\\dev\\tools\\ie_driver_64\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe";
			InternetExplorerDriverService.Builder serviceBuilder = new InternetExplorerDriverService.Builder();
			serviceBuilder.usingAnyFreePort(); // This specifies that sever can pick any available free port to start
			serviceBuilder.usingDriverExecutable(new File(exePath)); // Tell it where you server exe is
			serviceBuilder.withLogLevel(InternetExplorerDriverLogLevel.TRACE); // Specifies the log level of the server
			serviceBuilder.withLogFile(new File("C:\\Users\\abc\\Documents\\logFile.txt")); // Specify the log file.
																							// Change it based on your
																							// system
			InternetExplorerDriverService service = serviceBuilder.build(); // Create a driver service and pass it to
																			// Internet explorer driver instance
			return new InternetExplorerDriver(service);
		}
		// IE32
		else if (browser.equals(BROWSER.IE32)) {
			System.setProperty("webdriver.ie.driver",
					"C:\\dev\\tools\\ie_driver_32\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		// IE32_SERVICE_BUILDER
		else if (browser.equals(BROWSER.IE32_SERVICE_BUILDER)) {
			String exePath = "C:\\dev\\tools\\ie_driver_32\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe";
			InternetExplorerDriverService.Builder serviceBuilder = new InternetExplorerDriverService.Builder();
			serviceBuilder.usingAnyFreePort(); // This specifies that sever can pick any available free port to start
			serviceBuilder.usingDriverExecutable(new File(exePath)); // Tell it where you server exe is
			serviceBuilder.withLogLevel(InternetExplorerDriverLogLevel.TRACE); // Specifies the log level of the server
			serviceBuilder.withLogFile(new File("C:\\Users\\abc\\Documents\\logFile.txt")); // Specify the log file.
																							// Change it based on your
																							// system
			InternetExplorerDriverService service = serviceBuilder.build(); // Create a driver service and pass it to
																			// Internet explorer driver instance
			return new InternetExplorerDriver(service);
		} else {
			return null;
		}
	}

}
