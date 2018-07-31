package com.orangehrm.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;
import com.orangehrm.commons.LeaveCommons;

public class LeaveList extends BaseClass{
	
	LeaveCommons lCommons;
	
	public LeaveList() {
		PageFactory.initElements(driver, this);
		lCommons = new LeaveCommons();
	}
	
	public AssignLeave clickAssignLeave() {
		lCommons.assignLeave.click();
		return new AssignLeave();
	}

	public AddLeaveEntitlements clickAddEntitlements() {
		return lCommons.clickAddEntitlements();
	}
}
