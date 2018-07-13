package com.orangehrm.hrmdemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.HomePage;
import com.orangehrm.hrmdemo.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{

	LoginPage lPage;
	HomePage hPage;
	
	@BeforeMethod
	public void BeforeMethod() {
		lPage = new LoginPage();
		hPage = lPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=0)
	public void verifyCurrentTab() {
		Assert.assertTrue(hPage.isCurrentTab("Dashboard"));
	}
	
	@Test(priority=1)
	public void verifyNavigationToAllTabs() {
		hPage.clickPIMTab();
		Assert.assertTrue(hPage.isCurrentTab("PIM"), "PIM tab is not the current tab");
		hPage.clickLeaveTab();
		Assert.assertTrue(hPage.isCurrentTab("Leave"), "Leave tab is not the current tab");
		hPage.clickDashboardTab();
		Assert.assertTrue(hPage.isCurrentTab("Dashboard"), "Dashboard tab is not the current tab");
	}
	
}
