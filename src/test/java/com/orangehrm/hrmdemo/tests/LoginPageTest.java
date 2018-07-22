package com.orangehrm.hrmdemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.DashboardPage;
import com.orangehrm.hrmdemo.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	@BeforeMethod
	public void BeforeMethod() {
		loginPage = new LoginPage();
	}

	@Test(priority=0)
	public void verifyLogo() {
		Assert.assertTrue(loginPage.isLoginPageLogoDisplayed(), "Logo not dipslayed in LoginPage");
	}
	
	@Test(priority=1)
	public void logintest() {
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(dashboardPage.isLogoDisplayed(), "Logo not dipslayed in HomePage");
	}
	
}

	
