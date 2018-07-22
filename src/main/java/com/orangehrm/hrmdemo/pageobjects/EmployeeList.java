package com.orangehrm.hrmdemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.hrmdemo.base.BaseClass;

public class EmployeeList extends BaseClass{
	
	@FindBy(xpath = "//*[@id='employee-information']//h1[text()='Employee Information']")
	WebElement empInfoLabel;

	@FindBy(id = "empsearch_employee_name_empName")
	WebElement empName;

	@FindBy(id = "searchBtn")
	WebElement searchBtn;
	
	public EmployeeList() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyEmployeeInformationLabel() {
		return empInfoLabel.isDisplayed();
	}

	public void searchEmployeebyName(String employeeName) {
		empName.sendKeys(employeeName);
		searchBtn.click();
	}

	public boolean isEmployeeDisplayed(String employeeName) {
		try {
			boolean status = driver.findElement(By.xpath("//table[@id='resultTable']//td[3]//a[contains(text(),'" 
		+ employeeName + "')]")).isDisplayed();
			return status;
		}catch (NoSuchElementException e) {
			return false;
		}
	}
}
