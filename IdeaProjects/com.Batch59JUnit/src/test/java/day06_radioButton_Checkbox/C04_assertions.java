package day06_radioButton_Checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_assertions {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void down() {
        driver.close();

    }

    @Test
    public void test01() {
        /*
        eger test meth hicbir test yoksa, test calisitiktan sonra
        hic bir problemle karsilasilmadigini raporlamak icin
        test Passe yazisi cikar

        EGER TESTLERI IF ILE YAPARSAK
        TEST FAILD OLSA BILE CODLAR PROBLEMSIZ CALISITIGI ICIN
        CODE CALISMASI BITTIGINDE EKRAN SOL ALT KISMINDA TEST PASTE YAZACAKTIR
         */


        driver.get("https://amazon.com");

        /*
        //url4in https://www.facebook.com oldugunu faild edin
        if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("url testti PASSED");
        }else {
            System.out.println("url testi FAILD");
        }

        */
        String expectedUrl="https://www.facebook.com";
        String actuelUrl= driver.getCurrentUrl();
        Assert.assertEquals("Url beklenenden farkli",expectedUrl,actuelUrl);

        /*
        Assert ile yaptigimiz testlerle assertion fail olursa
        java codlarin calismasini durudurur ve assert class i bizi
        hata konusunda bilgilendirir
                        org.junit.ComparisonFailure: Url beklenenden farkli
                        Expected :https://www.facebook.com
                        Actual   :https://www.amazon.com/
                        <Click to see difference>
        Boylece hatanin ne oldugunu aramamiza gerek kalmadan
        Junit bize raporlamis olur
         */
    }
}
