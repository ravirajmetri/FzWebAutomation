package com.fieldez.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.fieldez.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	// Define the common variables for all the test cases
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	// Set Up Method
	@Parameters("browser")
	@BeforeClass
	public void setup(String brw)
	{
		// Log4j Set Up
				logger = Logger.getLogger("Fieldez");
				PropertyConfigurator.configure("Log4j.properties");
				
				
		if(brw.equals("Firefox"))
		{		
		// Set GeckoDriver Property
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		
		//Instantatation the Driver
		driver=new FirefoxDriver();
		}
			
		else if (brw.equals("Chrome"))
	   {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			
			//Instantatation the Driver
			driver=new ChromeDriver();
		}
		
		driver.get(baseURL);
		
		
	}
	
	// Tear Down Method
		@AfterSuite
		public void teardown()
		{
			// Set GeckoDriver Property
			driver.quit();
			
		}
	
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}		
}
