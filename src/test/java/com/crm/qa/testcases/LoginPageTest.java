package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest  extends TestBase{
	LoginPage lgnPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		lgnPage = new LoginPage();
		
	}
	@Test(priority=1)
	public void LoginPageTitle() {
		 String Title = lgnPage.getPageTitle();
		 if(Title.equalsIgnoreCase(prop.getProperty("LoginTitle"))) {
			 System.out.println("Title of the page is " + Title);
		 }
	}
	@Test(priority=2)
	public void LoginCredentialsTest() {
		homePage = lgnPage.LoginWithCredentials(prop.getProperty("username") , prop.getProperty("Password"));
		{
			
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
