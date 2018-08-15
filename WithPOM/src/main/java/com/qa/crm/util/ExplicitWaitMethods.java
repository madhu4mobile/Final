package com.qa.crm.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitMethods {
	
	public static void ClickFoundElement(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).// Used for buttons, radio, checkBoxes etc
		until(ExpectedConditions.elementToBeClickable(element));// checks if given element is clickable or not.
		element.click();
	}
	
	public static void WaitForElementVisibility(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).// Used for buttons, radio, checkBoxes etc
		until(ExpectedConditions.visibilityOf(element));// checks if given element is clickable or not.
		element.click();
	}
	
	public void TypeText(WebDriver driver, WebElement element, int timeout, String TextToType) {
		new WebDriverWait(driver, timeout).  // Used for Text Boxes, 
		until(ExpectedConditions.visibilityOf(element));// checks if given element is visible to enter text.
		element.sendKeys(TextToType);  
	}
	public static String ReadText(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).  // Used for any element has a text on it 
		until(ExpectedConditions.visibilityOf(element));// checks if given element is visible to read text from it.
		return element.getText();  
	}

//	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
//		element.click();
//	}
//	
//	public static void typeText(WebDriver driver, WebElement element, int timeout, String value) {
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
//		element.sendKeys(value);
//	}
//
//	public static String getText(WebDriver driver, WebElement element, int timeout) {
//		String text = " ";
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.textToBePresentInElementValue(element, text));
//		text = element.getText();
//		return text;
//	} 
//	
//	public static String getElementText(WebDriver driver, WebElement element, int timeout) {
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
//		return element.getText();
//		}
}
