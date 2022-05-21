package day11_faker_file;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_Fiile_Upload extends TestBase {
/*
1.Tests packagenin altina bir class oluşturun : C05_UploadFile
2.https://the-internet.herokuapp.com/upload adresine gidelim
3.chooseFile butonuna basalim
4.Yuklemek istediginiz dosyayi secelim.
5.Upload butonuna basalim.
6.“File Uploaded!” textinin goruntulendigini test edelim.
 */


    @Test
    public void test01() throws InterruptedException {


        driver.get("https://the-internet.herokuapp.com/upload");


        /*
        bu islemi seleniumla yapmaiz mumkun degil bu durumda sendkey() meth imdadimiza yetisir
        eger choosFile butonuna var olan bir dosya yolu yollarsaniz
        secme islemi otamatik olarak yapilir
        */

        //1. adim cljfile butonunu locate edelim

        WebElement dosyasecbutonu= driver.findElement(By.id("file-upload"));

        //2. adim yuklenecek dosyanin dosya yolunu olusutralim

        String yol=System.getProperty("user.home")+("/Downloads/LambdaTest.txt");

        //3.adim sendKeys() ile dosya yolunu secme butonuna yollayalim

        Thread.sleep(5000);
        dosyasecbutonu.sendKeys(yol);


        Thread.sleep(5000);


        //5.Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();

        //6.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement yazielementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yazielementi.isDisplayed());
    }
}
