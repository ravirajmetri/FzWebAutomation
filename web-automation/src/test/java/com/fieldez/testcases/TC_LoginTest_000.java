package com.fieldez.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fieldez.pageobjects.AddCustomerPage;
import com.fieldez.pageobjects.LoginPage;
import com.fieldez.utilities.ExcelUtilities;
import com.fieldez.utilities.Reporting;
import com.fieldez.utilities.XLUtils;

public class TC_LoginTest_000 extends BaseClass1{

	Reporting ObjRep;
	
	@Test(dataProvider="DatabaseLogin")
	public void LoginTest(String username, String password) throws IOException, InterruptedException
	
	{  
		 
//ExtentHtmlReporter reporter=new ExtentHtmlReporter("E:\\SVN\\FZ_Web_Automation_1.0\\com.fieldez.webautomation\\Reports\\AdvancedReports.html");
//ExtentReports extent = new ExtentReports();
//ExtentTest test=extent.createTest("LoginTestcc");
		 //logger.info("URL is launched");
       
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		//logger.info("Entered the username");
		
		
		
		lp.setPassword(password);
		//logger.info("Entered the password");
		
		
		
		lp.clickSubmit();
		//test.log(Status.INFO, "Login to fieldez");
		
		
		
		//logger.info("Logging into application");
		Thread.sleep(3000);
		// Check Test Case is passed 
		
		
		if(driver.getTitle().equals("FieldEZ"))

		{
			AssertJUnit.assertTrue(true);
			System.out.println("Fieldez Login Successful");
		//	test.log(Status.PASS, "Login Successful");
			
		}
		else if(driver.getTitle().equals("Dashboard"))
		{
			System.out.println("Fieldez Dashboard Login Successful");
			//test.log(Status.PASS, "Login Successful");
		}
		
		
		else if(driver.getPageSource().contains("Invalid username/password!")) {
			System.out.println("Inavlid Username and Password");
			AssertJUnit.assertTrue(false);
		}
		else
		{
			
			
			System.out.println("Fieldez Login is Not Successful");
			AssertJUnit.assertTrue(false);
			//BaseClass bc = new BaseClass();
			//bc.captureScreen(driver,"LoginTest");
			
		//	logger.error("Login Test Case Failed");
			
	    }
		//extent.flush();
	}
	
	@DataProvider(name="DatabaseLogin")

    public Object[][] Authentication() throws Exception{

         Object[][] testObjArray = ExcelUtilities.getTableArray("E:\\SVN\\FZ_Web_Automation_1.0\\com.fieldez.webautomation\\src\\test\\java\\com\\fieldez\\testdata\\FieldezTestData.xlsx","logindata");


		
	return testObjArray;
}
}
	
	