package day10_action;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Action extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //amazon ana sayfaya gidip
        //acount menusunden creat a list linkini tiklayalim
        driver.get("https://amazon.com");
        Actions action=new Actions(driver);
        WebElement accountMenu=driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        action.moveToElement(accountMenu).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        Thread.sleep(5000);


    }
}
