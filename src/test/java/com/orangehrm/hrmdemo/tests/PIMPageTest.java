package com.orangehrm.hrmdemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.Commons;
import com.orangehrm.hrmdemo.pageobjects.HomePage;
import com.orangehrm.hrmdemo.pageobjects.LoginPage;
import com.orangehrm.hrmdemo.pageobjects.PIMPage;

public class PIMPageTest extends BaseClass {

	LoginPage lPage;
	HomePage hPage;
	PIMPage pPage;

	@BeforeMethod
	public void beforeMethod() {
		lPage = new LoginPage();
		hPage = lPage.login(prop.getProperty("username"), prop.getProperty("password"));
		pPage = hPage.clickPIMTab();
	}

	@Test
	public void verifyPIMPage() {
		Assert.assertTrue(Commons.isCurrentTab("PIM"));
	}

	@Test
	public void addEmployee() {
		pPage.clickaddEmployeeLink();
	}
}
