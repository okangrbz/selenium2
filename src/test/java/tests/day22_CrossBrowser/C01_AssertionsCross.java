package tests.day22_CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseCross;

public class C01_AssertionsCross extends TestBaseCross {//cross icin test Base Cross a child yaptik

    @Test
    public void test01() {

        //1-amazon ana sayfaya gidin
        driver.get("https://amazon.com");

        //2-titre in amazon icerdigini test edin
        String actualtitre=driver.getTitle();
        String expectedTitre="Amazon";
        Assert.assertTrue(actualtitre.contains(expectedTitre));

        //3-arama kutrunun erisilebilir odugunu test edin
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramakutusu.isEnabled());//enable erisilebilir oldugunu test ediyor

        //4-arama kutusuna nutella yazip aratin
        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);

        //5-arama yapildigini test edin
        WebElement sonuc= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonuc.isDisplayed());


        //6-arama sonucunun nutella icerdigini test edin

        String expectedsonuc="Nutella";
        String actualsonuc=sonuc.getText();
        Assert.assertTrue(actualsonuc.contains(expectedsonuc));


    }
}
