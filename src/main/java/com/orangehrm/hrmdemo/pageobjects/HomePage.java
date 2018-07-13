package com.orangehrm.hrmdemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.hrmdemo.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//div[@id='branding']//img")
	private WebElement hrmLogo;
	
	@FindBy(id = "menu_pim_viewPimModule")
	WebElement pimTab;
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement leaveTab;

	@FindBy(id = "menu_dashboard_index")
	WebElement dashboardTab;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogoDisplayed() {
		return hrmLogo.isDisplayed();
	}
	
	public boolean isCurrentTab(String tabName) {
		boolean status = driver.findElement(By.xpath("//li[@class='current']//b[text()='" + tabName + "']")).isDisplayed();
		return status;
	}
	
	public PIMPage clickPIMTab(){
		pimTab.click();
		return new PIMPage();
	}

	public DashboardPage clickDashboardTab(){
		dashboardTab.click();
		return new DashboardPage();
	}

	public LeavePage clickLeaveTab(){
		leaveTab.click();
		return new LeavePage();
	}

}
