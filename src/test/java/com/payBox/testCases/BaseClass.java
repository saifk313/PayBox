package com.payBox.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public String baseUrl = "https://account.box.com/login";
	public String emailAddress = "saifzane2@gmail.com";
	public String password = "Boxer@123";
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
