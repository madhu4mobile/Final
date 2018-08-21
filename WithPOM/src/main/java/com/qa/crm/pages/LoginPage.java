package com.qa.crm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.PageBase;
import com.qa.crm.util.JsLib;


public class LoginPage extends PageBase{  // This gets WebDriver ref and Properies ref from PageBase Class

	// all WebDriver elements webElements and Features -  in the form of - (methods) for Login page should be defined.
	
	//WebElemets and features can be intiated by PageFactory @FindBy
	
	//PageFactory WebElements:
	//To locate the elements
	@FindBy(name="username")    // for username textbox
	WebElement username;
	
	@FindBy(name="password")   // for password text box
	WebElement password; 
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']") // for loginBtn due to the popUp window.
	WebElement loginBtn;
		
	//To initialize the elements in the LoginPage
	public LoginPage(WebDriver driver) {  // constructor of Login page where the driver has to be passed.
		this.driver = driver;
		//PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this); // it is equivalent to the above comment statement
		//  This is the initialization to use the elements available in the LoginPage main class.
	}
	//To add the features.
	public void login(String uName, String pwd) {
		JsLib.drawBorder(username, driver);// to draw a boarder at username
		username.sendKeys(uName);
		JsLib.drawBorder(password, driver);// to draw a boarder at password
		password.sendKeys(pwd);
		
		//For the login button, we need to use JavaScriptExecuter class in selenium
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click", loginBtn);
		JsLib.flash(loginBtn, driver); // to draw boarder around the login page
		JsLib.clickElementByJS(loginBtn, driver);  // instead of JavascriptExecutor hardcoded, we can use the JsLib
		
		//loginBtn.click();
//		JavascriptExecutor js = (JavascriptExecutor)SeleniumDriver.getDriver();
//		js.executeScript("argument[0].click()",crmloginpageActions.ClickLogin());
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}

