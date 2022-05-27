package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {
    FaceBookPage faceBookPage = new FaceBookPage();

    @Test
    public void test01() {
        /*
        1- Facebook anasayfaya gidin
        -cookis kabul edin cikarsa
        2-kullanici mail kutusuna rast gele isim yazdirin
        3-kullanici sifre kutusuna rast gemle passport yazdirin
        4-login butonuna basin
        5-giris yapilamadigini test edin
         */

        Faker fake = new Faker();

        //   1- Facebook anasayfaya gidin
        Driver.getDriver().get("https://facebook.com");

        //        -cookis kabul edin cikarsa
        faceBookPage.cookieFace.click();

        //        2-kullanici mail kutusuna rast gele isim yazdirin
        faceBookPage.mailKutusu.sendKeys(fake.internet().emailAddress());


        //        3-kullanici sifre kutusuna rast gemle passport yazdirin
        faceBookPage.sifreKutusu.sendKeys(fake.internet().password());


        //        4-login butonuna basin
        faceBookPage.loginTusu.click();

        //        5-giris yapilamadigini test edin
        Assert.assertTrue(faceBookPage.girilemediYaziElementi.isDisplayed());

        Driver.closeDriver();

    }
}
