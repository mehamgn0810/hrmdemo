package com.orangehrm.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.base.BaseClass;

public class UtilityMethods extends BaseClass{
	
	private static Actions actions;
	private static Select select;
	
	public static void moveToElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element);	
	}
	
	public static void selectDropDownValueByVisibleText(WebElement selectElement, String value) {
		select = new Select(selectElement);
		select.selectByVisibleText(value);
	}

}
