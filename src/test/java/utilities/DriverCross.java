package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverCross {
	public static WebDriver driver;

	private DriverCross(){

	}

	public static WebDriver getDriver(String browser) {

		browser = (browser == null)? ConfigReader.getProperty("browser") : browser;//ternary olarak browser null olursa
		   																	     // driver i configReader dan calistircacak

		if (driver == null) {
			switch (browser) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;


				case "headless-chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
					break;

				case "safari":
					WebDriverManager.safaridriver().setup();
					driver = new SafariDriver();
					break;

				case "firefox":

					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;

				default:
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();


			}


		}

		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {//diver a bir deger atanmis
			driver.quit();
			driver = null;

		}
	}

}
