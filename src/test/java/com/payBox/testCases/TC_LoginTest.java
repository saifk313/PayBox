package com.payBox.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.payBox.pageObjects.HomePage;
import com.payBox.pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void loginTest() throws InterruptedException {
		driver.get(baseUrl);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		String lblMessage;
		
		loginPage.setEmailAddress(emailAddress);
		loginPage.clickNext();
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		
		lblMessage = homePage.getLabelMessage();
		if(lblMessage.equals("Unlock More Storage")) {
			Assert.assertTrue(true);
			System.out.println("success");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("failure");
		}
	}

}
