package tests.day19_smokeTest.exercices;
/*
1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
    // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
    // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
    // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
    // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
    // (Her ürün 1 defadan fazla eklenemez!)
    // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
    // 6.Sonuçlar eşleşiyorsa  konsola test pass yazdirin
    // 7.Checkout'a tıklayın
    @Test
    public void Test() throws InterruptedException {
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        List<WebElement> urunlerListesiWebElement = driver.findElements(By.xpath("//p[@class='sc-124al1g-4 eeXMBo']"));
        urunYazdir(urunlerListesiWebElement);
        //(//button[@class='sc-124al1g-0 jCsgpZ'])
        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        urunAdlariniListeEkle(urunlerListesiWebElement);
        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        randomBesUrunSecSepeteEkleveYazdir(driver);
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        String cartTotalPriceString = driver.findElement(By.xpath("//div[@class='sc-1h98xa9-8 bciIxg']//p[@class='sc-1h98xa9-9 jzywDV']")).getText();
        double actualCartTotalPrice = Double.parseDouble(cartTotalPriceString.replaceAll("\\D", ""));
        double expectedRandomSecilenUrunlerinFiyatToplami = secilenOgelerinFiyatiniTopla(driver);
        Assert.assertEquals(actualCartTotalPrice, expectedRandomSecilenUrunlerinFiyatToplami);
        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazdirin
        System.out.println("Test Pass");
        // 7.Checkout'a tıklayın
        driver.findElement(By.xpath("//button[@class='sc-1h98xa9-11 gnXVNU']")).click();
    }
    private double secilenOgelerinFiyatiniTopla(WebDriver driver) {
        double toplam = 0;
        List<WebElement> pricesOfTheProductInTheCart = driver.findElements(By.xpath("//div[@class='sc-11uohgb-4 bnZqjD']//p"));
        for (WebElement each : pricesOfTheProductInTheCart) {
            toplam +=  Double.parseDouble(each.getText().replaceAll("\\D", ""));
        }
        return toplam;
    }
    private void randomBesUrunSecSepeteEkleveYazdir(WebDriver driver) throws InterruptedException {
        Random random = new Random();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        List<WebElement> addToChartWebElementList = driver.findElements(By.xpath("//button[@class='sc-124al1g-0 jCsgpZ']"));
        int count = 0;
        while (count < 5) {
            int randomNum = random.nextInt(addToChartWebElementList.size());
            System.out.println(" secilen random numaralar :" + randomNum);
            jse.executeScript("arguments[0].scrollIntoView();", addToChartWebElementList.get(randomNum));
            addToChartWebElementList.get(randomNum).click();
            Thread.sleep(1000);
            WebElement cartCloseButton = driver.findElement(By.xpath("//button[@class='sc-1h98xa9-0 gFkyvN']"));
            cartCloseButton.click();
            addToChartWebElementList.remove(randomNum);
            count++;
        }
        WebElement cartOpenButton = driver.findElement(By.xpath("//button[@class='sc-1h98xa9-0 gFkyvN']"));
        cartOpenButton.click();
        List<WebElement> productsInTheChart = driver.findElements(By.xpath("//p[@class='title']"));
        productsInTheChart.stream().forEach(t -> System.out.println(t.getText()));
    }
    private void urunAdlariniListeEkle(List<WebElement> urunlerListesiWebElement) {
        List<String> urunListesiList = new ArrayList<>();
        for (int i = 0; i < urunlerListesiWebElement.size(); i++) {
            urunListesiList.add(urunlerListesiWebElement.get(i).getText());
        }
    }
    private void urunYazdir(List<WebElement> urunlerListesiWebElement) {
        for (int i = 0; i < urunlerListesiWebElement.size() ; i++) {
            System.out.println(i+1 + ". urun = " + urunlerListesiWebElement.get(i).getText());
        }
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ex01_canHc {

//// 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
//// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
//// (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
//// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
//// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
//// (Her ürün 1 defadan fazla eklenemez!)
//// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
//// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
//// 7.Checkout'a tıklayın


    @Test
    public void test01() throws InterruptedException {
        System.out.println("======================1======================");
//// 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin

        Driver.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com");

        System.out.println("====================2========================");
//// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        List<WebElement> tumElemanlar = Driver.getDriver().findElements(By.xpath("//div[@ tabindex ='1']"));
        for (WebElement each : tumElemanlar) {
            System.out.println(each.getText());

        }


//// (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        int inciEleman = 1;
        List<WebElement> isimlerlitesi = Driver.getDriver().findElements(By.xpath("//p[@class='sc-124al1g-4 eeXMBo']"));
        System.out.println("============================================");
        System.out.println(Driver.getDriver().getTitle() + " sitesinde " + isimlerlitesi.size() + " urun var");
        System.out.println("============================================");
        for (WebElement each : isimlerlitesi) {
            System.out.println(inciEleman + " inci urun :  " + each.getText());
            inciEleman++;
        }

        System.out.println("==================3==========================");
//// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        List<String> urunadiList = new ArrayList<>(tumElemanlar.size());

        for (WebElement each : isimlerlitesi) {
            urunadiList.add(each.getText());

        }
        System.out.println(urunadiList);


        System.out.println("===================4=========================");
//// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın

        Random random = new Random();



        String[] secilieleman = new String[5];
        List<WebElement> addicon = Driver.getDriver().findElements(By.xpath("//button[@tabindex='-1']"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement xicon = Driver.getDriver().findElement(By.xpath("//button[@class='sc-1h98xa9-0 gFkyvN']"));
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        //List<WebElement> unitprice=Driver.getDriver().findElements(By.xpath("//div[@class='sc-11uohgb-4 bnZqjD']"));
        List<String> unitpricelist=new ArrayList<>();
        int randm = 0;
        for (int i = 0; i < 5; i++) {

            randm = random.nextInt(tumElemanlar.size());

            if (!(secilieleman.equals(tumElemanlar.get(randm).getText()))) {
                secilieleman[i] += tumElemanlar.get(randm).getText();
                jse.executeScript("arguments[0].scrollIntoView();", addicon.get(randm));
                addicon.get(randm).click();
                wait.until(ExpectedConditions.elementToBeClickable(xicon));
                //unitpricelist.add(i,unitprice.get(randm).getText());
                xicon.click();
                randm = 0;
            }else i--;

        }

        System.out.println(Arrays.toString(secilieleman));


//// (Her ürün 1 defadan fazla eklenemez!)

        System.out.println("=====================5=======================");
//// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın



        System.out.println("======================6======================");
//// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin


        System.out.println("===============7=============================");
//// 7.Checkout'a tıklayın

        //Driver.closeDriver();
    }
}
