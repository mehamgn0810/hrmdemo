package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pageobjects.DashboardPage;
import com.orangehrm.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	@BeforeMethod
	public void BeforeMethod() {
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=0)
	public void verifyCurrentTab() {
		Assert.assertTrue(dashboardPage.isCurrentTab("Dashboard"));
	}
	
	@Test(priority=1)
	public void verifyNavigationToAllTabs() {
		dashboardPage.clickPIMTab();
		Assert.assertTrue(dashboardPage.isCurrentTab("PIM"), "PIM tab is not the current tab");
		dashboardPage.clickLeaveTab();
		Assert.assertTrue(dashboardPage.isCurrentTab("Leave"), "Leave tab is not the current tab");
		dashboardPage.clickDashboardTab();
		Assert.assertTrue(dashboardPage.isCurrentTab("Dashboard"), "Dashboard tab is not the current tab");
	}
	
}
