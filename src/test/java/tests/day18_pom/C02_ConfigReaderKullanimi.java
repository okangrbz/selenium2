package tests.day18_pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {

    @Test
    public void test01() {
        FaceBookPage faceBookPage = new FaceBookPage();

        //   1- Facebook anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));


        //        -cookis kabul edin cikarsa
        faceBookPage.cookieFace.click();

        //        2-kullanici mail kutusuna rast gele isim yazdirin

        faceBookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));

        //        3-kullanici sifre kutusuna rast gemle passport yazdirin

        faceBookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        //        4-login butonuna basin
        faceBookPage.loginTusu.click();

        //        5-giris yapilamadigini test edin

        Assert.assertTrue(faceBookPage.girilemediYaziElementi.isDisplayed());

        Driver.closeDriver();


    }
}
