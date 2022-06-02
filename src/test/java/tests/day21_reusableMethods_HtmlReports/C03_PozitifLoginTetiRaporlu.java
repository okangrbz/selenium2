package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentCar;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PozitifLoginTetiRaporlu extends TestBaseRapor {

	BlueRentCar brc = new BlueRentCar();

	@Test
	public void positiveLoginTest() {

		extentTest=extentReports.createTest("Pozitif Login","Gecerli User Name ve Sifre ile giris yapabilmeli");

		// Bir test method olustur positiveLoginTest()
		//   https://www.bluerentalcars.com/ adresine git
		Driver.getDriver().get(ConfigReader.getProperty("brc"));
		extentTest.info("Brc anasayfaya gidildi");


		// login butonuna bas
		brc.ilklogin.click();
		extentTest.info("Ilk login Butonuna tiklandi");

		//test data user email: customer@bluerentalcars.com ,
		brc.emailTextBox.sendKeys(ConfigReader.getProperty("brclogin"));

		extentTest.info("email adresi girildi");

		//test data password : 12345
		brc.passwordTextBox.sendKeys(ConfigReader.getProperty("brcpass"));
		extentTest.info("gecerli pass girildi");
		brc.ikinciLoginButonu.click();
		extentTest.info("ikinci login butonuna basildi");

		//Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

		String actualUsername = brc.kullaniciProfilIsmi.getText();
		String expectedUserName = ConfigReader.getProperty("brcValidUsername");
		Assert.assertEquals(actualUsername, expectedUserName);
		extentTest.pass("kullanici basarili sekilde giris yapti");


		Driver.closeDriver();


	}
}
