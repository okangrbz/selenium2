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
import java.util.List;

public class C08_DropDown {
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
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement down = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(down);


        /*
        getFirstSelectedOption() methodu bir onceki dropdown menusundeki secilen optionu Webelement
        olarak getirir. Bunu getText() yaparak degeri direk yazdirabiliriz
         */
        dropdown.selectByIndex(1);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("2");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("Option 1");


        List<WebElement> toutlist = dropdown.getOptions();


        for (int i = 0; i < toutlist.size(); i++) {
            System.out.println(toutlist.get(i).getText());

        }

        int size = dropdown.getOptions().size();
        System.out.println(size);
        if (size == 4) {
            System.out.println("True");
        } else {
            System.out.println("false");

        }

    }
}
