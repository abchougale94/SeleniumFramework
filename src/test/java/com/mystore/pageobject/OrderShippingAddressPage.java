package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderShippingAddressPage {
	
	WebDriver driver;

	public OrderShippingAddressPage(WebDriver rdriver) {

		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="RLTCCYE")
	WebElement company;
	
	@FindBy(id="N8UUY27")
	WebElement streetAddres;
	
	@FindBy(id="NKV8HET")
	WebElement city;
	
	@FindBy(id="RHLQUYJ")
	WebElement state;
	
	@FindBy(id="YVRKDYX")
	WebElement pinCode;
	
	@FindBy(id="IOHVM32")
	WebElement country;
	
	@FindBy(id="RN67UKH")
	WebElement phoneNo;
	
	@FindBy(xpath="/HTML/BODY/DIV[1]/MAIN/DIV[2]/DIV/DIV[2]/DIV[4]/OL/LI[2]/DIV/DIV[3]/FORM/DIV[3]/DIV/BUTTON/SPAN")
	WebElement nextBtn;
	
	
	
	public void enterCompany(String comp) {
		company.sendKeys(comp);
	}
	public void enterAddress(String addr) {
		streetAddres.sendKeys(addr);
	}
	public void enterCity(String cityl) {
		city.sendKeys(cityl);
	}
	public void enterpinCode(String pCode) {
		pinCode.sendKeys(pCode);
	}
	public void selectCountry(String countryy) {
		Select sl=new Select(country);
		sl.selectByValue(countryy);
	}
	public void selectState(String st) {
		Select sl=new Select(state);
		sl.selectByValue(st);
	}
	public void enterPhoneNumber(String phone) {
		phoneNo.sendKeys(phone);
	}
	public void clickOnNextBtn() {
		nextBtn.click();
	}
	

}
