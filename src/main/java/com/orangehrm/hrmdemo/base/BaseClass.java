package com.orangehrm.hrmdemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.hrmdemo.util.EventListener;

public class BaseClass{

	protected static WebDriver driver;
	protected Properties prop;
	protected EventListener el;
	protected EventFiringWebDriver eDriver;
	
	@BeforeMethod
	protected void setUp() {
		loadProperties();
		initializeBrowser();
		///initializeEventListener();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	protected void tearDown() {
		driver.quit();
	}

	protected void initializeEventListener() {
		el = new EventListener();
		eDriver = new EventFiringWebDriver(driver);
		eDriver.register(el);
		driver = eDriver;
	}

	protected void loadProperties() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\MEHAVARNAN\\git\\hrmdemo\\src\\main\\resources\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void initializeBrowser() {

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}


}
