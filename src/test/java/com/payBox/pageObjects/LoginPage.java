package com.payBox.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="input#login-email")
	WebElement txtEmailAddr; 
	
	@FindBy(css="button#login-submit")
	WebElement btnNext;
	
	@FindBy(css="input#password-login") 
	WebElement txtPassword;
	
	@FindBy(css="button#login-submit-password") 
	WebElement btnSubmit;
	
	@FindBy(css="div.form-error")
	WebElement lblErrorMessage;
	
	public void setEmailAddress(String emailId) {
		txtEmailAddr.sendKeys(emailId);
	}
	
	public void clickNext() {
		btnNext.click();
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnSubmit.submit();
	}
	
	public boolean checkErrorMessage() {
		return lblErrorMessage.isDisplayed();
	}
}
