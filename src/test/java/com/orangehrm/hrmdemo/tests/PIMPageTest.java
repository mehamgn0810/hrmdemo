package com.orangehrm.hrmdemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.HomePage;
import com.orangehrm.hrmdemo.pageobjects.LoginPage;
import com.orangehrm.hrmdemo.pageobjects.PIMPage;
import com.orangehrm.hrmdemo.pageobjects.PIMTab.AddEmployee;
import com.orangehrm.hrmdemo.pageobjects.PIMTab.EmployeeList;
import com.orangehrm.hrmdemo.pageobjects.PIMTab.PersonalDetails;

public class PIMPageTest extends BaseClass {

	LoginPage lPage;
	HomePage hPage;
	PIMPage pPage;
	AddEmployee addEmpPage;
	PersonalDetails pDetailsPage;
	EmployeeList empList;

	@BeforeMethod
	public void beforeMethod() {
		lPage = new LoginPage();
		hPage = lPage.login(prop.getProperty("username"), prop.getProperty("password"));
		pPage = hPage.clickPIMTab();
	}
	
	@Test
	public void verifyNavigationToAllSubTabs() {
		pPage.clickaddEmployeeLink();
		Assert.assertTrue(pPage.isSelectedTab("Add Employee"), "Add Employee is not the selected tab");
		pPage.clickEmployeeListLink();
		Assert.assertTrue(pPage.isSelectedTab("Employee List"), "Employee List is not the selected tab");
		
	}

	@Test(priority=1)
	public void addEmployeeWithoutPhotograph() {
		addEmpPage = pPage.clickaddEmployeeLink();
		pDetailsPage = addEmpPage.addEmployeeWithoutPhoto("Jack", "Sparrow");
		Assert.assertTrue(pDetailsPage.verifyPersonalDetailsPage(), "Personal Details page not dipslayed");
	}
}
