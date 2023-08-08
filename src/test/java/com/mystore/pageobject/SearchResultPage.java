package com.mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	WebDriver driver;

	

	public SearchResultPage(WebDriver driver2) {
		driver=driver2;
		PageFactory.initElements(driver2, this);
	}


	@FindBy(id="search")
	WebElement txtSearch;
	
	@FindBy(css="img[alt='Layla Tee']")
	WebElement LaylaTeeProduct;
	
	
	public void enterTextInSearchBox_Search(String txt) {
		txtSearch.click();
		txtSearch.sendKeys(txt);
		txtSearch.sendKeys(Keys.ENTER);
	}
	
	public String getPageContain() {
		String pageContain=driver.findElement(By.tagName("ol")).getText();
		return pageContain;
	}
	
	public void clickOnProduct() {
		LaylaTeeProduct.click();
	}
	
	
	

}
