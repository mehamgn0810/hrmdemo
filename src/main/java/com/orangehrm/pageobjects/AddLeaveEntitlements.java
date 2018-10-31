package com.orangehrm.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;
import com.orangehrm.util.UtilityMethods;
import com.orangehrm.util.Wait;

public class AddLeaveEntitlements extends BaseClass{

	@FindBy(xpath="//input[@id='entitlements_employee_empName'][@class!='ac_loading']")
	WebElement empName;
	
	@FindBy(id="entitlements_leave_type")
	WebElement leaveTypeDropDown;
	
	@FindBy(id="entitlements_entitlement")
	WebElement entitlementDays;
	
	@FindBy(id="btnSave")
	WebElement saveButton;
	
	@FindBy(id="dialogUpdateEntitlementConfirmBtn")
	WebElement confirmButton;
	
	public AddLeaveEntitlements() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmployeeName(String employeeName) {
		empName.sendKeys(employeeName);
		empName.sendKeys(Keys.TAB);
	}
	
	public void selectLeaveType(String leaveType) {
		UtilityMethods.selectDropDownValueByVisibleText(leaveTypeDropDown, leaveType);
	}
	
	public void enterEntitlementDays(String numberOfDays) {
		entitlementDays.sendKeys(numberOfDays);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public LeaveEntitlements clickConfirmButton() {
		Wait.waitForElement(3, confirmButton).click();
		return new LeaveEntitlements();
	}
}
