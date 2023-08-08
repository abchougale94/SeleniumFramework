package com.mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {
	
	WebDriver driver;

	public CustomerLoginPage(WebDriver rdriver) {

		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 @FindBy(name="login[username]")
	 WebElement txtEmail;
	 
	 @FindBy(name="login[password]")
	 WebElement txtPassword;
	 
	 @FindBy(name="send")
	 WebElement txtSignIn;
	 
	 @FindBy(xpath="(//span[@class='logged-in'])[1]")
	 WebElement userName;
	 
	 @FindBy(xpath="(//button[@class='action switch'])[1]")
	 WebElement drpdwnMenu;
	 
	 @FindBy(xpath="/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
	 WebElement signOut;
	 
	 @FindBy(xpath="/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")
	 WebElement myAccMenu;
		
	@FindBy(xpath="/html/body/div[1]/main/div[2]/div[1]/div[3]/div[2]/div/div[1]/p/text()[2]")
	WebElement AccEmail;
	 
	 public void enterEmail(String email) {
		 txtEmail.sendKeys(email);
	 }
	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickOnSignIn() {
		txtSignIn.click();
	}
	
	public String getUserName() {
		String text=userName.getText();
		return text;
	}
	
	public void clcikOnSignOut() {
		drpdwnMenu.click();
		signOut.click();
	}
	
	public void readAccountEmail() {
		drpdwnMenu.click();
		myAccMenu.click();
		
	}
	
	

}
