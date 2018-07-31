package com.orangehrm.commons;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pageobjects.AddLeaveEntitlements;
import com.orangehrm.util.UtilityMethods;
import com.orangehrm.util.Wait;

public class LeaveCommons extends BaseClass{
	
	@FindBy(xpath = "//li[@class='selected']//a")
	WebElement selectedTab;
	
	@FindBy(id="menu_leave_Entitlements")
	WebElement entitlements;
	
	@FindBy(id="menu_leave_addLeaveEntitlement")
	WebElement addEntitlements;
	
	@FindBy(id="menu_leave_assignLeave")
	public WebElement assignLeave;
	
	public LeaveCommons() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isSelectedSubTab(String subTabName) {
		String activeTab = selectedTab.getText();
		if (activeTab.equals(subTabName)) {
			return true;
		}else {
			return false;
		}
	}
	
	public AddLeaveEntitlements clickAddEntitlements() {
		UtilityMethods.moveToElement(entitlements);
		Wait.waitForElement(3, addEntitlements);
		addEntitlements.click();
		return new AddLeaveEntitlements();
	}
	

}
