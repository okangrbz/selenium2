package day09_handleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandles {
    /*
    ● Tests package’inda yeni bir class olusturun: WindowHandle2
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
Réduire


     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        //  ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın


        WebElement sayfadakiYazelementi = driver.findElement(By.xpath("//h3"));
        String expecteteteYazi = "Opening a new window";
        String actualyazi = sayfadakiYazelementi.getText();
        Assert.assertEquals(expecteteteYazi, actualyazi);
        //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectettitre = "The Internet";
        String actualtitre = driver.getTitle();
        Assert.assertEquals(expectettitre, actualtitre);



        /*
        Eger kotrolsuz acilan bir tab veya windows varsa o zaman
        sayfalarin window handle degerlerini elde etmem gerekir
        oncelikle ikinci sayfa acilmadan once
            ilk sayfanin window handle degerini bir string e atayalim

         */

        String ilksayfaninWindowhandledegeri = driver.getWindowHandle();


        //● Click Here butonuna basın.

        driver.findElement(By.linkText("Click Here")).click();
        /*
        switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
        biz driver a yeni sayfaya gec demedikce driver eski sayfada kalir
        ve yeni sayfa ile ilgili hic bir islem yapamaz
        yeni sayfa da driver i calistirmak isterseniz
        once driver i yeni sayfaya yollamalisiniz
         */

        /*
        yeni sayfaya gecebilmek icin oncelikle ikinci sayfa window handle degerini bulmamiz gerekir
        bunun icin driver.getWindowHandles () meth kullanarak acik olan tum sayfalarin
        windowHandls degerlerini alip bir sete assigne ederiz

        ilk sayfanin window hand degerini zaten biliyoruz
        setteki windowHandle degerlerini kotrol edip ilk sayfanin hand degerine esit olmayan
        ikinci sayfanin window hand degeridir deriz

         */
        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);
        String ikincisayfaninwindowsHandli = "";
        for (String each : windowHandleSeti
        ) {
            if (!each.equals(ilksayfaninWindowhandledegeri)) {
                ikincisayfaninwindowsHandli = each;
            }

        }

        //artik ikinci sayfanin windowhandle degerini biliyoruz
        //rahatlikla sayfalar arasi gecis yapabiliriz

        driver.switchTo().window(ikincisayfaninwindowsHandli);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expecteteikincititre = "New Window";
        String actualikincititre = driver.getTitle();
        Assert.assertEquals(expecteteikincititre, actualikincititre);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement ikincisayfaYaziElementi=driver.findElement(By.xpath("//h3"));
        String expetetetitreucuncu="New Window";
        String actualtitreucuncu=ikincisayfaYaziElementi.getText();
        Assert.assertEquals(expetetetitreucuncu,actualtitreucuncu);


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “<The Internet>” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaHandleDegeri);
        String expeteteilksayfabaslik="The Internet";
        String actualilksayfabaslik=driver.getTitle();
        Assert.assertEquals(expeteteilksayfabaslik,actualilksayfabaslik);

    }
}
