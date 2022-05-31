package day15_writeExcel_screenShot;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void screenShotTest() throws IOException {
        driver.get("https://amazon.com");

        TakesScreenshot ss= (TakesScreenshot) driver;
        LocalDateTime time=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih =formatter.format(time);

        File filess=new File("target/tamekran/tamekran"+tarih+".jpeg");
        File temp=ss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,filess);



    }
}
