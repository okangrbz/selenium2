package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_DropDownOption {
    /*
    Amazon anasayfaya gidip
    dropDown menuden books u secelim
    sectigimiz option u yazdiralim

    dropdown daki optionlarin toplam sayisinin
    20 oldugunu test edin
     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void down() {
        driver.close();

    }

    @Test
    public void test01() {
        driver.get("https://amazon.com");
        WebElement select = driver.findElement(By.xpath("//select"));
        Select slct = new Select(select);
        slct.selectByVisibleText("Books");

        //bir dropdown ile calisiyorken son secilen option a ulasmak istersek
        //slct.getFirstSelectedOption().getText() meth kullanmaliyiz
        //bu meth bize web element dondurur
        //uzerindeki yaziyi yazdirmak icin getText() unutulmamalidir
        System.out.println(slct.getFirstSelectedOption().getText());


        System.out.println(slct.getOptions().size());


    }
}
