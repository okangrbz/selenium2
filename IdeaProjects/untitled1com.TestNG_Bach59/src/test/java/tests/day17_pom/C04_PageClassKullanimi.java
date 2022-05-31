package tests.day17_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C04_PageClassKullanimi {

    /*
    1 ) Bir Class olustur : PositiveTest
2) Bir test method olustur positiveLoginTest()
 https://www.hotelmycamp.com/ adresine git
 login butonuna bas
 test data username: manager ,
 test data password : Manager1!
 Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void positiveLoginTest() {


        // https://www.hotelmycamp.com/ adresine git

        Driver.getDriver().get("https://www.hotelmycamp.com/");

        // login butonuna bas

        Driver.getDriver().findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();


        Actions action=new Actions(Driver.getDriver());
        // test data username: manager ,
        Driver.getDriver().findElement(By.xpath("//input[@name='UserName']")).sendKeys("manager");
        action.sendKeys(Keys.TAB);



        // test data password : Manager1!
        Driver.getDriver().findElement(By.xpath("//input[@name='Password']")).sendKeys("Manager1!");
        Driver.getDriver().findElement(By.xpath("//input[@value='Log in']")).click();


        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(Driver.getDriver().findElement(By.className("page-content-wrapper")).isDisplayed());






    }
}
