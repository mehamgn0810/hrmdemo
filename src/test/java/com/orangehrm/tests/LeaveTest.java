package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pageobjects.AddLeaveEntitlements;
import com.orangehrm.pageobjects.AssignLeave;
import com.orangehrm.pageobjects.DashboardPage;
import com.orangehrm.pageobjects.LeaveEntitlements;
import com.orangehrm.pageobjects.LeaveList;
import com.orangehrm.pageobjects.LoginPage;

public class LeaveTest extends BaseClass{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AssignLeave assignLeave;
	LeaveList leaveList;
	AddLeaveEntitlements addLeaveEntitlements;
	LeaveEntitlements leaveEntitlements;
	SoftAssert sa;

	@BeforeMethod
	public void BeforeMethod() {
		sa = new SoftAssert();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void addEntitlements() throws InterruptedException {
		leaveList = dashboardPage.clickLeaveTab();
		addLeaveEntitlements = leaveList.clickAddEntitlements();
		addLeaveEntitlements.enterEmployeeName("John Smith");
		addLeaveEntitlements.selectLeaveType("Vacation US");
		addLeaveEntitlements.enterEntitlementDays("3");
		addLeaveEntitlements.clickSaveButton();
		leaveEntitlements = addLeaveEntitlements.clickConfirmButton();
		Assert.assertTrue(leaveEntitlements.verifySuccessfullyAssignedMessage(), "Successfully Assigned message not displayed");
	}

	@Test(dependsOnMethods="addEntitlements", enabled = false)
	public void AssignLeave() throws InterruptedException {
		assignLeave = dashboardPage.clickAssignLeave();
		assignLeave.enterEmployeeName("John Smith");
		assignLeave.selectLeaveType("Vacation US");
		sa.assertTrue((assignLeave.verifyLeaveBalance()>0), "Leave Balance is less than or equal to zero");
		assignLeave.selectFromDate("13");
		assignLeave.selectToDate("13");
		assignLeave.clickAssignButton();
		assignLeave.clickConfirmOkButton();
		sa.assertTrue(assignLeave.verifySuccessfullyAssignedMessage(),
				"Successfully Assigned Message not displayed");
		sa.assertAll();
	}
}
