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
	
	public String getLabelMessage() {
		return lblHelloMsg.getText();
	}

}
