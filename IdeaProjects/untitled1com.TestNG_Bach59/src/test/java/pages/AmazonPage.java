package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);//PageFactory.initElements() methodu
                                                                // bir class da var olan degeri alir ve this ile eslestitit

    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramakutusu;

    @FindBy(xpath ="//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucElementi;



}
