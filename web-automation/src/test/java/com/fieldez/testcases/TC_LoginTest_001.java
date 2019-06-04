package com.fieldez.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.fieldez.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws IOException
	
	{
		
		logger.info("URL is launched");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered the username");
		
		lp.setPassword(password);
		logger.info("Entered the password");
		
		lp.clickSubmit();
		logger.info("Logging into application");
		
		// Check Test Case is passed 
		if(driver.getTitle().equals("FieldEZ"))

		{
			AssertJUnit.assertTrue(true);
			System.out.println("Fieldez Login Successful");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			AssertJUnit.assertTrue(false);
			//System.out.println("Fieldez Login Successful");
			System.out.println("Fieldez Login is Not Successful");
			logger.error("Login Test Case Failed");
	    }
		
		
		/*try {
	    String actualTitle = "FieldEZ";
		Assert.assertEquals(driver.getTitle(), actualTitle);
		}
		catch(Exception e)
		{
			captureScreen(WebDriver driver, String tname)
			System.out.println("Fieldez Login Successful"+ e.getMessage());
			
		}*/
	}

}
