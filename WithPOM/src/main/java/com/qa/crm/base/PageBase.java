package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.crm.util.MyConstants;

public class PageBase {
	private static final String HtmlUnitDriver = null;
	//Class variables
	public static WebDriver driver ;  // as the driver objRef is done at global level, It can be accessed anywhere.
	public static Properties prop ;   // same with prop objRef;
	//String myBrowser = prop.getProperty("browser");
	//Initialization of driver and use the bowser init steps
	//public void browserInit() {
	public WebDriver browserInit() {
		//Condition to chose browser from properties.
		//System.setProperty("webdriver.chrome.driver", "c:\\selDrivers\\chromedriver.exe"); //HardCoded
		prop = InitProperties(); // this is to get the browser from the properties. Prop need to be initiated.
		//If that has to be used from any other page, it should be done as prop = PageBase.InitProperties();
		String myBrowser = prop.getProperty("browser");
				
		if(myBrowser.equals("chrome")) {  	// the condition myBrowser == "Chrome" does not work.
			System.out.println("Browser Defined is : "+myBrowser);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (myBrowser.equals("firefox")) {
			System.out.println("Browser Defined is : "+myBrowser);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (myBrowser.equals("headlessChrome")) {
			System.out.println("Browser Defined is : "+myBrowser);
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(co);
		} 
//		else if (myBrowser.equals("headlessHtmlUnit")) {
//			System.out.println("Browser Defined is : "+myBrowser);
//			driver = new HtmlUnitDriver();
//			HtmlUnitDriver driver = new HtmlUnitDriver();		}
		
		
		driver.manage().timeouts().pageLoadTimeout(MyConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
		
		return driver;  // after return, the access modifier should be WebDriver instead of Void.
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
