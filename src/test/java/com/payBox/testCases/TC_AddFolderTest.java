/*
 * 
 * This test class contains a test case to validate the functionality of adding a new folder.
 * The test case fails if the user tries to enter an already existing folder.
 * Folder name is provided by the testng.xml file.
 * 
 */

package com.payBox.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payBox.pageObjects.HomePage;
import com.payBox.pageObjects.LoginPage;

public class TC_AddFolderTest extends BaseClass {
	
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
			homePage.createFolder(folder_name);	
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
