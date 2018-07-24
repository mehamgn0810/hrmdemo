package com.orangehrm.dataproviders;

import org.testng.annotations.DataProvider;

import com.orangehrm.util.ExcelUtility;

public class TestDataProviders{
	
	
	@DataProvider(name="employeeTest")
	public Object[][] dp1() {
		
		Object[][] employeeTestData = ExcelUtility.readExcel();
		return employeeTestData;
	}

}
