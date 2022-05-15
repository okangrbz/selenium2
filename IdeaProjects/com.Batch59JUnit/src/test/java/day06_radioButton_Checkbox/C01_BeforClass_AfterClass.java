package day06_radioButton_Checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforClass_AfterClass {
    static WebDriver driver;
/*
@BeforClass ve @AfterClass lar static olmalidir. bu class seviyesinde oldugu icin
beforclass basta birkere calisiyor
ve afrer class diger testler tamamlandiginda sonunde hepsi icin devreye giriyor
beforClass ve AfterClass daha hizli oluyor Befor ve After meth gore
 */

    //befor --> tets--> after seklinde ilerliyor


    @BeforeClass //bu ozellik her seferinde yazmayi onlemek icin
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterClass//bu met sonra demek her seferinde ayni seyi yapmayi onlemek icin
    public static void tearDown() {
        //befor meth call
        driver.close();
        //after meth call
    }


    @Test
    public void test01() {
        //befor meth call
        driver.get("https://amazon.fr");
        //after meth call
    }

    @Test
    public void test02() {
        //befor meth call
        driver.get("https://techproeducation.com");
        //after meth call
    }

    @Test
    public void test03() {
        //befor meth call
        driver.get("https://facebook.com");
        //after meth call
    }



}
