package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_assertions {
    /*
    tled
Bir Class olusturalim YanlisEmailTesti
http://automationpractice.com/index.php sayfasina gidelim
Sign in butonuna basalim
Email kutusuna @isareti olmayan bir mail yazip
enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */

     WebDriver driver;

    @Before
    public  void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public  void down() {
        driver.close();

    }

    @Test
    public void test01() {
        driver.navigate().to("https://automationpractice.com/index.php");
        driver.navigate().refresh();
        //Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //Email kutusuna @isareti olmayan bir mail yazip
        driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[1]")).sendKeys("hacibaba.com.tr"+ Keys.ENTER);

        //enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim

        String expectename = "Invalid email address.";
        WebElement act = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));

        String actual=act.getText();
        Assert.assertEquals(expectename,actual);

    }
}
