package com.orangehrm.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.commons.CommonObjects;

public class AddEmployee extends CommonObjects {

	@FindBy(xpath = "//div[@id='content']//h1[text()='Add Employee']")
	WebElement addEmpLabel;

	@FindBy(id = "firstName")
	WebElement fName;

	@FindBy(id = "lastName")
	WebElement lName;

	@FindBy(id = "employeeId")
	WebElement empId;

	@FindBy(id = "chkLogin")
	WebElement createLoginCheckBox;

	@FindBy(id = "user_name")
	WebElement uName;

	@FindBy(id = "user_password")
	WebElement userPassword;

	@FindBy(id = "re_password")
	WebElement userRePassword;

	@FindBy(id = "status")
	WebElement statusDropDown;
	
	@FindBy(id="btnSave")
	WebElement saveButton;

	public AddEmployee() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAddEmployeeLabel() {
		return addEmpLabel.isDisplayed();
	}
	
	public void enterFirstName(String firstName) {
		fName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lName.sendKeys(lastName);
	}

	public PersonalDetails addEmployeeWithoutPhoto(String firstName, String lastName) {
		enterFirstName(firstName);
		enterLastName(lastName);
		clickSaveButton();
		return new PersonalDetails();
	}

	public void clickCreateLoginCheckBox() {
		createLoginCheckBox.click();
	}

	public void enterUserName(String userName) {
		uName.sendKeys(userName);
	}

	public void enterUserPassword(String password) {
		userPassword.sendKeys(password);
	}

	public void enterRePassword(String rePassword) {
		userRePassword.sendKeys(rePassword);
	}

	public boolean verifySelectedStatus(String status) {
		boolean flag = false;
		Select select = new Select(statusDropDown);
		List<WebElement> options = select.getOptions();
		for (WebElement element : options) {
			System.out.println(element.getText());
			System.out.println(element.getAttribute("selected"));
			if (element.getText().equals(status) && element.getAttribute("selected").equals("true")) {
					flag = true;
					break;
			}
		}
		return flag;
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}

}
