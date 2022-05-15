package day06_radioButton_Checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;
    //facebook.com adresine gidin


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void fermeture() {
        //driver.close();

    }

    @Test
    public void test01() throws InterruptedException {

        //facebook.com adresine gidin
        driver.get("https://facebook.com");

        //Cookies i kabul edin
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        //"Creat an Account" buttonuna bas

        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //radio button elemnalarini localiser et
        WebElement radiobuttonHomme = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement radiobuttonFemme = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement radiobuttonpersonaliser = driver.findElement(By.xpath("//input[@value='-1']"));

        //secili degilse birini sec

        Thread.sleep(3000);
        if (!radiobuttonHomme.isSelected()) {
            radiobuttonHomme.click();
        }
        Thread.sleep(3000);
        radiobuttonFemme.click();
        Thread.sleep(3000);
        radiobuttonpersonaliser.click();

    }


}
