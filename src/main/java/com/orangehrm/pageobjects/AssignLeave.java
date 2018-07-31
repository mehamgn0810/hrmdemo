package com.orangehrm.pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;
import com.orangehrm.util.UtilityMethods;
import com.orangehrm.util.Wait;

public class AssignLeave extends BaseClass {

	@FindBy(xpath = "//input[@id='assignleave_txtEmployee_empName']")
	WebElement empName;

	@FindBy(id = "assignleave_txtLeaveType")
	WebElement leaveTypeDropDown;

	@FindBy(xpath = "//div[@id='assignleave_leaveBalance' and @class!='loading_message']")
	WebElement leaveBalance;

	@FindBy(id = "leaveBalance_details_link")
	WebElement viewDetailsLink;

	@FindBy(xpath = "//input[@id='assignleave_txtFromDate']//following-sibling::img")
	WebElement fromDateCalImg;
	
	@FindBy(id="assignleave_txtFromDate")
	WebElement fromDateTextBox;
	
	@FindBy(id="assignleave_txtToDate")
	WebElement toDateTextBox;

	@FindBy(xpath = "//div[@id='ui-datepicker-div']//table//a")
	List<WebElement> clickableDateList;

	@FindBy(xpath = "//input[@id='assignleave_txtEmployee_empName'][@class='ac_input valid']")
	WebElement validEmployee;

	@FindBy(xpath = "//span[@for='assignleave_txtEmployee_empName']")
	WebElement invalidEmployee;
	
	@FindBy(id="assignBtn")
	WebElement assignBtn;
	
	@FindBy(id="confirmOkButton")
	WebElement confirmOkButton;
	
	@FindBy(xpath="//div[@class='message success fadable'][contains(text(),'Successfully Assigned')]")
	WebElement assignSuccessMessage;

	public AssignLeave() {
		PageFactory.initElements(driver, this);
	}

	public void enterEmployeeName(String employeeName) {
		empName.sendKeys(employeeName);
		empName.sendKeys(Keys.TAB);
		try {
			validEmployee.isDisplayed();
		} catch (NoSuchElementException e) {
			if (invalidEmployee.getText().equals("Invalid")) {
				throw new RuntimeException("Invalid Employee Name");
			}
		}
	}
	

	public void selectLeaveType(String leaveType) {
		UtilityMethods.selectDropDownValueByVisibleText(leaveTypeDropDown, leaveType);
	}

	public double verifyLeaveBalance() {
		String leaveBal = Wait.waitForElement(5, leaveBalance).getText().split("view")[0];
		return Double.parseDouble(leaveBal);
	}

	public void selectFromDate(String fromDate) {
		fromDateTextBox.click();
		for (WebElement element : clickableDateList) {
			if (element.getText().equals(fromDate)) {
				element.click();
			}
		}
	}
	
	public void selectToDate(String toDate) {
		toDateTextBox.click();
		for (WebElement element : clickableDateList) {
			if (element.getText().equals(toDate)) {
				element.click();
			}
		}
	}
	
	public void clickAssignButton() {
		assignBtn.click();
	}
	
	public void clickConfirmOkButton() {
		confirmOkButton.click();
	}
	
	public boolean verifySuccessfullyAssignedMessage() {
		try {
			boolean status = assignSuccessMessage.isDisplayed();
			return status;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
