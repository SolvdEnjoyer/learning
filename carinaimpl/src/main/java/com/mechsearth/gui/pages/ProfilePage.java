package com.mechsearth.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class ProfilePage extends AbstractPage{

	@FindBy(xpath = "//p[@class = 'logged-in-as']/a[contains(text(),'Выйти?')]")
	private ExtendedWebElement BodyLogOutButton;
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public HomePage clickBodyLogOutButton() {
		BodyLogOutButton.click();
		return new HomePage(getDriver());
		
		
	}
	
}
