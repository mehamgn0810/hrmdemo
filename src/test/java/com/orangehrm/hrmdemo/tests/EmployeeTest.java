package com.orangehrm.hrmdemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.AddEmployee;
import com.orangehrm.hrmdemo.pageobjects.DashboardPage;
import com.orangehrm.hrmdemo.pageobjects.EmployeeList;
import com.orangehrm.hrmdemo.pageobjects.LoginPage;
import com.orangehrm.hrmdemo.pageobjects.PersonalDetails;

public class EmployeeTest extends BaseClass{
	
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
	
	@Test(enabled = true)
	public void addEmployeeWithoutPhotograph() {
		addEmployee = employeeList.clickAddEmployeeLink();
		personalDetails = addEmployee.addEmployeeWithoutPhoto("Jack", "Sparrow");
		Assert.assertEquals(personalDetails.verifyProfileName(), "Jack Sparrow", "Profile Name validation failed");
	}
	
	@Test(enabled = true, dependsOnMethods="addEmployeeWithoutPhotograph")
	public void searchEmployeeWithName() {
		employeeList.searchEmployeebyName("Jack");
		Assert.assertTrue(employeeList.isEmployeeDisplayed("Jack"), "Employee not displayed in Results List");
	}
	
	@Test(dependsOnMethods="searchEmployeeWithName")
	public void deleteEmployee() {
		employeeList.searchEmployeebyName("Jack");
		employeeList.selectEmployeebyFirstName("Jack");
		employeeList.deleteSelectedRecords();
		Assert.assertTrue(employeeList.verifySuccessfullyDeletedMessage(), "Successfully Deleted Message not displayed");
		Assert.assertFalse(employeeList.isEmployeeDisplayed("Jack"), "Employee displayed in Results List");
	}
}
