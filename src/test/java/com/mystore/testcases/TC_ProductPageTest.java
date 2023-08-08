package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.CreateCustAcctPage;
import com.mystore.pageobject.CustomerLoginPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.homePage;
import com.mystore.pageobject.myAccount;

import junit.framework.Assert;

public class TC_ProductPageTest extends BaseClass {
	
	@Test(enabled=true)
	public void verifySearchResult() throws IOException {
		
		
		homePage hp=new homePage(driver);
		CustomerLoginPage CuLogin=new CustomerLoginPage(driver);
		hp.clickOnSignIn();
		CuLogin.enterEmail("teabhinaychougale19@gmail.com");
		CuLogin.enterPassword("testAbhi123");
		CuLogin.clickOnSignIn();
		
		SearchResultPage SearchRePg=new SearchResultPage(driver);
		String entertext="Tee";
		SearchRePg.enterTextInSearchBox_Search(entertext);
		
		if(SearchRePg.getPageContain().contains(entertext)) {
			Logger.info("Verify Searched product : Passed");
			Assert.assertTrue(true);
			CuLogin.clcikOnSignOut();
		}else {
			Logger.info("Verify Searched product : Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}

	}
	
}
