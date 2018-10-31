package com.orangehrm.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.base.BaseClass;

public class UtilityMethods extends BaseClass{
	
	private static Actions actions;
	private static Select select;
	private static JavascriptExecutor jsExecutor;
	
	public static void moveToElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();	
	}
	
	public static void selectDropDownValueByVisibleText(WebElement selectElement, String value) {
		select = new Select(selectElement);
		select.selectByVisibleText(value);
	}
	
	public static void clickOnElement(WebElement element) {
		jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}
	

}
