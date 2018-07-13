package com.orangehrm.hrmdemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.Commons;
import com.orangehrm.hrmdemo.pageobjects.HomePage;
import com.orangehrm.hrmdemo.pageobjects.LoginPage;
import com.orangehrm.hrmdemo.pageobjects.PIMPage;
import com.orangehrm.hrmdemo.pageobjects.PIMTab.AddEmployee;
import com.orangehrm.hrmdemo.pageobjects.PIMTab.PersonalDetails;

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
	public void addEmployeeWithoutPhotograph() {
		AddEmployee addEmpPage = pPage.clickaddEmployeeLink();
		Assert.assertTrue(addEmpPage.verifyAddEmployeePage(), "Add Employee Page not displayed");
		PersonalDetails pDetailsPage = addEmpPage.addEmployeeWithoutPhoto("Jack", "Sparrow");
		Assert.assertTrue(pDetailsPage.verifyPersonalDetailsPage(), "Personal Details page not dipslayed");
	}
}
