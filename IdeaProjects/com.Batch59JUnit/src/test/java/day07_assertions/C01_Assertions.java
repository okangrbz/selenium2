package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    1-amazon ana sayfaya gidin
    2-3 farkli test meth olusuturarak asagidaki gorevleri yapin
        a-Url 'in amazon icerdigini test edin
        b-titre 'in facebook icermedigini test edin
        c-sol ust kosede amazon logosunun gorundugunu test edin
     */

    //butun aktionlar tek bir sitede oldugu icin Befor ve afterclass lar daha hizli olur
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://amazon.com");

    }

    @AfterClass
    public static void down() {
        driver.close();
    }

    @Test
    public void test01() {


        //a-Url 'in amazon icerdigini test edin

        String exceptedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(exceptedUrl));


    }

    @Test
    public void test02() {
        //b-titre 'in facebook icermedigini test edin
        String arananKelime="facebook";
        String actualTitre=driver.getTitle();
        Assert.assertFalse(actualTitre.contains(arananKelime));

    }

    @Test
    public void test03() {
        // c-sol ust kosede amazon logosunun gorundugunu test edin
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());


    }

}
