package day10_action;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_Actions extends TestBase {
    /*
    Yeni bir class olusturalim: MouseActions2
1- https://demoqa.com/droppable adresine gidelim
2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

     */

    @Test
    public void test01(){


        //1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions action=new Actions(driver);
        WebElement dragme=driver.findElement(By.xpath("(//div[@style='position: relative;'])[1]"));
        WebElement drob=driver.findElement(By.xpath("//div[@class='drop-box ui-droppable']"));
        action.dragAndDrop(dragme,drob).perform();



        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement yazi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectetstr="Dropped!";
        String actualstr=yazi.getText();
        Assert.assertEquals(actualstr,expectetstr);
    }
}
