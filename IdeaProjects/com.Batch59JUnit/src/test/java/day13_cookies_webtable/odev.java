package day13_cookies_webtable;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class odev extends TestBase {
        /*
        Bir Class olusturun D19_WebtablesHomework
  1. “https://demoqa.com/webtables” sayfasina gidin
  2. Headers da bulunan department isimlerini yazdirin
  3. sutunun basligini yazdirin
  4. Tablodaki tum datalari yazdirin
  5. Tabloda kac cell (data) oldugunu yazdirin
  6. Tablodaki satir sayisini yazdirin
  7. Tablodaki sutun sayisini yazdirin
  8. Tablodaki 3.kolonu yazdirin
  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
10. Page sayfasinda bir method olusturun, Test sayfasindan satir
ve sutun sayisini girdigimde bana datayi yazdirsin
         */

    @Test
    public void test01() {
        Actions action = new Actions(driver);

        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //  2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> depatmanlar=driver.
                findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][6]"));
        for (WebElement each :depatmanlar) {
            System.out.println(each.getText()+" , ");

        }


        //  3. sutunun basligini yazdirin
        List<WebElement> satirlar = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));

        List<WebElement> sutunIsmleri = driver.
                findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        for (WebElement each : sutunIsmleri) {
            System.out.println(each.getText() + "\n".strip());

        }

        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tumdatalar=driver.
                findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']"));
        for (WebElement each :tumdatalar) {
            System.out.println(each.getText()+" , ");

        }

        //  5. Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> tumElemanlar=driver.
                findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']"));
        System.out.println("tablonun toplam eleman sayisi : "+ tumElemanlar.size());
        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satir=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("satir sayisi :"+satir.size());
        //  7. Tablodaki sutun sayisini yazdirin
        List<WebElement> sutun=driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("celull sayisi :"+sutun.size());
        //  8. Tablodaki 3.kolonu yazdirin


        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        tumElemanlar=driver.
                findElements(By.xpath("//div[@class='rt-tr-group']"));
        for (int i = 0; i < tumElemanlar.size(); i++) {
            if (tumElemanlar.get(i).getText().equals("Kierra"))
            {
                System.out.println("salariye : "+driver.findElement(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-tr-group']["+i+"]//div[@class='rt-td'][5]")).getText());
            }

        }

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir
        //ve sutun sayisini girdigimde bana datayi yazdirsin





    }

    public WebElement satirstungetir(int satir,int sutun) {
        WebElement eleman= (WebElement) driver.
                findElements(By.xpath("//div[@class='rt-tr-group']["+satir+"]" +
                        "//div[@class='rt-td']["+sutun+"]"));


        return  eleman;
    }
}
