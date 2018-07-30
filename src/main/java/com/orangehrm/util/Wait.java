package com.orangehrm.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.base.BaseClass;

public class Wait extends BaseClass{
	
	public static WebElement waitForElement(int timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement xElement = wait.until(ExpectedConditions.visibilityOf(element));
		return xElement;
	}

}
