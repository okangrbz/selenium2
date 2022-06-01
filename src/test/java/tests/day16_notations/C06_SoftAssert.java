package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {

    @Test(groups = "grup2")
    public void test01() {

        /*
        Softassertion baslangic ve bitis satirlari arasindaki
        tum assertionlari yapip bitis satirina geldiginde
        bize buldugu tum hatalari rapor eder

         */

        //Softassert un baslangici obje olusutrmadir
        SoftAssert softAssert=new SoftAssert();

        //1-amazon ana sayfaya gidin
        driver.get("https://amazon.com");

        //2-titre in amazon icerdigini test edin
        String actualtitre = driver.getTitle();
        String expectedTitre = "Amazon";
        softAssert.assertTrue(actualtitre.contains(expectedTitre),"titre amazon icermiyor");

        //3-arama kutrunun erisilebilir odugunu test edin
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramakutusu.isEnabled(),"arama kutusuna erisilemiyor");//enable erisilebilir oldugunu test ediyor

        //4-arama kutusuna nutella yazip aratin
        aramakutusu.sendKeys("Nutella" + Keys.ENTER);

        //5-arama yapildigini test edin
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(),"sonuc yazisi gozukmuyor");


        //6-arama sonucunun nutella icerdigini test edin

        String expectedsonuc = "Nutella";
        String actualsonuc = sonuc.getText();
        softAssert.assertTrue(actualsonuc.contains(expectedsonuc),"sonuc yazisi nutella icermiyor");

        //softassert e bitis satirini soylemek icin assertall() meth kullanilir
        //bu satir yazilmassa assertion gorevini yapmamis olur
        softAssert.assertAll();

        System.out.println("assertion lardan faild olan olursa burasi calsimaz");

        /*
        Softassert'un hata bulsa bile calismaya devam etme ozelligi
        assertAll()'a kadardir.
        Eger assertAll()'da failed rapor edilirse calisma durur
        ve class'in kalan kismi calistirilmaz
        (Yani assertAll hardAsserdeki her bir assert gibidir, hatayi yakalarsa calisma durur)
         */

    }
}
