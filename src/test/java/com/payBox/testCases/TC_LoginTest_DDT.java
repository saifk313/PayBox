package com.payBox.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.Assert;

import com.payBox.pageObjects.HomePage;
import com.payBox.pageObjects.LoginPage;
import com.payBox.utilities.TestUtils;

public class TC_LoginTest_DDT extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	
	@Test(dataProvider="LoginData")
	public void loginTest(String emailid, String pwd) throws InterruptedException {
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		loginPage.setEmailAddress(emailid);
		loginPage.clickNext();
		loginPage.setPassword(pwd);
		loginPage.clickSubmit();
		
		Thread.sleep(3000);
		if(isInvalidUser()) {
			driver.get(baseUrl);
			Assert.assertTrue(false);
		}
		else {
			homePage.helloMsgExists();
			homePage.clickAvatar();
			Thread.sleep(1000);
			homePage.clickLogout();
			driver.get(baseUrl);
			System.out.println("Login Successful!!!");
			Assert.assertTrue(true);
			
		}
	}
	
	public boolean isInvalidUser() { // Check if valid user or not
		try {
			boolean flag = loginPage.checkErrorMessage();
			if(flag)
				return true;
			else
				return false;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getLoginData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/payBox/testData/BoxData.xlsx";
		
		int rowCount = TestUtils.getRowCount(path, "Sheet1");
		int colCount = TestUtils.getCellCount(path, "Sheet1", 1);
		
		String[][] loginData = new String[rowCount][colCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = TestUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;
	}
}
