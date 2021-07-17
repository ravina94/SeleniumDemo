package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.utilility.TestUtility;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	

 public TestBase() {
	 try {
		 prop = new Properties(); 
		 FileInputStream ip = new FileInputStream("C:\\Users\\ravina.rani\\eclipse-workspace\\FreeCRMTest\\src\\"
		 		+ "main\\java\\com\\crm\\qa\\confg\\config.properties");
		 prop.load(ip);
	 }catch(FileNotFoundException e) {
		 e.printStackTrace();
	 }catch(IOException e) {
		 e.printStackTrace();
	 }
}
 public void initialization() {
	String BrowserName = prop.getProperty("browser");
	if(BrowserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravina.rani\\eclipse-workspace\\chromedriver.exe");
		driver= new ChromeDriver();
		}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtility.Page_Load_TimeOut, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtility.Implicit_Wait,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	

 }
 }
