package tests.day22_CrossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentCar;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {
	BlueRentCar brc = new BlueRentCar();

	@DataProvider
	public static Object[][] kullaniciListesi() {
		Object [][] kullaniciBilgileri={{"firuze@nehaber.com","54678"},{"babanaber@haco.com","545454"},
				{"lanapan@havi.com","45451436"}};

		return kullaniciBilgileri;
	}


	@Test(dataProvider = "kullaniciListesi")
	public void yanlisSifre(String userEmail,String passWord) {
		brc = new BlueRentCar();
		// Bir test method olustur positiveLoginTest()
		//   https://www.bluerentalcars.com/ adresine git
		Driver.getDriver().get(ConfigReader.getProperty("brc"));


		// login butonuna bas
		brc.ilklogin.click();

		//test data user email: dataProvider dan alalim,
		brc.emailTextBox.sendKeys(userEmail);

		//test data password : dataProvider dan alalim
		brc.passwordTextBox.sendKeys(passWord);
		brc.ikinciLoginButonu.click();

		//Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
		//login butonunungorulmesinden yapabiliriz
		Assert.assertTrue(brc.ikinciLoginButonu.isDisplayed());
		Driver.closeDriver();

	}





}
