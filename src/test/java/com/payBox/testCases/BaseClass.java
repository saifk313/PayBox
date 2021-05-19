/*
 * 
 * This is the Base class for all the test classes, which provides basic resources such as 
 * 
 * Application URL, Credentials, WebDriver and browser instances. These resources are fetched from the ReadConfig.java class
 * 
 * The browser instance is decided by the value provided by the testng.xml file.
 * 
 */

package com.payBox.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.payBox.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseUrl = readConfig.getApplicationURL();
	public String emailAddress = readConfig.getEmailAddress();
	public String password = readConfig.getPassword();
	public String browser = readConfig.getBrowserName();
	public long pageLoadTimeout = Long.parseLong(readConfig.getPageLoadTimeout());
	public long implicitWait = Long.parseLong(readConfig.getImplicitWait());
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else
			System.out.println("Invalid Browser Name");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
