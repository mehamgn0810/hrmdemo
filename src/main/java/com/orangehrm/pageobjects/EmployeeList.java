package com.orangehrm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.commons.CommonObjects;
import com.orangehrm.commons.PIMCommons;

public class EmployeeList extends CommonObjects {

	PIMCommons pimCommons;

	@FindBy(xpath = "//*[@id='employee-information']//h1[text()='Employee Information']")
	WebElement empInfoLabel;

	@FindBy(id = "empsearch_employee_name_empName")
	WebElement empName;

	@FindBy(id = "searchBtn")
	WebElement searchBtn;

	@FindBy(id = "btnDelete")
	WebElement deleteBtn;

	@FindBy(id = "dialogDeleteBtn")
	WebElement okDeleteBtn;

	@FindBy(xpath = "//div[@class='message success fadable'][contains(text(),'Successfully Deleted')]")
	WebElement deleteSuccessMessage;

	public EmployeeList() {
		PageFactory.initElements(driver, this);
		pimCommons = new PIMCommons();
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
			boolean status = driver
					.findElement(
							By.xpath("//table[@id='resultTable']//td[3]//a[contains(text(),'" + employeeName + "')]"))
					.isDisplayed();
			return status;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public AddEmployee clickAddEmployeeLink() {
		pimCommons.clickaddEmployeeLink();
		return new AddEmployee();
	}

	public void selectEmployeebyFirstName(String employeeName) {
		driver.findElement(By.xpath("//a[contains(text(),'" + employeeName
				+ "')]//parent::td//preceding-sibling::td//input[@type='checkbox']")).click();
	}

	public void deleteSelectedRecords() {
		deleteBtn.click();
		okDeleteBtn.click();
	}

	public boolean verifySuccessfullyDeletedMessage() {
		try {
			boolean status = deleteSuccessMessage.isDisplayed();
			return status;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
