package com.orangehrm.hrmdemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.Commons;
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

	@Test
	public void verifyCurrentTab() {
		Assert.assertTrue(Commons.isCurrentTab("Dashboard"));
	}
	
}
