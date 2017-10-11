import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.GmailLoginPO;
import utils.ChromeDriverSingleton;
import utils.PropertiesParser;
import utils.TestNGListener;

//@Listeners({TestNGListener.class})
public class GmailTest {
    private static final Logger LOGGER = Logger.getLogger(GmailTest.class.getName());

@Test(dataProviderClass = DataProvider.class, dataProvider = "getData")
    public void gmailTest(String email, String password) throws Exception{

        //Get start gmail page
        PropertiesParser propertiesParser = new PropertiesParser();
        ChromeDriverSingleton.getDriver().get(propertiesParser.getBaseUrl());

        //Log in
        GmailLoginPO login = new GmailLoginPO();
        login.typeLogin(email);
        login.typePassword(password);
    }

    @AfterMethod
    public void quit() {
        ChromeDriverSingleton.quit();
    }

}
