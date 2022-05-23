package day13_cookies_webtable;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Webtable extends TestBase {
    @Test
    public void name() {
        //onceki clastaki adrese girip
        //giris() meth kullanarak sayfaya giris yapiniz
        //input olarak verilen satir sayisi ve sutun sayisi na sahip
        //celldeki text ti yazdirin

        int satir=5;
        int sutun=6;
        girisYap();

        WebElement aranancell=
                driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("aranan cell : "+aranancell.getText());







    }

    public  void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }

}
