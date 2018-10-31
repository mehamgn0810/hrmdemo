package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pageobjects.DashboardPage;
import com.orangehrm.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	@BeforeMethod
	public void BeforeMethod() {
		loginPage = new LoginPage();
	}

	@Test
	public void verifyLogo() {
		Assert.assertTrue(loginPage.isLoginPageLogoDisplayed(), "Logo not dipslayed in LoginPage");
	}
	
	@Test
	public void logintest() {
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(dashboardPage.isLogoDisplayed(), "Logo not dipslayed in HomePage");
	}
	
}

	
