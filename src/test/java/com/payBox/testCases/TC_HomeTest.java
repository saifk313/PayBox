package com.payBox.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.payBox.pageObjects.HomePage;
import com.payBox.pageObjects.LoginPage;
import com.payBox.utilities.TestUtils;

public class TC_HomeTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void addNewFolder() throws InterruptedException {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		loginPage.setEmailAddress(emailAddress);
		loginPage.clickNext();
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		
		Thread.sleep(3000);
		
		homePage.clickLblHelloMsg();
		Thread.sleep(3000);
		homePage.clickNew();
		homePage.clickLnkNewFolder();
		Thread.sleep(2000);
		homePage.setFolderName("Boxer");		
		String email = TestUtils.randomString() + "@dummy.com";
		homePage.setInviteAddPeople(email);
		TestUtils.selectDropDown("select[name='invite-permission']", "Editor");
		homePage.clickBtnCreate();
		
		Thread.sleep(3000);
		
		boolean created = driver.findElement(By.linkText("Boxer")).isDisplayed();
		if(created) {
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
}
