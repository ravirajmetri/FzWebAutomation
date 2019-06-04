
package com.fieldez.testcases;

	//package com.fieldez.testcases;

	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
    import org.testng.AssertJUnit;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import com.fieldez.pageobjects.LoginPage;
	import com.fieldez.utilities.ExcelUtilities;
import com.fieldez.utilities.ExplicitWaits;
//import com.fieldez.utilities.XLUtils;
	//import com.fieldez.pageobjects.AddCustomerPage;
    import com.fieldez.pageobjects.CreateCallPage;
    import com.fieldez.pageobjects.CreateExpensePage;
    import com.fieldez.pageobjects.CreateExpensePage;;
    
    
	public class TC_Create_Expense extends BaseClass1 {

		SoftAssert softAssert =new SoftAssert();
		
		@Test(dataProvider="DatabaseLogin",priority=1)
		public void LoginTest(String username, String password) throws IOException, InterruptedException
		{  //Implicity Wait for 20 seconds
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
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
	//Thread.sleep(3000);
	// Check Test Case is passed 
   
			
	if(driver.getTitle().equals("FieldEZ"))

	{
	 Assert.assertTrue(true);
	 System.out.println("Fieldez Login Successful");
	 //	test.log(Status.PASS, "Login Successful");
				
	}
	else if(driver.getTitle().equals("Dashboard"))
	{
		
		Assert.assertTrue(true);
	  System.out.println("Fieldez Dashboard Login Successful");
	  //test.log(Status.PASS, "Login Successful");
	}	
			
	else if(driver.getPageSource().contains("Invalid username/password!")) 
	{
     	System.out.println("Inavlid Username and Password");
		Assert.assertTrue(false);
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

	public Object[][] Authentication1() throws Exception{

	Object[][] testObjArray = ExcelUtilities.getTableArray("C:\\Users\\fieldez\\Desktop\\web-automation\\src\\test\\java\\com\\fieldez\\testdata\\FieldezTestData.xlsx","logindata");


	return testObjArray;
	}
	

	@Test(dataProvider="ExpenseData",priority=2)
	public void CreateExpenseTest(String amt1) throws IOException, InterruptedException
	{
		//Implicity Wait for 20 seconds
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
// ----------------------Test Cases 001------------------------------		
	CreateExpensePage cep=new  CreateExpensePage(driver);
	cep.AdvancedLink();
	logger.info("Advanced Link is Clicked");
	cep.ExpenseLink();
	logger.info("Expense Link is clicked");	
	//Thread.sleep(2000);
	cep.CreateExpense();
	//Thread.sleep(2000);
	logger.info("Create Expense is Clicked");

	if(driver.getTitle().contains("Expense List")) {
		softAssert.assertTrue(true,"Add Expense page loaded successful");
		//System.out.println("Add Expense page loaded successful");
		logger.info("T001-Pass");	
	   }
	else
	{	
		softAssert.assertTrue(false,"Add Expense page not loaded");
		//System.out.println("page is not loaded");
		logger.error("T001-Fail");
		softAssert.assertAll();
	}
	
// -----------------------Test Cases 001 Completed	
	
	
// ------------------------Test Cases 002 Start	
	    
	
	    cep.AddLineItem();
	    Thread.sleep(2000);
	    if(driver.getPageSource().contains("Expense Type"))
	    {
			AssertJUnit.assertTrue(true);
			logger.info("T002-Pass");	
		}
		else
		{	
			AssertJUnit.assertTrue(false);
			logger.error("T002-Fail");	    
		}
// ------------------------Test Cases 002 Completed
	    
	    	    
// ------------------------Test Cases 003 Start	    
	    cep.selectFoodTravel();
	    Thread.sleep(2000);
	    if(driver.getPageSource().contains("Paid By"))
	    {
			AssertJUnit.assertTrue(true);
			logger.info("T003-Pass");	
		}
		else
		{	
			AssertJUnit.assertTrue(false);
			logger.error("T003-Fail");
		}
	    
			
// ------------------------Test Cases 003 Completed
	    
	
//----------------------Test Cases 004 Start-- Is Save Button Disabled----
	    boolean save = driver.findElement(By.xpath("//button[@class='btn btn-prime disabled']")).isEnabled();
	      if(save==false)
	      {
	    	  logger.info("Save Line Item Button is disabled");
	    	  logger.info("TC004-----> Pass");
	      }
	      else
	      {
	    	  logger.info("Save Line Item Button is Enabled");
	    	  logger.info("TC004-----> Fail");
	      }
//----------------------Test Cases 005 Start-- Is Save Button Enabled----	  
	      
	  cep.PaidBy();
	  cep.Amount(amt1);
	  boolean fname = driver.findElement(By.xpath("//div[@class='col-sm-9 footer-btn-section form-group']//button[@class='btn btn-prime'][contains(text(),'Save')]")).isEnabled();
      if(fname==true)
      {
    	  logger.info("TC - 007Save Line Item Button is enabled");
      }
      else
      {
    	  logger.info("Save Line Item Button is disbaled");
      }
    	  
	  cep.savebuttonEnabled();
	  logger.info("Line item saved");
	  Thread.sleep(1000);
	  cep.clickDatePicker();
	  logger.info("Clicked on Calendar");
	  Thread.sleep(3000);
	  
	  cep.SelectExpenseDate();
	  logger.info("Selected Date");
	 // Thread.sleep(3000);
	  
	  cep.SubmitExpense();
	  Thread.sleep(3000);
	  Alert alert=driver.switchTo().alert();
	  alert.accept();
	  Thread.sleep(3000);
	
	}
		
	@DataProvider(name="ExpenseData")
	public Object[][] Authentication() throws Exception
	{
    
	Object[][] testObjArray = ExcelUtilities.getTableArray("C:\\Users\\fieldez\\Desktop\\web-automation\\src\\test\\java\\com\\fieldez\\testdata\\FieldezTestData.xlsx","ExpenseData");
	return testObjArray;
	
	}
	
	
	
////====================================Test Cases 008 Start========================================================
	
	@Test(dataProvider="ExpenseDataTravel",priority=4,enabled=false)
	public void CreateExpenseTestTarvel(String rate, String kms ) throws IOException, InterruptedException
	{
	
	CreateExpensePage cep=new  CreateExpensePage(driver);
	cep.AdvancedLink();
	logger.info("Advanced Link is Clicked");
	cep.ExpenseLink();
	logger.info("Expense Link is clicked");
	Thread.sleep(2000);
	cep.CreateExpense();
	Thread.sleep(2000);
	logger.info("Create Expense is Clicked");

	if(driver.getPageSource().contains("Select Calls For This Expense")) {
		Assert.assertTrue(true);
		System.out.println("Add Expense page loaded successful");
		logger.info("T008-Select Calls Pass");	
	   }
	else
	{	
		Assert.assertTrue(false);
		System.out.println("page is not loaded");
		logger.error("T008-Select Calls Fail");
	}
	
	    
	
	    cep.AddLineItem();
	    Thread.sleep(2000);
	    if(driver.getPageSource().contains("Expense Type"))
	    {
			Assert.assertTrue(true);
			logger.info("Add Line Item Page Loaded");	
		}
		else
		{	
			Assert.assertTrue(false);
			logger.error("Add Line Item Page Not Loaded");	    
		}
  
	    cep.selectTravel();
	    Thread.sleep(2000);
	    if(driver.getPageSource().contains("Paid By"))
	    {
			Assert.assertTrue(true);
			logger.info("Selection of Travel is success");	
		}
		else
		{	
			Assert.assertTrue(false);
			logger.error("Selection Travel failed");
		}

//==================================Test Case 7 Start-- Is Save Button Disabled=============================
	    
	    boolean save = driver.findElement(By.xpath("//button[@class='btn btn-prime disabled']")).isEnabled();
	      if(save==false)
	      {
	    	  logger.info("TC 007 --> Save Line Item Button is disabled--> Pass");
	    	 // logger.info("TC004-----> Pass");
	      }
	      else
	      {
	    	  logger.info("TC 007---> Save Line Item Button is Enabled ---> Fail");
	    	//  logger.info("TC004-----> Fail");
	      }
	      
//===================================Test Case 7 Completed ===========================================
	      
	  cep.PaidBy();
	  cep.Mode();
	  cep.Location();
	  cep.Rate(rate);
	  cep.Distance(kms);
	  boolean fname = driver.findElement(By.xpath("//div[@class='col-sm-9 footer-btn-section form-group']//button[@class='btn btn-prime'][contains(text(),'Save')]")).isEnabled();
      if(fname==true)
      {
    	  logger.info("Save Line Item Button is enabled");
      }
      else
      {
    	  logger.info("Save Line Item Button is disbaled");
      }
    	  
	  cep.savebuttonEnabled();
	  logger.info("Line item saved");
	  Thread.sleep(1000);
	  
	  
//============================Test Case 9 Started========================================================	  
	  
	  boolean submit = driver.findElement(By.xpath("//button[@id='step5']")).isEnabled();
	  
      if(submit==false)
      {
    	  logger.info("TC0009--->Save Line Item Button is Not enabled--> Pass");
      }
      else
      {
    	  logger.info("TC0009 --->Save Line Item Button is enabled--> Fail");
      }
      
//============================Test Case 9 Completed ====================================================	
	 
      cep.clickDatePicker();
	  logger.info("Clicked on Calendar");
	  Thread.sleep(3000);
	  
//============================Test Case 10 Started=======================================================  
	  
	  boolean finalsubmit = driver.findElement(By.xpath("//button[@id='step5']")).isEnabled();
      if(finalsubmit==true)
      {
    	  logger.info("TC0010--->Submit Expens is Enabled-> Pass");
      }
      else
      {
    	  logger.info("TC0010--->Submit Expens is not enabled-> Fail");
      }
	  
//============================Test Case 10 Completed======================================================	
      
	  cep.SelectExpenseDate();
	  logger.info("Selected Date");
	 // Thread.sleep(3000);
	  
	  cep.SubmitExpense();
	  Thread.sleep(3000);
	  Alert alert=driver.switchTo().alert();
	  alert.accept();
	  Thread.sleep(3000);
	
	}
		
	@DataProvider(name="ExpenseDataTravel")
	public Object[][] Authentication2() throws Exception
	{
    
	Object[][] testObjArray = ExcelUtilities.getTableArray("C:\\Users\\fieldez\\Desktop\\web-automation\\src\\test\\java\\com\\fieldez\\testdata\\FieldezTestData.xlsx","ExpenseDataTravel");
	return testObjArray;
	
	}
	
////====================================Test Cases 013 Start========================================================
	
	@Test(priority=5,enabled=false)
	public void TC_13_CreateExpenseTestCancelLineItem() throws IOException, InterruptedException
	{
	
	CreateExpensePage cep=new  CreateExpensePage(driver);
	cep.AdvancedLink();
	logger.info("Advanced Link is Clicked");
	
	cep.ExpenseLink();
	logger.info("Expense Link is clicked");	
	Thread.sleep(2000);
	
	cep.CreateExpense();
	Thread.sleep(2000);
	logger.info("Create Expense is Clicked");
	

	cep.AddLineItem();
	Thread.sleep(2000);
  
	cep.selectTravel();
	Thread.sleep(2000);
	    

//==================================Test Case 13 Start-- Cancel Button is enable or disabled=============================
	    
	    boolean save = driver.findElement(By.xpath("//div[@class='col-sm-9 footer-btn-section form-group']//button[@class='btn btn-cancel'][contains(text(),'Cancel')]")).isEnabled();
	      if(save==true)
	      {
	    	  logger.info("TC 013 --> Cancel Button in Line Item Button is Enabled--> Pass");
	    	
	      }
	      else
	      {
	    	  logger.info("TC 013 --> Cancel Button in Line Item Button is Enabled--> Pass");
	    	
	      }
	      
//===================================Test Case 13 Completed ===========================================
	      
	  cep.CancelLineItem();
	  logger.info("Line item Cancelled");
	  Thread.sleep(1000);
	  
	} 

//===================================Test Case 14 Started ===========================================
	
	@Test(priority=7,enabled=false)
	public void TC_14_CreateExpenseTestCancelExpense() throws IOException, InterruptedException
	{
	
	CreateExpensePage cep=new  CreateExpensePage(driver);
	cep.AdvancedLink();
	logger.info("Advanced Link is Clicked");
	
	cep.ExpenseLink();
	logger.info("Expense Link is clicked");	
	Thread.sleep(2000);
	
	cep.CreateExpense();
	Thread.sleep(2000);
	logger.info("Create Expense is Clicked");
	    
	      
	 cep.CancelExpense();
	 logger.info("Expense Cancelled");
	 Thread.sleep(1000);
	  
	} 

//===================================Test Case 14 Completed ===========================================
	
	
//===================================Test Case 15 Started ===========================================	
	
	@Test(priority=8,enabled=false)
	public void TC_15_CreateExpenseTestCancelLineItem() throws IOException, InterruptedException

	{
	
	CreateExpensePage cep=new  CreateExpensePage(driver);
	cep.AdvancedLink();
	logger.info("Advanced Link is Clicked");
	
	cep.ExpenseLink();
	logger.info("Expense Link is clicked");	
	Thread.sleep(2000);
	
	cep.CreateExpense();
	Thread.sleep(2000);
	logger.info("Create Expense is Clicked");
	    
	      
	 cep.CancelLineItem();
	 logger.info("Line item Cancelled");
	 Thread.sleep(1000);
	  
	} 
	
//===================================Test Case 15 Completed ===========================================	

	
//===================================Test Case 16 Started ===========================================
	
	@Test(priority=9,enabled=false)
	public void TC_16_CreateExpenseTestViewInfo() throws IOException, InterruptedException
	{
	
	CreateExpensePage cep=new  CreateExpensePage(driver);
	cep.AdvancedLink();
	logger.info("Advanced Link is Clicked");
	
	cep.ExpenseLink();
	logger.info("Expense Link is clicked");	
	Thread.sleep(2000);
	
	cep.CreateExpense();
	Thread.sleep(2000);
	logger.info("Create Expense is Clicked");
	  
	 cep.AddLineItem();
	 Thread.sleep(2000);
	       
	 cep.selectFoodTravel();			  
	 cep.PaidBy();
	 cep.Static_Amount();
	  
	  cep.savebuttonEnabled();
	  logger.info("Line item saved");
	  Thread.sleep(1000);
	  
	  cep.viewInfoicon();
	  logger.info("Clicked View Info Icon");
	 
	  
	  if(driver.getPageSource().contains("Claimed Amount"))
	    {
			Assert.assertTrue(true);
			logger.info("View Info Pop is loaded");	
			logger.info("TC 016 -----Pass");	
		}
		else
		{	
			Assert.assertTrue(false);
			logger.error("View Info Pop is not loaded");
			logger.info("TC 016  ---Fail");	
		}
  	 
	} 

//===================================Test Case 16 Completed ===========================================	

	
//===================================Test Case 17 Started ===========================================	
	
	
	@Test(priority=10,enabled=false)
	public void TC_17_CreateExpenseTestViewInfoClose() throws IOException, InterruptedException
	{
	
	CreateExpensePage cep=new  CreateExpensePage(driver);
	cep.AdvancedLink();
	logger.info("Advanced Link is Clicked");
	
	cep.ExpenseLink();
	logger.info("Expense Link is clicked");	
	Thread.sleep(2000);
	
	cep.CreateExpense();
	Thread.sleep(2000);
	logger.info("Create Expense is Clicked");
	    
	  
	 cep.AddLineItem();
	 Thread.sleep(2000);
	       
	 cep.selectFoodTravel();			  
	
	 cep.PaidBy();
	
	 cep.Static_Amount();
	  
	 cep.savebuttonEnabled();
	 logger.info("Line item saved");
	 Thread.sleep(1000);
	  
	 cep.CloseViewInfoicon();
	 logger.info("Closed View Info Icon");
	 
	  
	 if(driver.getPageSource().contains("Employee"))
	 {
	    Assert.assertTrue(true);
	    logger.info("View Info Pop up is Closed");	
	    logger.info("TC 017 -----Pass");	
      }
	else
	{	
		Assert.assertTrue(false);
		logger.error("View Info Pop up is not Closed");
		logger.info("TC 017  ---Fail");	
	 }
  	 
	} 
//===================================Test Case 17 Completed ===========================================	
	
//===================================Test Case 18 Started    ===========================================	
	@Test(priority=10,enabled=false)
	public void TC_18_CreateExpenseDeleteLineItem() throws IOException, InterruptedException
	{
	
	CreateExpensePage cep=new  CreateExpensePage(driver);
	cep.AdvancedLink();
	logger.info("Advanced Link is Clicked");
	
	cep.ExpenseLink();
	logger.info("Expense Link is clicked");	
	Thread.sleep(2000);
	
	cep.CreateExpense();
	Thread.sleep(2000);
	logger.info("Create Expense is Clicked");
	    
	  
	 cep.AddLineItem();
	 Thread.sleep(2000);
	       
	 cep.selectFoodTravel();			  
	 cep.PaidBy();
	 cep.Static_Amount();
	  
	  cep.savebuttonEnabled();
	  logger.info("Line item saved");
	  Thread.sleep(1000);
	  
	  cep.DeleteLineItemIcon();
	  logger.info("Deleted Line Item");
	 
	  
	  if(driver.getPageSource().contains("No line item to display"))
	    {
			Assert.assertTrue(true);
			logger.info("View Info Pop is loaded");	
			logger.info("TC 016 -----Pass");	
		}
		else
		{	
			Assert.assertTrue(false);
			logger.error("View Info Pop is not loaded");
			logger.info("TC 016  ---Fail");	
		}
  	 
	} 
//===================================Test Case 17 Completed ===========================================		
	} 


