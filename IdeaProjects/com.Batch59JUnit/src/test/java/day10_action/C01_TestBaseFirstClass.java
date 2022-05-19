package day10_action;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class C01_TestBaseFirstClass extends TestBase {

    @Test
    public void test01(){
        driver.get("https://amazon.com");
    }


}
