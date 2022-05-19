package day10_action;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_KeyboardActions extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        //once arama kutusuna click yapip
        // sonra harf harf Nutella yazdirip yollayalim
        //sonra entre tusuna basalim

        driver.get("https://amazon.com");
        WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));
        Actions action = new Actions(driver);
        action.
                click(aramaCubugu).
                keyDown(Keys.SHIFT).
                sendKeys("n").
                keyUp(Keys.SHIFT).
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                sendKeys(Keys.ENTER).
                perform();

        Thread.sleep(5000);


    }


}
