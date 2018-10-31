package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.dataproviders.TestDataProviders;
import com.orangehrm.pageobjects.AddEmployee;
import com.orangehrm.pageobjects.DashboardPage;
import com.orangehrm.pageobjects.EmployeeList;
import com.orangehrm.pageobjects.LoginPage;
import com.orangehrm.pageobjects.PersonalDetails;

public class EmployeeTest extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	EmployeeList employeeList;
	AddEmployee addEmployee;
	PersonalDetails personalDetails;

	@BeforeMethod
	public void BeforeMethod() {
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		employeeList = dashboardPage.clickPIMTab();
	}

	@Test(dataProvider = "employeeTest", dataProviderClass = TestDataProviders.class, enabled = false)
	public void addEmployeeWithoutPhotograph(String firstName, String lastName) {
		addEmployee = employeeList.clickAddEmployeeLink();
		personalDetails = addEmployee.addEmployeeWithoutPhoto(firstName, lastName);
		Assert.assertEquals(personalDetails.verifyProfileName(), firstName + " " + lastName, "Profile Name validation failed");
	}
	
	@Test
	public void addEmployeeWithLoginDetails() { 
		addEmployee = employeeList.clickAddEmployeeLink();
		addEmployee.enterFirstName("Jack");
		addEmployee.enterLastName("Sparrow");
		addEmployee.clickCreateLoginCheckBox();
		addEmployee.enterUserName("JackS");
		addEmployee.enterUserPassword("testing123");
		addEmployee.enterRePassword("testing123");
		Assert.assertTrue(addEmployee.verifySelectedStatus("Enabled"), "Employee Status is not Enabled");
		personalDetails = addEmployee.clickSaveButton();
		Assert.assertEquals(personalDetails.verifyProfileName(), "Jack Sparrow", "Profile Name not displayed");
	}

	@Test(enabled = true, dependsOnMethods = "addEmployeeWithLoginDetails")
	public void searchEmployeeWithName() {
		employeeList.searchEmployeebyName("Jack");
		Assert.assertTrue(employeeList.isEmployeeDisplayed("Jack"), "Employee not displayed in Results List");
	}

	@Test(dependsOnMethods = "searchEmployeeWithName", enabled=true, priority=5)
	public void deleteEmployee() {
		employeeList.searchEmployeebyName("Jack");
		employeeList.selectEmployeebyFirstName("Jack");
		employeeList.deleteSelectedRecords();
		Assert.assertTrue(employeeList.verifySuccessfullyDeletedMessage(),
				"Successfully Deleted Message not displayed");
		Assert.assertFalse(employeeList.isEmployeeDisplayed("Jack"), "Employee displayed in Results List");
	}
	
}
