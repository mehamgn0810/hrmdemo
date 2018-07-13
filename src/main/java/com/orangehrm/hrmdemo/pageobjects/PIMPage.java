package com.orangehrm.hrmdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.PIMTab.AddEmployee;

public class PIMPage extends BaseClass{
	
	@FindBy(id = "menu_pim_addEmployee")
	WebElement addEmployee;
	
	
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}

	public AddEmployee clickaddEmployeeLink(){
		addEmployee.click();
		return new AddEmployee();
	}
}
