package com.orangehrm.commons;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pageobjects.AddEmployee;
import com.orangehrm.pageobjects.EmployeeList;

public class PIMCommons extends BaseClass {

	@FindBy(id = "menu_pim_addEmployee")
	WebElement addEmployee;

	@FindBy(id = "menu_pim_viewEmployeeList")
	WebElement empList;

	@FindBy(xpath = "//li[@class='selected']//a")
	WebElement selectedTab;

	public PIMCommons() {
		PageFactory.initElements(driver, this);
	}

	public AddEmployee clickaddEmployeeLink() {
		addEmployee.click();
		return new AddEmployee();
	}

	public EmployeeList clickEmployeeListLink() {
		empList.click();
		return new EmployeeList();
	}

	public boolean isSelectedSubTab(String subTabName) {
		String activeTab = selectedTab.getText();
		if (activeTab.equals(subTabName)) {
			return true;
		}else {
			return false;
		}
	}

}
