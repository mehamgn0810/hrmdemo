package com.orangehrm.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.orangehrm.util.Constants;
import com.orangehrm.util.ExcelUtility;

public class TestDataProviders {

	public TestDataProviders() {
		try {
			ExcelUtility.setExcelInstance(Constants.testDataFile, Constants.testDataFile,
					Constants.employeeTestDataSheet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@DataProvider(name = "employeeTest")
	public Object[][] dp1() {

		Object[][] employeeTestData = ExcelUtility.readExcel();
		return employeeTestData;
	}

}
