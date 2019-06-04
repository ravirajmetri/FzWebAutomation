        package com.fieldez.testcases;

	    import org.testng.annotations.Test;
    import org.testng.asserts.SoftAssert;
    import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
    import org.testng.AssertJUnit;
	import java.io.IOException;
	import org.testng.Assert;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import com.fieldez.pageobjects.LoginPage;
	import com.fieldez.utilities.ExcelUtilities;
    import com.fieldez.utilities.Utility;
    import com.fieldez.pageobjects.CreateCallPage;
    
	    public class TC_CreateCallTest_003 extends BaseClass1{
		
		SoftAssert softAssert =new SoftAssert();
		String Screen;
		
		@Test(dataProvider="DatabaseLogin",priority=1)
		public void LoginTest(String username, String password) throws IOException, InterruptedException
		{  
	       //ExtentHtmlReporter reporter=new ExtentHtmlReporter("E:\\SVN\\FZ_Web_Automation_1.0\\com.fieldez.webautomation\\Reports\\AdvancedReports.html");
	       //ExtentReports extent = new ExtentReports();
	       //ExtentTest test=extent.createTest("LoginTestcc");
		   //logger.info("URL is launched");
	       
			LoginPage lp = new LoginPage(driver);
			lp.setUserName(username);
			logger.info("Entered the username");	
			
			lp.setPassword(password);
			logger.info("Entered the password");
			
			lp.clickSubmit();
			//test.log(Status.INFO, "Login to fieldez");
			logger.info("Logging into application");
			Thread.sleep(10000);
			// Check Test Case is passed 
			
			
			if(driver.getTitle().equals("FieldEZ"))
			{
				Assert.assertTrue(true);
				System.out.println("Fieldez Login Successful");
			    //test.log(Status.PASS, "Login Successful");	
			}
			
			else if(driver.getTitle().equals("Dashboard"))
			{
				System.out.println("Fieldez Dashboard Login Successful");
				Assert.assertTrue(true);
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
				Assert.assertTrue(false);		
		    }
			
			//extent.flush();
		}
		
		
		// Data Provider to Fetch the Data from Excel Sheet
		@DataProvider(name="DatabaseLogin")
	    public Object[][] Authentication1() throws Exception
		{        
			Object[][] testObjArray = ExcelUtilities.getTableArray("C:\\Users\\fieldez\\git\\repository\\web-automation\\src\\test\\java\\com\\fieldez\\testdata\\FieldezTestData.xlsx","logindata");
		    return testObjArray;
	    }


		@Test(dataProvider="CreateCallData",priority=2,enabled=true)
		public void CreateCallTest(
				
				// Need to pass call number string for manual entry of call number
				
				String Customerfirstn,
				String City,
				String Customermn,
				String Customerln,
				String CustAddress1,
				String CustAddress2,
				String state,
				String customerId,
				String primaryNo,
				String emailID,
				String orgName,
				String subOrg,
				String customerType,
				String problemDescription,
				String productName,
				//String modelName,
				String productSerialNO,
				String warrrantyType,
				String specialInstructions,
				String remarks) throws IOException, InterruptedException
		
		{
			//driver.navigate().to("http://qa.fieldez.com/emob/private/customerList.action#/");
			//logger.info("Customer page");
			
			CreateCallPage ccp = new CreateCallPage(driver);
			
			ccp.callnumber();
			logger.info("Entered the call number");
			
			//---Entered the Customer First Name
			ccp.EnterCustomerFirstName(Customerfirstn);
			logger.info("Entered the call number");
			
			
			//---Entered the City Name
			ccp.EnterCity(City);
			logger.info("Entered the City Name");
			
			//---Entered Middle Name of Customer
			ccp.EnterCustomerMiddleName(Customermn);
			logger.info("Entered the Middle Name");
			
			//---Entered last Name of Customer
			ccp.EnterCustomerLastName(Customerln);
			logger.info("Entered the last Name");
			
			//---Entered Address 1 of Customer
			ccp.EnterCustomerAddres1(CustAddress1);
			logger.info("Entered the Address 1 of Customer");
			
			//---Entered Address 2 of Customer			
			ccp.EnterCustomerAddres2(CustAddress2);
			logger.info("Entered Address 2 of Customer");
			
			//---Select the Country of Customer	
			ccp.EnterCountry();
			logger.info("Selected the Country of Customer");
			
			//---Select the State of Customer
			ccp.EnterState(state);
			logger.info("Entered the State of Customer");
			
			//---Id of Customer
			ccp.EnterCustomerId(customerId);
			logger.info("Entered the Id of Customer");
			
			//---Primary No of Customer
			ccp.EnterPrimaryNo(primaryNo);
			logger.info("Entered the Primary No of Customer");
			
			//--- Email id of Customer
			ccp.EnterEmailid(emailID);
			logger.info("Entered The email id");
			
			//----- Org Name of the Customer
			ccp.EnterOrgName(orgName);
			logger.info("Entered Org Name");
			
			//----- Sub Org of the Customer
			ccp.EnterSubOrg(subOrg);
			logger.info("Entered Sub Org Name");
			
			//----- Customer Type of the Customer
			ccp.CustomerType(customerType);
			logger.info("Entered Customer Type");
			
			
			//----- Problem Description of the Call
			ccp.ProblemDesc(problemDescription);
			logger.info("Entered the Problem Description of the Call");
			
			//-----Product Name
			ccp.ProductName(productName);
			logger.info("Entered the product Name of the Call");
			
			//-----Product Serial Number
			ccp.ProductSerialNo(productSerialNO);
			logger.info("Entered the product Name of the Call");
			
			//-----Warranty Type
			ccp.WarrantyType(warrrantyType);
			logger.info("Entered the Warranty Type of the Call");
			
			//-----Special Instructions
			ccp.SepcialInstructions(specialInstructions);
			logger.info("Entered the Special Instructions of the Call");
			
			//-----Remarks of the call 
			ccp.Remarks(remarks);
			logger.info("Entered the Remarks of the Call");
					
			//-----Save the Call
			ccp.saveCreateCall();
			logger.info("Saved the call successfully");
			
			
			// Assertion Condition to verify the call is created successfully or not
			if(driver.getPageSource().contains("Sales Workflow"))
			{
			 	softAssert.assertTrue(true,"Call Created Succesfully");
				logger.info("T001-Pass- Call Create Successfully");	
				logger.info("T001-Pass- Call pass Successfully");
				
				logger.info("T001-Pass- Call pass Successfully");
				//extent.createTest("Create Call Test Case").pass("Test Passed");
				//extent.flush();
				
			}
			
			else
			{	Utility.getScreenshot(driver, "Create_Call_Failed");
				softAssert.assertTrue(false,"Call Not Created");	
				logger.error("T001-Fail- Call Not Created");	
				extent.createTest("Create Call Test Case").fail("Test Failed");
				//extent.flush();
				softAssert.assertAll();
			}
		
		
		}
		
		//---- DataProvider of the Create Call From Excel Sheet
		@DataProvider(name="CreateCallData")
		public Object[][] Authentication3() throws Exception
		{
	        Object[][] testObjArray = ExcelUtilities.getTableArray("C:\\Users\\fieldez\\git\\repository\\web-automation\\src\\test\\java\\com\\fieldez\\testdata\\FieldezTestData.xlsx","CreateCallData");
      		return testObjArray;
	    }
		
		// Call Level Attachments Upload
		@Test(priority=3,enabled=true)
		public void UploadCallLevelAttachments() throws IOException, InterruptedException
		
		{
			//CreateCallPage ccp1 = new CreateCallPage(driver);
			CreateCallPage ccp1 = new CreateCallPage(driver);
			ccp1.SaveAttachments();
			logger.info("Call Details Page Loaded successfully");
			
			if(driver.getPageSource().contains("darjeeling.jpg")) 
			{
				softAssert.assertTrue(true);
				System.out.println("Call level attachments uploaded successfully");
				logger.info("T002-Pass");	
			}
			
			else
			{	
				softAssert.assertTrue(false);
				System.out.println("");
				logger.error("T002-Fail");
				softAssert.assertAll();
			}
			
			//Will Update the Test Cases Fail in Extent Reports
			
	
		}
		
  } 


