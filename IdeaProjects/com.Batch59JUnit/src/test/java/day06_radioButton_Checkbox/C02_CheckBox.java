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

public class C02_CheckBox {

    WebDriver driver;

    //bir class olusuturun checkBox
    //2.gerekli yapiyi olsuturun ve asigidaki gorevi tamamlayin
    //a.verilen web sayfasina gidin
    //https://theinternet.herokuapp.com/checkboxes

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //b.checkbox1 ve checkbox2 elemanlarini localiser edin
        WebElement checkbox1 = driver.findElement(By.xpath("(//input)[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input)[2]"));

        Thread.sleep(3000);
        //c.checkbox1 secili degilse onay kutusunu tiklayin
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        Thread.sleep(3000);
        //d.checkbox2 secili degilse onay kutusunu tiklayin
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

    }


}

