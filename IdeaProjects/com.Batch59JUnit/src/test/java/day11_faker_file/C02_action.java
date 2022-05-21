package day11_faker_file;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class C02_action extends TestBase {
    /*
    1- Bir Class olusturalim KeyboardActions2
2- https://html.com/tags/iframe/ sayfasina gidelim
3- video’yu gorecek kadar asagi inin
4- videoyu izlemek icin Play tusuna basin
5- videoyu calistirdiginizi test edin
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://html.com/tags/iframe/");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        WebElement youtube= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Thread.sleep(3000);
        Assert.assertEquals(true, youtube.isEnabled());


    }
}
