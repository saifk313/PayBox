package com.payBox.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payBox.pageObjects.HomePage;
import com.payBox.pageObjects.LoginPage;
import com.payBox.utilities.TestUtils;

public class TC_HomeTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("folder_name")
	@Test
	public void addNewFolder(String folder_name) throws InterruptedException {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		System.out.println("**********************");
		System.out.println("Add New Folder Test Case");
		
		loginPage.loginSteps(emailAddress, password);
		
		Thread.sleep(3000);
		homePage.clickLblHelloMsg();
		Thread.sleep(3000);
		
		try {
			boolean isPresent = driver.findElement(By.linkText(folder_name)).isDisplayed();
			if(isPresent) {
				System.out.println("\n Folder already present. Please try with another name \n");
				Assert.assertTrue(false);
			}
		}
		catch(NoSuchElementException nse) {
			homePage.clickNew();
			homePage.clickLnkNewFolder();
			Thread.sleep(2000);
			homePage.setFolderName(folder_name);		
			String email = TestUtils.randomString() + "@dummy.com";
			homePage.setInviteAddPeople(email);
			TestUtils.selectDropDown("select[name='invite-permission']", "Editor");
			homePage.clickBtnCreate();
			
			Thread.sleep(3000);
			
			boolean created = driver.findElement(By.linkText(folder_name)).isDisplayed();
			if(created) {
				Assert.assertTrue(true);
				System.out.println("Folder Successfully created");
			}
			else {
				Assert.assertTrue(false);
				System.out.println("Test Case Failed!");
			}
		}
		
		System.out.println("End of Add New Folder Test Case");
		System.out.println("**********************");
	}
}
