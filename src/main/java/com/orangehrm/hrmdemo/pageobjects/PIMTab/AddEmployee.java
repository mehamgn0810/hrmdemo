package com.orangehrm.hrmdemo.pageobjects.PIMTab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.hrmdemo.base.BaseClass;

public class AddEmployee extends BaseClass {
	
	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement header;

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
	
	public boolean verifyAddEmployeePage() {
		return header.isDisplayed();
	}

	public PersonalDetails addEmployeeWithoutPhoto(String firstName, String lastName) {
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);		
		btnSave.click();
		return new PersonalDetails();
	}
	
	

}
