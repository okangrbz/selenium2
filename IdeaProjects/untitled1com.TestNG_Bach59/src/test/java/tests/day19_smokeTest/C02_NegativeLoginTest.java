package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentCar;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegativeLoginTest {
	BlueRentCar brc = new BlueRentCar();
	@Test
	public void yanlisSifre() {

		// Bir test method olustur positiveLoginTest()
		//   https://www.bluerentalcars.com/ adresine git
		Driver.getDriver().get(ConfigReader.getProperty("brc"));


		// login butonuna bas
		brc.ilklogin.click();

		//test data user email: customer@bluerentalcars.com ,
		brc.emailTextBox.sendKeys(ConfigReader.getProperty("brclogin"));

		//test data password : 54321
		brc.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongpass"));
		brc.ikinciLoginButonu.click();

		//Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
		//login butonunungorulmesinden yapabiliriz
		Assert.assertTrue(brc.ikinciLoginButonu.isDisplayed());

		Driver.closeDriver();

		//bu class da iki test meth daha olusuturun
		//1-yanlis kullanici
		//2-yanlis sifre ve kullanici adi




	}
}
