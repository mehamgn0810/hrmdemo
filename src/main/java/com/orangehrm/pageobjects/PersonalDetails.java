package com.orangehrm.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.commons.CommonObjects;

public class PersonalDetails extends CommonObjects{
	
	@FindBy(xpath = "//div[@id='pdMainContainer']//h1[text()='Personal Details']")
	WebElement pDetailsHeader;
	
	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	WebElement profileName;
	
	public PersonalDetails() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyPersonalDetailsPage() {
		return pDetailsHeader.isDisplayed();
	}
	
	public String verifyProfileName() {
		return profileName.getText();
	}
}
