package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    POM de Driver icin TestBase classina extend etmek yerine
    Driver classindan static methodlar kullanarak Driver olusuturup
    ilgili ayarlarin yapilmasi ve en sonda Driver in kapatilmasi
    tercih edilmistir

    POM da driver classindaki getDriver() methodunun obj olusutrularak
    kullanilmasini engellemek icin Singleton patent kullanimi benimsenmisitir.
    Singleton tekli kullanim demek. yani bir clasin farklio classlardan obj
    olusutrularak kullanimini engellemek icin kullanilir.

    Bunu saglamak icin yapmamiz gerek sey oldukca basit
    Objet olusuturmak icin kullanilan conracter i privat yaptiimizda
     baska classlarda driver classindan obj olusutrulmasi mumkun olamaz


     https://us06web.zoom.us/j/83480876357?pwd=TkR0dW9aOHFHZ2lWNi9YQ1J5VzVzdz09


     */

     public static WebDriver driver;

   private Driver(){

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    break;



                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    break;

                case "firefox":

                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
