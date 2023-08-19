package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.CreateCustAcctPage;
import com.mystore.pageobject.CustomerLoginPage;
import com.mystore.pageobject.homePage;
import com.mystore.pageobject.myAccount;
import com.mystore.utilities.ReadExcellFile;

import junit.framework.Assert;

public class TC_LoginPageDataDrivenTesting extends BaseClass{
	
	
	private static final String name = null;

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
	
	@Test(dataProvider="LoginDataProvider")
	public void verifyLogin(String userEmail,String userPassword,String expectedUserName) throws IOException {
		
		homePage hp=new homePage(driver);
		CustomerLoginPage CuLogin=new CustomerLoginPage(driver);
		hp.clickOnSignIn();
		CuLogin.enterEmail(userEmail);
		CuLogin.enterPassword(userPassword);
		CuLogin.clickOnSignIn();
		CuLogin.readAccountEmail();
		String ptagcontainemail=driver.findElement(By.tagName("p")).getText();
		if(ptagcontainemail.contains(userEmail)) {
			Logger.info("Verify Login : Passed");
			Assert.assertTrue(true);
			CuLogin.clcikOnSignOut();
		}else {
			Logger.info("Verify login : Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
			
		}
		
		
		
		
	}
	
	
	@DataProvider(name="LoginDataProvider")
	public String [][] LoginDataProvider(){
		
		String filepath="G:\\EclipseWorkspace\\SeleniumFramework\\TestData\\TestCaseData.xlsx";
		int ttlRows=ReadExcellFile.getRowCount(filepath, "LoginTestData");
		int ttlCols=ReadExcellFile.getColCount(filepath, "LoginTestData");
		String data[][]=new String[ttlRows][ttlCols];
		
		for(int i=1;i<ttlCols;i++) {
			for(int j=0;j<ttlCols;j++) {
				data[i-1][j]=ReadExcellFile.getCellValue(filepath, "LoginTestData",i, j);
							
			}
		}
		return data;
		
		
	}
	
	

}
