package day12_sencranisation;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_Explicitly extends TestBase {
    /*
    1. Bir class olusturun : WaitTest
2. Iki tane metod olusturun : implicitWait() , explicitWait()
     Iki metod icin de asagidaki adimlari test edin.
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Remove butonuna basin.
5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
6. Add buttonuna basin
7. It’s back mesajinin gorundugunu test edin
     */


    @Test
    public void ImplicitlyWaitTest() {


        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


       //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

       //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement mesj=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(mesj.isDisplayed());

       //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

       //7. It’s back mesajinin gorundugunu test edin
        WebElement istsbeack=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(istsbeack.isDisplayed());

    }

    @Test
    public void explicitliwaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement mesj=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(mesj));
        Assert.assertTrue(mesj.isDisplayed());

        yazinin gorunur olmasini beklerken yazinin locate ini kullanmak
        sorun olusturur. Cunki henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmaya bilir
        (Html codelari yazan developer farkli uygulamalar yapabilir)
        Bu durumda bekleme islemi ve locate i birlikte yapmaliyiz
        */
        WebElement mesj=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(mesj.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //7. It’s back mesajinin gorundugunu test edin

        WebElement mesjj=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(mesjj.isDisplayed());
    }
}
