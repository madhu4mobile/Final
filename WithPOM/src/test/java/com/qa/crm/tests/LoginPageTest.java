package com.qa.crm.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;

import java.util.Properties;

import org.openqa.selenium.WebDriver;


import com.qa.crm.base.PageBase;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.MyConstants;


public class LoginPageTest { // This is a testNg class for test cases on LoginPage

	//0. global vairablels initialization
	//1. setup -- call Browser init method for both Browser and Properties, get url
	//2. create test cases for automation tests.
	//3. TearDown  -- close the browser
	
	//Globals
	public PageBase myPage; // we have to call the non static method from PageBase class.
	public WebDriver driver; // load driver
	public Properties prop; // initiate prop which loads cofig.properites file
	public LoginPage loginPageRef; // connects to the page
	
	
	
	@BeforeMethod
	//1. to start the test
	public void start() {// init the driver, page so that we can use them further in this test
		//1. call PageBase
		myPage = new PageBase();
		//2. call browserInit() method now and get driver obj ref from there.
		driver = myPage.browserInit();  // Initiate in the global level for this class above and assign it to ref var driver
		// the above statement launches browser, clears cookies, maximizes and  and enters URL
		prop = myPage.InitProperties(); // Initiate in the global level for this class above and assign it to ref var prop 	
		//the above statement just gets the properties.
		loginPageRef = new LoginPage(driver);  // this has to call the login method from LoginPage //// all initializations have to be done in this method
		driver.get(prop.getProperty("url")); // to type the url taken from prop --> config.properties
	}
	
	@Test(priority = 1)
	public void LoginTitleTest() {
		String ActualTitle = loginPageRef.getPageTitle();
		System.out.println("The Login Page title is :"+ActualTitle);
		AssertJUnit.assertEquals(MyConstants.LOGIN_PAGE_TITLE.trim(), ActualTitle.trim());
	}
	
	@Test(priority = 2)
	//2. to write all test cases
	public String loginTest() throws InterruptedException {// when ever we call object, the constructor will be called. So we have to pass the parameter 'driver' as said in constructor
		loginPageRef.login(prop.getProperty("username"), prop.getProperty("password"));  // called the method from LoginPage class. It will enter the username and pwd from Properties and clicks on login button.
		Thread.sleep(3000);
		return loginPageRef.getPageTitle();
	}
	@Test(priority = 3)
	//2b. to check the page title after login
	public void titleAfterLoginTest() throws InterruptedException {
		String titleAfterLogin = loginTest();   // from retrned title value at the end of loginTest.
		System.out.println("Page title after login is :"+titleAfterLogin);
		AssertJUnit.assertEquals(MyConstants.HOME_PAGE_TITLE.trim(), titleAfterLogin.trim());
	}
	
	@AfterMethod
	//3. Teardown
	public void tearDown() {
		driver.quit(); 
	}
}
