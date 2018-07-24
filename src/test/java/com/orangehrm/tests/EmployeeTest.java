package com.orangehrm.tests;

import java.io.IOException;

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
import com.orangehrm.util.Constants;
import com.orangehrm.util.ExcelUtility;

public class EmployeeTest extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	EmployeeList employeeList;
	AddEmployee addEmployee;
	PersonalDetails personalDetails;

	@BeforeMethod
	public void BeforeMethod() {
		try {
			ExcelUtility.setExcelInstance(Constants.testDataFile, Constants.testDataFile,
					Constants.employeeTestDataSheet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		employeeList = dashboardPage.clickPIMTab();
	}

	@Test(dataProvider = "employeeTest", dataProviderClass = TestDataProviders.class, enabled = true)
	public void addEmployeeWithoutPhotograph(String firstName, String lastName) {
		addEmployee = employeeList.clickAddEmployeeLink();
		personalDetails = addEmployee.addEmployeeWithoutPhoto(firstName, lastName);
		Assert.assertEquals(personalDetails.verifyProfileName(), firstName + " " + lastName, "Profile Name validation failed");
	}

	@Test(dataProvider = "employeeTest", dataProviderClass = TestDataProviders.class, enabled = true, dependsOnMethods = "addEmployeeWithoutPhotograph")
	public void searchEmployeeWithName(String name) {
		employeeList.searchEmployeebyName(name);
		Assert.assertTrue(employeeList.isEmployeeDisplayed(name), "Employee not displayed in Results List");
	}

	@Test(dataProvider = "employeeTest", dataProviderClass = TestDataProviders.class, dependsOnMethods = "searchEmployeeWithName")
	public void deleteEmployee(String fName) {
		employeeList.searchEmployeebyName(fName);
		employeeList.selectEmployeebyFirstName(fName);
		employeeList.deleteSelectedRecords();
		Assert.assertTrue(employeeList.verifySuccessfullyDeletedMessage(),
				"Successfully Deleted Message not displayed");
		Assert.assertFalse(employeeList.isEmployeeDisplayed(fName), "Employee displayed in Results List");
	}
}
