package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    amazona gidip
    dropDown dan books secenegini secip
    Java aratalim
    ve arama sonuclarinin java icerdigini test ediniz
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
        driver.get("https://amazon.com");
        WebElement select=driver.findElement(By.xpath("//select"));
        Select slct=new Select(select);
        slct.selectByVisibleText("Books");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);

        WebElement aramasncAmazon=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime="java";
        String aramaSnc=aramasncAmazon.getText();
        Assert.assertTrue(aramaSnc.contains(arananKelime));



    }

}
