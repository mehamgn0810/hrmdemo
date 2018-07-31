package com.orangehrm.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.commons.CommonObjects;

public class DashboardPage extends CommonObjects {
	
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Assign Leave')]//preceding-sibling::img")
	WebElement assignLeaveImg;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AssignLeave clickAssignLeave() {
		assignLeaveImg.click();
		return new AssignLeave();
	}

}
