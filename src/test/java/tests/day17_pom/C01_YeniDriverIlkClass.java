package tests.day17_pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass {

    @Test(groups = "grup1")
    public void test01() {
        Driver.getDriver().get("https://amazon.com");

        /*
        Bugune kadar TestBase classina extend edere kullandigimiz driver yerine
        bundan sonra Driver clasindan kullanacagimiz getDriver static methodunu
        kullanacagiz.

        Driver.getDriver() methodu    in
        driver                        out
         */
        Driver.closeDriver();

        Driver.getDriver().get("https://bestbuy.com");
        Driver.getDriver().get("https://facebook.com");

        Driver.closeDriver();

    }
}
