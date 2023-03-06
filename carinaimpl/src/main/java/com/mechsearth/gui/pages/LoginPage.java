package com.mechsearth.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class LoginPage extends AbstractPage{
	
	@FindBy(xpath = "//input[@name = 'username']")
	private ExtendedWebElement userNameInput;
	
	@FindBy(xpath = "//input[@name = 'password']")
	private ExtendedWebElement passwordInput;
	
	@FindBy(xpath = "//button[@name='login']")
	private ExtendedWebElement authorizeButton;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAuthorizeButtonPresent() {
		return authorizeButton.isElementPresent();
	}
	
	public void typeUserName(String str) {
		userNameInput.type(str);
	}
	
	public void typePassword(String str) {
		passwordInput.type(str);
	}
	
	public void cliclkAuthorizeButton() {
		authorizeButton.click();
	}
}
