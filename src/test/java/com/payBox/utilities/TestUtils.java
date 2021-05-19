/*
 * 
 * This is a test utility class which provides support to the test classes for:
 * 1. Reading from and Writing to the excel sheets.
 * 2. Providing methods for explicit wait for an element
 * 3. Selecting a value from a drop down.
 * 4. Method for generating random text.
 * 
 */

package com.payBox.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.payBox.testCases.BaseClass;

public class TestUtils extends BaseClass {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);
		int rowCount = sheet.getLastRowNum();
		fi.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		fi.close();
		return cellCount;
	}
	
	public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e) {
			data = "";
		}		
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		fi.close();
		fo.close();
	}
	
	public static void selectDropDown(String locator, String value) { 
		Select select = new Select(driver.findElement(By.cssSelector(locator)));
		select.selectByVisibleText(value);
	}
	
	public static String randomString() {
		String random = RandomStringUtils.randomAlphabetic(7);
		return random;
	}
	
	public static WebElement waitForElement(WebDriver driver, By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
}
