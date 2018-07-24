package com.orangehrm.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.orangehrm.commons.CommonObjects;

public class DashboardPage extends CommonObjects {

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

}
