package day10_action;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C03_Actions extends TestBase {

    /*
    1- Yeni bir class olusturalim: MouseActions1
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
5- Tamam diyerek alert’i kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */
    @Test
    public void test01() {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(driver);
        String ilksayfaHastag = driver.getWindowHandle();
        System.out.println("ilksayfaHastag = " + ilksayfaHastag);


        //3- Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlanlocate = driver.findElement(By.id("hot-spot"));
        action.contextClick(ciziliAlanlocate).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String alert = driver.switchTo().alert().getText();
        String istenen = "You selected a context menu";
        Assert.assertEquals(alert, istenen);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> hastagwindows = driver.getWindowHandles();
        System.out.println("hastagwindows = " + hastagwindows);

        String ikincisayfaHastag = "";
        for (String each : hastagwindows) {
            if (!ilksayfaHastag.equals(each)) {
                ikincisayfaHastag = each;
            }
        }
        System.out.println("ikincisayfaHastag = " + ikincisayfaHastag);
        driver.switchTo().window(ikincisayfaHastag);
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        String actualh1 = h1.getText();
        String expecteteh1 = "Elemental Selenium";
        Assert.assertEquals(actualh1, expecteteh1);


    }
}
