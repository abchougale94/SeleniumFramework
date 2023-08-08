package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
public class OrderPaymentPage{
	
	WebDriver driver;

	public OrderPaymentPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/HTML/BODY/DIV[2]/MAIN/DIV[2]/DIV/DIV[2]/DIV[4]/OL/LI[3]/DIV/FORM/FIELDSET/DIV[1]/DIV/DIV/DIV[2]/DIV[2]/DIV[4]/DIV/BUTTON/SPAN")	
	WebElement placeOrder;
	

	public void clickOnPlaceOrder() {
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
	        jse.executeScript("arguments[0].click();", placeOrder);		
	}
	
	

}
