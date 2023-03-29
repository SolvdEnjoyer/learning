package carinaimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.mechsearth.gui.pages.HomePage;
import com.mechsearth.gui.pages.LoginPage;
import com.mechsearth.gui.pages.ProfilePage;
import com.qaprosoft.carina.core.foundation.AbstractTest;

public class LoginTest extends AbstractTest{
	
	public static final Logger LOGGER = LogManager.getLogger(LoginPage.class);
	@Test
	public void loginTest() throws InterruptedException {
		HomePage homePage = new HomePage(getDriver());
		homePage.openURL("https://new.mechs.su/");
		LoginPage loginPage = homePage.clickEntranceButton();
		loginPage.typeUserName("rural@inbox.ru");
		loginPage.typePassword("ilia--112003");
		homePage = loginPage.cliclkAuthorizeButton();
		ProfilePage pfp = homePage.clickProfileButton();
		loginPage = pfp.clickBodyLogOutButton();
		loginPage.typeUserName("rural@inbox.ru");
		loginPage.typePassword("ilia--112003");
		
		Thread.sleep(4000);
	}
}
