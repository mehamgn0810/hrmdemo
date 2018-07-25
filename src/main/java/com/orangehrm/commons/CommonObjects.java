package com.orangehrm.commons;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pageobjects.DashboardPage;
import com.orangehrm.pageobjects.EmployeeList;
import com.orangehrm.pageobjects.LeavePage;

public class CommonObjects extends BaseClass {

	@FindBy(xpath = "//div[@id='branding']//img")
	private WebElement hrmLogo;

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement pimTab;

	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement leaveTab;

	@FindBy(id = "menu_dashboard_index")
	WebElement dashboardTab;

	public CommonObjects() {
		PageFactory.initElements(driver, this);
	}

	public boolean isLogoDisplayed() {
		return hrmLogo.isDisplayed();
	}

	public boolean isCurrentTab(String tabName) {
		try {
			boolean status = driver.findElement(By.xpath("//li[@class='current']//b[text()='" + tabName + "']"))
					.isDisplayed();
			return status;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public EmployeeList clickPIMTab() {
		pimTab.click();
		return new EmployeeList();
	}

	public DashboardPage clickDashboardTab() {
		dashboardTab.click();
		return new DashboardPage();
	}

	public LeavePage clickLeaveTab() {
		leaveTab.click();
		return new LeavePage();
	}
}