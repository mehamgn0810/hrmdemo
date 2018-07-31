package com.orangehrm.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;

public class LeaveEntitlements extends BaseClass{
	
	@FindBy(xpath="//div[@class='message success fadable'][contains(text(),'Successfully Assigned')]")
	WebElement addSuccessMessage;
	
	public LeaveEntitlements() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifySuccessfullyAssignedMessage() {
		try {
			boolean status = addSuccessMessage.isDisplayed();
			return status;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
