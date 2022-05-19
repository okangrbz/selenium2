package day10_action;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_KeyboarActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //facebook anasayfaya gidip
        //yeni kayit olustur butonuna basalim
        //isim kuttusunu locate edip
        //geriye kalan alanlari tap ile dolacarak formu doldurun
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        Actions action=new Actions(driver);

        WebElement isim=driver.findElement(By.xpath("//input[@name='firstname']"));



        isim.sendKeys("okan");
        action.
               sendKeys(Keys.TAB).
                sendKeys("baba").
                sendKeys(Keys.TAB).
                sendKeys("kldjfk@klfd.Fdf").
                sendKeys(Keys.TAB).
                sendKeys("545641").
                sendKeys(Keys.TAB).
                sendKeys("dfklmdk").
                perform();


        Thread.sleep(5000);





    }
}
