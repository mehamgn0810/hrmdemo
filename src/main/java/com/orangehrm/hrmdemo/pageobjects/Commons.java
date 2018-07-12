package com.orangehrm.hrmdemo.pageobjects;

import org.openqa.selenium.By;

import com.orangehrm.hrmdemo.base.BaseClass;

public class Commons extends BaseClass{
	
	public static boolean isCurrentTab(String tabName) {
		boolean status = driver.findElement(By.xpath("//div[@id='wrapper']//b[contains(text(),'" + tabName + "')]"
				+ "//parent::a//parent::li[@class='current']")).isDisplayed();
		return status;
	}

}
