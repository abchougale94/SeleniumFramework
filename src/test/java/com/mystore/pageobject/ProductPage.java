package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;

	public ProductPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="option-label-size-143-item-170")
	WebElement size;
	
	@FindBy(id="option-label-color-93-item-58")
	WebElement colour;
	
	@FindBy(id="qty")
	WebElement qty;
	
	@FindBy(xpath="//*[@id=\"product-addtocart-button\"]")
	WebElement addToCart;
	
	@FindBy(xpath="/html/body/div[1]/header/div[2]/div[1]/a")
	WebElement cartIcon;
	
	@FindBy(id="top-cart-btn-checkout")
	WebElement proccedToCheckOut;

	public void clickOnSize() {
		size.click();
	}
	public void selectColor() {
		colour.click();
	}
	public void enterQty(String i) {
		qty.clear();
		qty.sendKeys(i);
	}
	public void clickOnAddToCart() {
		addToCart.click();
	}
	public void clickOnCartIcon() {
		cartIcon.click();
	}
	public void clickOnProccedTocheckout() {
		proccedToCheckOut.click();
	}
	
}
