package com.fieldez.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fieldez.pageobjects.LoginPage;
import com.fieldez.utilities.ExcelUtilities;
//import com.fieldez.utilities.XLUtils;
import com.fieldez.pageobjects.AddCustomerPage;
public class TC_AddCustomerTest_0002 extends BaseClass1 {
	

	@Test(dataProvider="DatabaseLogin4",priority=1)
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
		Thread.sleep(10000);
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
	
	@DataProvider(name="DatabaseLogin4")

    public Object[][] Authentication1() throws Exception{

 Object[][] testObjArray = ExcelUtilities.getTableArray("E:\\SVN\\FZ_Web_Automation_1.0\\com.fieldez.webautomation\\src\\test\\java\\com\\fieldez\\testdata\\FieldezTestData.xlsx","logindata");
	
	return testObjArray;
}


	@Test(dataProvider="AddCustomerData5",priority=2)
	public void AddcustomerTest(String Customerfirstname,String Customerlastname) throws IOException, InterruptedException
	
	{
		//driver.navigate().to("http://qa.fieldez.com/emob/private/customerList.action#/");
		//logger.info("Customer page");
		
		AddCustomerPage acp = new AddCustomerPage(driver);
		acp.clickcustomer();
		logger.info("Clicked on Customer Header");
		
		
		acp.Clickcustomerbutton();
		logger.info("Click Add Customer Button");
		
		acp.inputCustomerName(Customerfirstname);
		logger.info("Entered the customer first name");
		
       
		acp.inputCustomerlastName(Customerlastname);
		logger.info("Entered the customer last name");
		
		acp.saveCustomer();
		logger.info("Saved the customer successfully");
	}
	
	
	@DataProvider(name="AddCustomerData5")
	public Object[][] Authentication() throws Exception{

    Object[][] testObjArray = ExcelUtilities.getTableArray("E:\\SVN\\FZ_Web_Automation_1.0\\com.fieldez.webautomation\\src\\test\\java\\com\\fieldez\\testdata\\FieldezTestData.xlsx","AddCustomer");


		
	return testObjArray;
}
} 
