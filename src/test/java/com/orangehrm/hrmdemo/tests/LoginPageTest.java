package com.orangehrm.hrmdemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.HomePage;
import com.orangehrm.hrmdemo.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {

	LoginPage lPage;
	HomePage hPage;
	
	@BeforeMethod
	public void BeforeMethod() {
		lPage = new LoginPage();
	}

	@Test(priority=0)
	public void verifyLogo() {
		Assert.assertTrue(lPage.isLogoDisplayed(), "Logo not dipslayed in LoginPage");
	}
	
	@Test(priority=1)
	public void logintest() {
		hPage = lPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(hPage.isLogoDisplayed(), "Logo not dipslayed in HomePage");
	}
	
}

	
