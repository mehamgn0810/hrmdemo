package com.orangehrm.hrmdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.hrmdemo.base.BaseClass;

public class PersonalDetails extends BaseClass{
	
	@FindBy(xpath = "//div[@id='pdMainContainer']//h1[text()='Personal Details']")
	WebElement pDetailsHeader;
	
	public PersonalDetails() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyPersonalDetailsPage() {
		return pDetailsHeader.isDisplayed();
	}
}
