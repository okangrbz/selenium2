package day15_writeExcel_screenShot;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_JS_Executor extends TestBase {
    @Test
    public void JsExecutesTest() {
        // amazon'a gidelim
        driver.get("https://www.amazon.com");
        // asagidaki sign in butonu gorununceye kadar js ile scrool yapalim
        WebElement signedIn = driver.findElement(By.xpath("//span[text()='Sign in']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",signedIn);//"arguments[0].scrollIntoView(true); sayfa kaydirmak icin

        jse.executeScript("arguments[0].click();",signedIn);//; u unutmamak lazim cunki jva script komutu



    }
}
