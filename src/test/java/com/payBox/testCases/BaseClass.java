package com.payBox.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.payBox.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseUrl = readConfig.getApplicationURL();
	public String emailAddress = readConfig.getEmailAddress();
	public String password = readConfig.getPassword();
	public String browser = readConfig.getBrowserName();
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
