package com.mechsearth.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePage extends AbstractPage {
	
	@FindBy(id = "menu-item-414")
	private ExtendedWebElement entranceButton;

	public HomePage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://new.mechs.su/");
	}
	public LoginPage clickEntranceButton() {
		
		entranceButton.click();
		return new LoginPage(getDriver());
		
	}

}
