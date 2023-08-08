package com.mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
	WebDriver driver;

	public OrderConfirmationPage(WebDriver rdriver) {

		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public String confirmOrderMessage() {
		String bodyTag = driver.findElement(By.tagName("h1")).getText();
		return bodyTag;
	}

}
