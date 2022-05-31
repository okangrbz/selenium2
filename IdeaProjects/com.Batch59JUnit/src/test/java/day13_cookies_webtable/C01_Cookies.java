package day13_cookies_webtable;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_Cookies extends TestBase {


            /*
            1- Amazon anasayfaya gidin
2- tum cookie’leri listeleyin
3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
6- eklediginiz cookie’nin sayfaya eklendigini test edin
7- ismi skin olan cookie’yi silin ve silindigini test edin
8- tum cookie’leri silin ve silindigini test edin

             */
    @Test
    public void test01() {
        driver.get("https://amazon.com");
        Set<Cookie> cookies=driver.manage().getCookies();

        System.out.println("cookie sayisi : "+cookies.size());
//2- tum cookie’leri listeleyin
        int cookiesSayi=1;
        for (Cookie each :cookies) {
            System.out.println(cookiesSayi+" inci cookies : "+each);
            System.out.println("name : "+each.getName());
            System.out.println("value : "+each.getValue());
            cookiesSayi++;
        }
//3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookies.size()>5);

        // 4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each :cookies) {

            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
            }

        }

       // 5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin

        Cookie cokkie=new Cookie("en sevdigim cookie","cikolatali");

        driver.manage().addCookie(cokkie);

      cookies=driver.manage().getCookies();

        // 6- eklediginiz cookie’nin sayfaya eklendigini test edin
        cookiesSayi=1;
        for (Cookie each :cookies) {
            System.out.println(cookiesSayi+" inci cookies : "+each);

            cookiesSayi++;

        }
        Assert.assertTrue(cookies.contains(cokkie));


       // 7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("en sevdigim cookie");
        Assert.assertFalse(!cookies.contains(cokkie));
       // 8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        Assert.assertTrue(cookies.isEmpty());





    }
}
