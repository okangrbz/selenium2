package tests.day21_reusableMethods_HtmlReports;

import com.aventstack.extentreports.reporter.ExtentBDDReporter;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.io.IOException;

public class C02_ScreeanShotReusbleMethod {
	@Test
	public void test01()  {
		//amazon sayfasina gidip fotorafini cekelim

		Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
		ReusableMethod.getScreenshot("ama");


		Driver.closeDriver();




	}



}
