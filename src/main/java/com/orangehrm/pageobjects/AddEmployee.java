package com.orangehrm.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.commons.CommonObjects;

public class AddEmployee extends CommonObjects {
	
	@FindBy(xpath = "//div[@id='content']//h1[text()='Add Employee']")
	WebElement addEmpLabel;

	@FindBy(id = "firstName")
	WebElement fName;

	@FindBy(id = "lastName")
	WebElement lName;

	@FindBy(id = "btnSave")
	WebElement btnSave;

	@FindBy(id = "employeeId")
	WebElement empId;

	public AddEmployee() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyAddEmployeeLabel() {
		return addEmpLabel.isDisplayed();
	}

	public PersonalDetails addEmployeeWithoutPhoto(String firstName, String lastName) {
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);		
		btnSave.click();
		return new PersonalDetails();
	}
	
}
