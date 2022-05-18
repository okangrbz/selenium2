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

public class C02_Assertions {
    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        ○ logoTest => BestBuy logosunun görüntülendigini test edin
        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

     */
   static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");


    }

    @AfterClass
    public static void down() {
        driver.close();

    }

    @Test
    public void test01() {
        //Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String aranaUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, actualUrl);

    }

    @Test
    public void test02() {
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String arananKelime = "Rest";
        String actualTitre = driver.getTitle();
        Assert.assertFalse(actualTitre.contains(arananKelime));
    }

    @Test
    public void test03() {
        //logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[2]"));
        Assert.assertTrue(logo.isDisplayed());

    }
    @Test
    public void test04() {
        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement frLink=driver.findElement(By.className("is-active"));
        Assert.assertTrue(frLink.isDisplayed());

    }

}
