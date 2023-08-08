package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.CreateCustAcctPage;
import com.mystore.pageobject.CustomerLoginPage;
import com.mystore.pageobject.homePage;
import com.mystore.pageobject.myAccount;

import junit.framework.Assert;

public class TC_CreateAccountPageTest extends BaseClass{
	
	
	@Test(enabled=false)
	public void createAnAccount() {
		
		homePage hp=new homePage(driver);
		hp.clickOnCreateAccount();
		
		CreateCustAcctPage crAccP=new CreateCustAcctPage(driver);
		crAccP.firstName("Abhin");
		Logger.info("enter first name");
		crAccP.lastName("cho");
		Logger.info("enter last name");

		crAccP.enterEmail("teabhinaychougale19@gmail.com");
		Logger.info("enter  email");

		crAccP.enterPassword("testAbhi123");
		Logger.info("enter password ");

		crAccP.enterConfirmPassword("testAbhi123");
		crAccP.clickOnCreateAnAccount(); 
		Logger.info("click on create account");
		
		myAccount myAcc=new myAccount(driver);
		Assert.assertTrue(myAcc.confirmRegisteringMessage());
		Logger.info("Registering account successfully");


	}
	
	@Test
	public void verifyLogin() throws IOException {
		
		homePage hp=new homePage(driver);
		CustomerLoginPage CuLogin=new CustomerLoginPage(driver);
		hp.clickOnSignIn();
		CuLogin.enterEmail("teabhinaychougale19@gmail.com");
		CuLogin.enterPassword("testAbhi123");
		CuLogin.clickOnSignIn();
		String userName=CuLogin.getUserName();
		if(userName.equals("Welcome, Abhin cho!")) {
			Logger.info("Verify Login : Passed");
			Assert.assertTrue(true);
		}else {
			Logger.info("Verify login : Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
		
		
		
		
	}
	
	

}
