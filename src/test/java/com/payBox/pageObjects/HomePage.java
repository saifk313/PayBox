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
	
	@FindBy(css="div.InlineUpgradeButtonWithModal>button>span>span")
	WebElement lblHelloMsg;
	
	@FindBy(css="div.UnifiedNewDropdownMenuToggleButton-label>span")
	WebElement btnNew;
	
	@FindBy(css="span.avatar-initials ")
	WebElement imgAvatar;
	
	@FindBy(xpath="//*[@id=\"menu17\"]/li[11]/a/span")
	WebElement btnLogout;
	
	public String getLabelMessage() {
		return lblHelloMsg.getText();
	}
	
	public void clickAvatar() {
		imgAvatar.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
}
