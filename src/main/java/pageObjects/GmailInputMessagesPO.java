package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ChromeDriverSingleton;

public class GmailInputMessagesPO {

    @FindBy(xpath = "//*[@id=\":6g\"]/div/div")
    private WebElement sentButton;

    public GmailInputMessagesPO() {
        PageFactory.initElements(ChromeDriverSingleton.getDriver(), this);
    }

    public boolean checkLogin() {
        if (sentButton.isEnabled()||sentButton.isDisplayed())return true;
       else return false;
    }
}
