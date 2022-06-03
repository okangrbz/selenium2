package tests.day21_reusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.Set;

public class C01_WindowHandleReusbleMethod {

	@Test
	public void test01() {

		Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
		String handle=Driver.getDriver().getWindowHandle();

		//clic butonuna bas
		Driver.getDriver().findElement(By.linkText("Click Here")).click();
		Set<String> windowsHendl=Driver.getDriver().getWindowHandles();

		String ikincisayfa="";

		for (String each:windowsHendl) {
			if (!each.equals(handle)){
				ikincisayfa+=each;
			}

		}

		Driver.getDriver().switchTo().window(ikincisayfa);
		System.out.println(Driver.getDriver().getTitle());

		//acilan yeni tabin titre inin new window oldugunu test edin

		String ecxpectedTitre="New Window";
		String actualTitre=Driver.getDriver().getTitle();
		Assert.assertEquals(actualTitre,ecxpectedTitre);


	}

	@Test
	public void test02() {

		Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
		String handle=Driver.getDriver().getWindowHandle();

		//clic butonuna bas
		Driver.getDriver().findElement(By.linkText("Click Here")).click();

		//acilan yeni tabin titre inin new window oldugunu test edin
		ReusableMethod.switchToWindow("New Window");
		String ecxpectedTitre="New Window";
		String actualTitre=Driver.getDriver().getTitle();
		Assert.assertEquals(actualTitre,ecxpectedTitre);

		Driver.closeDriver();

	}
}
