package com.payBox.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.payBox.pageObjects.HomePage;
import com.payBox.pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void loginTest() throws InterruptedException {
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		boolean helloMsg;
		
		System.out.println("**********************");
		System.out.println("Login Test Case");
		
		loginPage.setEmailAddress(emailAddress);
		loginPage.clickNext();
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		
		Thread.sleep(3000);
		helloMsg = homePage.helloMsgExists();
		if(helloMsg) {
			homePage.clickLblHelloMsg();
			homePage.clickAvatar();
			Thread.sleep(1000);
			homePage.clickLogout();
			driver.get(baseUrl);
			Assert.assertTrue(true);
			System.out.println("\n Login Successful!!! \n");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("Login Invalid..");
		}
		
		System.out.println("End of Login Test Case");
		System.out.println("**********************");
	}
}
