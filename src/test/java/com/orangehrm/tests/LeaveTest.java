package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pageobjects.AssignLeave;
import com.orangehrm.pageobjects.DashboardPage;
import com.orangehrm.pageobjects.LoginPage;

public class LeaveTest extends BaseClass{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AssignLeave assignLeave;

	@BeforeMethod
	public void BeforeMethod() {
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void AssignLeave() {
		assignLeave = dashboardPage.clickAssignLeave();
		assignLeave.enterEmployeeName("John Smith");
		assignLeave.selectLeaveType("Vacation US");
		assignLeave.verifyLeaveBalance();
		assignLeave.selectFromDate("5");
		assignLeave.clickAssignButton();
		assignLeave.clickConfirmOkButton();
		Assert.assertTrue(assignLeave.verifySuccessfullyAssignedMessage(),
				"Successfully Assigned Message not displayed");
	}
}
