package day15_writeExcel_screenShot;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {


    @Test
    public void UstenenWebelemaniEkranCopyTesti() throws IOException {
        //amazona gidin
        driver.get("https://amazon.com");

        //nutella aratin
        WebElement  aramacubugu=driver.findElement(By.id("twotabsearchtextbox"));
        aramacubugu.sendKeys("nutella"+ Keys.ENTER);


        //sonuc kismini goruntusunu screen alin
        WebElement sonuccubugu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File screen=new File("/Users/pc/IdeaProjects/com.Batch59JUnit/target/localscreen/localscreen.jpeg");
        File temp=sonuccubugu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,screen);


    }
}
