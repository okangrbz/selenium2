package day11_faker_file;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Faker extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //facebook gorevini fake isimlerle yapalim
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        Actions action = new Actions(driver);
        Faker fake = new Faker();

        WebElement isim = driver.findElement(By.xpath("//input[@name='firstname']"));

        String fakemail = fake.internet().emailAddress();
        isim.sendKeys(fake.name().firstName());
        action.
                sendKeys(Keys.TAB).
                sendKeys(fake.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(fakemail).
                sendKeys(Keys.TAB).
                sendKeys(fakemail).
                sendKeys(Keys.TAB).
                sendKeys(fake.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("may").
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("1988").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();


        Thread.sleep(10000);


    }
}
