package com.orangehrm.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id = "txtUsername")
	private WebElement uName;

	@FindBy(id = "txtPassword")
	private WebElement pwd;

	@FindBy(id = "btnLogin")
	private WebElement loginBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='divLogo']/img")
	private WebElement hrmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public DashboardPage login(String userName, String password) {
		uName.sendKeys(userName);
		pwd.sendKeys(password);
		loginBtn.click();
		return new DashboardPage();
	}
	
	public boolean isLoginPageLogoDisplayed() {
		return hrmLogo.isDisplayed();
	}
	

}
