package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, LoginPage.class);
		
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public HomePage LoginWithCredentials(String Un, String pwd) {
		username.sendKeys(Un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
}
