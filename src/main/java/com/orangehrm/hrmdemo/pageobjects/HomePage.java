package com.orangehrm.hrmdemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.hrmdemo.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//div[@id='branding']//img")
	private WebElement hrmLogo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogoDisplayed() {
		return hrmLogo.isDisplayed();
	}

}
