package com.orangehrm.hrmdemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.PIMTab.AddEmployee;
import com.orangehrm.hrmdemo.pageobjects.PIMTab.EmployeeList;

public class PIMPage extends BaseClass{
	
	@FindBy(id = "menu_pim_addEmployee")
	WebElement addEmployee;
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	WebElement empList;
	
	
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}

	public AddEmployee clickaddEmployeeLink(){
		addEmployee.click();
		return new AddEmployee();
	}
	
	public EmployeeList clickEmployeeListLink(){
		empList.click();
		return new EmployeeList();
	}
	
	public boolean isSelectedTab(String tabName) {
		boolean status = driver.findElement(By.xpath("//li[@class='selected']//a[text()='" + tabName + "']")).isDisplayed();
		return status;
	}
}
