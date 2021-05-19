/*
 * 
 * This class contains locators and actions to be performed on them for the Upload a File Page
 * 
 */

package com.payBox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage {
	
WebDriver ldriver;
	
	public UploadPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="div.files-page-button-label>span>span")
	WebElement btnUpload;
	
	@FindBy(css="span.bdl-targeted-click-through>li>span")
	WebElement btnFile;
	
	public void clickUpload() {
		btnUpload.click();
	}
	
	public void clickFile() {
		btnFile.click();
	}
}
