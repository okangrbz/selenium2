package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKUllanimi {
    @Test
    public void test01() {
        //amazona gideli
        Driver.getDriver().get("https://amazon.com");


        //nutella arat
        AmazonPage amzon=new AmazonPage();
        amzon.aramakutusu.sendKeys("Nutella"+ Keys.ENTER);

        //spnuc yazisinin Nutella icerdigini test et
        String actual=amzon.aramaSonucElementi.getText();
        String expectedsonuc="Nutella";
        Assert.assertTrue(actual.contains(expectedsonuc));

        Driver.closeDriver();
    }
}
