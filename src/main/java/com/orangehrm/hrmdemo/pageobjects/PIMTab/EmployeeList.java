package com.orangehrm.hrmdemo.pageobjects.PIMTab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.hrmdemo.base.BaseClass;

public class EmployeeList extends BaseClass{
	
	@FindBy(xpath = "//*[@id='employee-information']//h1[text()='Employee Information']")
	WebElement empInfoLabel;
	
	public EmployeeList() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyEmployeeInformationLabelr() {
		return empInfoLabel.isDisplayed();
	}
	
}
