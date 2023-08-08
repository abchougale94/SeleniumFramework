package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustAcctPage {
	
	WebDriver driver;

	public CreateCustAcctPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	WebElement fisrtName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="email_address")
	WebElement emailtxt;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="password-confirmation")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[@class='action submit primary']")
	WebElement createAnAccount;
	
	public void firstName(String name) {
		fisrtName.sendKeys(name);
	}
	public void lastName(String lname) {
		lastName.sendKeys(lname);
	}
	public void enterEmail(String email) {
		emailtxt.sendKeys(email);
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void enterConfirmPassword(String cpwd) {
		confirmPassword.sendKeys(cpwd);
	}
	public void clickOnCreateAnAccount() {
		createAnAccount.click();
	}

}
