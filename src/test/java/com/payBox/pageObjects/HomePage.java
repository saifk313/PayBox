package com.payBox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Hello,')]")
	WebElement lblHelloMsg;
	
	@FindBy(css="div.UnifiedNewDropdownMenuToggleButton-label>span")
	WebElement btnNew;
	
	@FindBy(css="span.avatar-initials ")
	WebElement imgAvatar;
	
	@FindBy(xpath="//*[@id=\"menu17\"]/li[11]/a/span")
	WebElement btnLogout;
	
	@FindBy(css="div.scroll-wrap-container.style--cover li:nth-child(4)>span")
	WebElement lnkNewFolder; 
	
	@FindBy(name="folder-name")
	WebElement txtFolderName; 
	
	@FindBy(css="textarea[role='combobox']")
	WebElement txtInviteAddPeople;
	
	@FindBy(name="invite-permission")
	WebElement selectPermission;
	
	@FindBy(css="div.modal-actions button:last-child>span>span")
	WebElement btnCreate;
	
	@FindBy(css="div.item-name>a")
	WebElement lnkCreatedFolder;
	
	@FindBy(css="div#tooltip1360>span")
	WebElement errFolderExists;
	
	public String getLabelMessage() {
		return lblHelloMsg.getText();
	}
	
	public void clickAvatar() {
		imgAvatar.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	
	public void clickLblHelloMsg() {
		lblHelloMsg.click();
	}
	
	public void clickNew() {
		btnNew.click();
	}
	
	public void clickLnkNewFolder() {
		lnkNewFolder.click();
	}
	
	public void setFolderName(String folderName) {
		txtFolderName.sendKeys(folderName);
	}
	
	public void clearFolderName() {
		txtFolderName.clear();
	}
	
	public void setInviteAddPeople(String inviteAddPeople) {
		txtInviteAddPeople.sendKeys(inviteAddPeople);
	}
	
	public void clickPermission() {
		selectPermission.click();
	}
	
	public void clickBtnCreate() {
		btnCreate.click();
	}
	
	public void clickLnkCreatedFolder() {
		lnkCreatedFolder.click();
	}
	
	public boolean folderExists() {
		return errFolderExists.isDisplayed();
	}
}
