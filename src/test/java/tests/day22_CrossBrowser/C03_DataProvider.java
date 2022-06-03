package tests.day22_CrossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


	@Test
	public void test01() {
		AmazonPage amazon = new AmazonPage();
		//amazon anasayfaya gidelim
		//nutella icin arama yapalim
		//sonuclarin nutella icerdigini test edelim

		Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
		amazon.aramakutusu.sendKeys("Nutella" + Keys.ENTER);
		String expected = "Nutella";
		String actual = amazon.aramaSonucElementi.getText();

		Assert.assertTrue(actual.contains(expected));
		Driver.closeDriver();

	}

	@Test(dataProvider = "AranacakKelimeler")
	//arayacagimiz kelimeleri bir liste gibi tutup
	//bana yollayacak  bir veri saglayicisi olusutracagiz
	public void dataProviderTesti(String arananKelime) {
		AmazonPage amazon = new AmazonPage();
		//amazon anasayfaya gidelim
		Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

		//nutella, java, cigdem, ve Netherlands icin arama yapalim
		amazon.aramakutusu.sendKeys(arananKelime + Keys.ENTER);

		//sonuclarin aradigimiz kelime icerdigini test edelim
		String expected = arananKelime;
		String actual = amazon.aramaSonucElementi.getText();
		Assert.assertTrue(actual.contains(expected));
		Driver.closeDriver();

	}


	@DataProvider
	public static Object[][] AranacakKelimeler() {

		Object[][] aranankelimeKelimeArray = {{"Nutella"}, {"java"}, {"cigdem"}, {"Netherlands"}};

		return aranankelimeKelimeArray;
	}

}
