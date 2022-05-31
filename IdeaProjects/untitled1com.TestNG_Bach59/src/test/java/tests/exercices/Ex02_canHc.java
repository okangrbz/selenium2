package tests.exercices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class Ex02_canHc {

	//http://demo.guru99.com/test/drag_drop.html url e git
	//    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
	//    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
	//    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
	//    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
	//    Perfect butonun goruntulendigini dogrulayin


	@Test
	public void test01() {
		Driver.getDriver().get("http://demo.guru99.com/test/drag_drop.html");
		//http://demo.guru99.com/test/drag_drop.html url e git



		Driver.getDriver().findElement(By.xpath("(//p[@class='fc-button-label'])[2]")).click();//cookie not


		Actions action=new Actions(Driver.getDriver());
		WebElement acount=Driver.getDriver().findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		WebElement banq=Driver.getDriver().findElement(By.xpath("//li[@data-id='5']"));
		action.dragAndDrop(acount,banq);

		//    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
		//    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
		//    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
		//    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
		//    Perfect butonun goruntulendigini dogrulayin


	}
}
