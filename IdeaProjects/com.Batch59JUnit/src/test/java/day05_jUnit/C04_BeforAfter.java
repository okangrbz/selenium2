package day05_jUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforAfter {
    WebDriver driver;


    //befor --> tets--> after seklinde ilerliyor


    @Before //bu ozellik her seferinde yazmayi onlemek icin
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After//bu met sonra demek her seferinde ayni seyi yapmayi onlemek icin
    public void tearDown() {
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
