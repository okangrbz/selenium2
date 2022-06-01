package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentCar;
import utilities.ConfigReader;
import utilities.Driver;

//https://www.bluerentalcars.com/
//customer@bluerentalcars.com
public class C01_PositifLoginTest {

	BlueRentCar brc = new BlueRentCar();

	@Test
	public void positiveLoginTest() {

		// Bir test method olustur positiveLoginTest()
		//   https://www.bluerentalcars.com/ adresine git
		Driver.getDriver().get(ConfigReader.getProperty("brc"));


		// login butonuna bas
		brc.ilklogin.click();

		//test data user email: customer@bluerentalcars.com ,
		brc.emailTextBox.sendKeys(ConfigReader.getProperty("brclogin"));

		//test data password : 12345
		brc.passwordTextBox.sendKeys(ConfigReader.getProperty("brcpass"));
		brc.ikinciLoginButonu.click();

		//Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

		String actualUsername = brc.kullaniciProfilIsmi.getText();
		String expectedUserName = ConfigReader.getProperty("brcValidUsername");
		Assert.assertEquals(actualUsername, expectedUserName);


		Driver.closeDriver();


	}
}
