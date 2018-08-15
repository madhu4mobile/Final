package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageBase {
	//Class variables
	public static WebDriver driver ;  // as the driver objRef is done at global level, It can be accessed anywhere.
	public static Properties prop ;   // same with prop objRef;
	//String myBrowser = prop.getProperty("browser");
	//Initialization of driver and use the bowser init steps
	//public void browserInit() {
	public WebDriver browserInit() {
		//Condition to chose browser from properties.
		//System.setProperty("webdriver.chrome.driver", "c:\\selDrivers\\chromedriver.exe"); //HardCoded
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\drivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		//System.out.println("Browser defined :"+myBrowser);
		
//		if(prop.getProperty("browser")=="chrome") {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\drivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//		} else if (prop.getProperty("browser")=="firefox") {
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\drivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
		
		
//		if(myBrowser=="chrome") {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\drivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//		} else if (myBrowser=="firefox") {
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\drivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://www.freecrm.com/index.html");
		
		return driver;  // after retrun, the access modifier should be WebDriver instead of Void.
		// This way, the driver objRef can be used in Other classes/Child classes.
	}
	
	
	public Properties InitProperties() { // To initialize Properties values.
		
		prop = new Properties();  // reference to Properties file.
		
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
			prop.load(ip); // it is going to 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;  // This way the prop objRef can be used in Other/child classes
	}
	
	
}
