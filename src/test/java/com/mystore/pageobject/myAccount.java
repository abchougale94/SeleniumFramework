package com.mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {

	WebDriver driver;

	public myAccount(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	public boolean confirmRegisteringMessage() {
		String confirmMessag="Thank you for registering with Main Website Store.";
		String PageMessage=driver.findElement(By.tagName("body")).getText();
		if(confirmMessag.contains(PageMessage)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
}
