package com.orangehrm.hrmdemo.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.hrmdemo.base.BaseClass;
import com.orangehrm.hrmdemo.pageobjects.AddEmployee;
import com.orangehrm.hrmdemo.pageobjects.EmployeeList;

public class PIMCommons extends BaseClass{
	
	CommonObjects commonObjects;
	
	@FindBy(id = "menu_pim_addEmployee")
	WebElement addEmployee;
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	WebElement empList;
	
	public PIMCommons() {
		PageFactory.initElements(driver, this);
		commonObjects = new CommonObjects();
	}
	
	public AddEmployee clickaddEmployeeLink(){
		addEmployee.click();
		return new AddEmployee();
	}
	
	public EmployeeList clickEmployeeListLink(){
		empList.click();
		return new EmployeeList();
	}
	
	public boolean isSelectedSubTab(String tabName) {
		try {
			boolean status = driver.findElement(By.xpath("//li[@class='selected']//a[text()='" + tabName + "']")).isDisplayed();
			return status;
		}catch(NoSuchElementException e) {
			return false;
		}	
	}

}
