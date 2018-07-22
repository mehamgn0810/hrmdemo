package com.orangehrm.hrmdemo.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.orangehrm.hrmdemo.commons.CommonObjects;

public class DashboardPage extends CommonObjects {

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

}
