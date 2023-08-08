package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.CustomerLoginPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPaymentPage;
import com.mystore.pageobject.OrderShippingAddressPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.homePage;

import junit.framework.Assert;

public class TC_VerifyByProductTest extends BaseClass {
	
	
	@Test(enabled=true)
	public void verifySearchResult() throws IOException, InterruptedException {
		
		
		homePage hp=new homePage(driver);
		CustomerLoginPage CuLogin=new CustomerLoginPage(driver);
		hp.clickOnSignIn();
		CuLogin.enterEmail("teabhinaychougale19@gmail.com");
		CuLogin.enterPassword("testAbhi123");
		CuLogin.clickOnSignIn();
		
		
		SearchResultPage SearchRePg=new SearchResultPage(driver);
		String entertext="Tee";
		SearchRePg.enterTextInSearchBox_Search(entertext);
		SearchRePg.clickOnProduct();
		
		ProductPage ProPg=new ProductPage(driver);
		ProPg.clickOnSize();
		ProPg.selectColor();
		ProPg.enterQty("2");
		ProPg.clickOnAddToCart();
		Thread.sleep(4000);
		ProPg.clickOnCartIcon();
		ProPg.clickOnProccedTocheckout();
		
		
		Thread.sleep(4000);
		OrderShippingAddressPage OrdAddrePg=new OrderShippingAddressPage(driver);
		OrdAddrePg.clickOnNextBtn();
		
		OrderPaymentPage VerfByPg=new OrderPaymentPage(driver);
		VerfByPg.clickOnPlaceOrder();
		
		Thread.sleep(5000);
		OrderConfirmationPage OrdConPg=new OrderConfirmationPage(driver);
		String cinfirmMsg="Thank you for your purchase!";
		if(OrdConPg.confirmOrderMessage().contains(cinfirmMsg)) {
			Logger.info("Verify buy product : Passed");
			Assert.assertTrue(true);
			CuLogin.clcikOnSignOut();
		}else {
			Logger.info("Verify buy product : Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
}