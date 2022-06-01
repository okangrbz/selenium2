package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/*
youI testing
Api testing
databese SQL testing
 */

import java.time.Duration;

public abstract class   TestBase {

    //abstrac yapmamizin sebebi bu classdan objet uretilmesininonune gecmektir
    protected WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
