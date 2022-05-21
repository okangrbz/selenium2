package day11_faker_file;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim
    @Test
    public void test01() {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. LambdaTest.txt dosyasını indirelim

        driver.findElement(By.xpath("//a[@href='download/LambdaTest.txt']")).click();

        //4. dosyanın başarıyla indirilip indirilmediğini test edelim

        String yol=System.getProperty("user.home")+("/Downloads/LambdaTest.txt");
        System.out.println(yol);
        Assert.assertTrue(Files.exists(Paths.get(yol)));


    }
}
