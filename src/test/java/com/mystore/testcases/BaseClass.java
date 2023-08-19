package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass<JavaScriptExecutor> {
	
	ReadConfig readconfig=new ReadConfig();
	
	String url=readconfig.getBaseUrl();
	String browser=readconfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger Logger;
	
	@BeforeClass
	public void setup() {
		
	switch(browser.toLowerCase()) {
			
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			driver=null;
			break;
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Logger=LogManager.getLogger("SeleniumFramework");
		
		
		driver.get(url);
		Logger.info("url opened");
		
	}
	
	
//	@AfterClass
//	public void tearDown() {
//		driver.close();
//		driver.quit();
//	}
//	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException 
	{
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File ("./ScreenShots/ScreenShots"+testName+".png");
		FileUtils.copyFile(src, dest);		
	}
	
	
}
