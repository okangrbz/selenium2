package day08_alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_alerts {
    /*
        Bir class olusturun: Alerts
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının       “You successfully clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve
         result mesajının       “successfuly” icermedigini test edin.
        Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna     tıklayın
         ve result mesajında isminizin görüntülendiğini doğrulayın.
        Rédu
        */


  static   WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void down() {
        driver.close();
    }
    /*
           herhangi bir web sitesine gidince veya
           bir web sitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz

           Eger bir alert inspect yapilabiliyorsa o alert otomasyon ile kullanilabilir
           bu tur alertlere html alert denir ve bunlar icin extra bir islem yapmaya gerek yoktur
           tum web elementler gibi locate edip istedigimz islemleri yapabiliriz
           driver.get("https://facebook.com"); cikan alert vb

          Ancak web uygulamalarında html alert yanında javaScript alert de bulunabilir
           javascript ile yapilan alert ler locate edilemez.
           Selenium da javaScript alertler için çok özel bir yöntem geliştirmiştir

           */
    @Test
    public void test01() {



        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //allert tsuna basin
        driver.switchTo().alert().accept();

        //result kisminda "You successfully clicked an alert" yadigini test edin
        WebElement actual = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));

        String expecteRESULT = "You successfully clicked an alert";
        String actualResult = actual.getText();
        Assert.assertEquals(expecteRESULT, actualResult);
    }

    @Test
    public void test02() {
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        //result mesajının       “successfuly” icermedigini test edin.
        String expecteRESULT2 = "successfuly";
        WebElement actualrelt2 = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult2 = actualrelt2.getText();
        Assert.assertFalse(actualResult2.contains(expecteRESULT2));
    }


    @Test
    public void test3() {
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("okan");
        driver.switchTo().alert().accept();
        //ve result mesajında isminizin görüntülendiğini doğrulayın.
        String arananIsim="okan";
        WebElement cikanIsimWe=driver.findElement(By.xpath("//p[@id='result']"));
        String cikanIsim=cikanIsimWe.getText();

        Assert.assertTrue(cikanIsim.contains(arananIsim));


    }


}
