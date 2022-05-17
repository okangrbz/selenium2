package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
        Bir class olusturun: IframeTest
        ● https://the-internet.herokuapp.com/iframe adresine gidin.
        ● Bir metod olusturun: iframeTest
        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        ○ Text Box’a “Merhaba Dunya!” yazin.
        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.
*/
public class C03_Iframe {
    static WebDriver driver;

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

    //Bir metod olusturun: iframeTest
    @Test
    public void iframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        WebElement baslik = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslik.isEnabled());//enable erisilebilir oduguna bakmak icin kullaniriz
        System.out.println(baslik.getText());

// textbox'i dogru olarak locate etmemize ragmen driver bulamadi
// bunun uzerine HTML kodlari inceleyince
// textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
// bu durumda once iframe'i locate edip
// switchTo() ile o iframe'e gecmeliyiz

        //Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);

        WebElement txt = driver.findElement(By.xpath("//body[@id='tinymce']"));
        txt.clear();
        txt.sendKeys("merhaba dunya");

        //TextBox’in altinda bulunan “Elemental Selenium”
        //linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.


        //WebElement linkyazi=driver.findElement(By.linkText("Elemental Selenium"));
        //Assert.assertTrue(linkyazi.isDisplayed());

        //bu sekilde iframe den cikmaden bir ust siteye gecemez o yuzden iframe den cikmak lazim

        driver.switchTo().defaultContent();//en ust page a cikiyor
        WebElement linkyazi = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkyazi.isDisplayed());


    }
}
