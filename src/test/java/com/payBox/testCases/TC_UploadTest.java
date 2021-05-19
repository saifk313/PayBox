/*
 * 
 * This test class contains a test case to validate the functionality of uploading a file.
 * The test case checks if the folder exists. If yes, it uploads in it else creates a new folder and then uploads the file.
 * Folder name is provided by the testng.xml file.
 * 
 * The test case uses AutoIT for executing Windows functionality for uploading files
 * The file is provided in the base location of the project
 * 
 */

package com.payBox.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payBox.pageObjects.HomePage;
import com.payBox.pageObjects.LoginPage;
import com.payBox.pageObjects.UploadPage;
import com.payBox.utilities.TestUtils;

public class TC_UploadTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	UploadPage uploadPage;
	
	@Parameters("folder_name")
	@Test
	public void uploadFile(String folder_name) throws InterruptedException, IOException {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		uploadPage = new UploadPage(driver);
		
		System.out.println("**********************");
		System.out.println("Upload a File Test Case");
		
		loginPage.loginSteps(emailAddress, password);
		
		Thread.sleep(3000);

		//Check if the folder already exists
		WebElement folder = driver.findElement(By.linkText(folder_name));
		if(folder.isDisplayed()) {
			folder.click();
		}
		else {
			System.out.println("Folder does not exist. Creating the folder now");
			homePage.createFolder(folder_name);
		}
		
		Thread.sleep(2000);
		try { // For the very first upload
			uploadPage.clickUpload();
			Thread.sleep(3000);
			uploadPage.clickFile();
			Thread.sleep(3000);
		}
		catch(NoSuchElementException nse) { // For subsequent uploads
			homePage.clickLblHelloMsg();
			homePage.clickNew();
			homePage.clickFileUpload();
			Thread.sleep(3000);
		}
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "/FileUpload.exe");
		
		// Check the success message using explicit wait
		By completedMsg = By.xpath("//span[contains(text(),'Completed')]");
		WebElement completed = TestUtils.waitForElement(driver, completedMsg, 15000);
		
		if(completed.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("\n File Uploaded successfully \n");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("Failure");
		}
		
		System.out.println("End of Upload a File Test Case");
		System.out.println("**********************");
	}
}
