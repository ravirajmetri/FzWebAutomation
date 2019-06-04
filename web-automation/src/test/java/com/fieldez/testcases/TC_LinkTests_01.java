package com.fieldez.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fieldez.pageobjects.AddCustomerPage;
import com.fieldez.pageobjects.LinkPages;
import com.fieldez.pageobjects.LoginPage;
import com.fieldez.utilities.ExcelUtilities;

public class TC_LinkTests_01 extends BaseClass1 {
	
	
	//LinkPages lpages = new LinkPages(driver);
	 
	@Test(dataProvider="DatabaseLogin1",priority=1)
	  public void LoginTest(String username, String password) throws IOException, InterruptedException
	  
	  {
	 
	 //ExtentHtmlReporter reporter=new ExtentHtmlReporter("E:\\SVN\\FZ_Web_Automation_1.0\\com.fieldez.webautomation\\Reports\\AdvancedReports.html"); //ExtentReports extent = new ExtentReports(); //ExtentTest
	// test=extent.createTest("LoginTestcc"); //logger.info("URL is launched");
	 
      LoginPage lp = new LoginPage(driver);
	  lp.setUserName(username);
	 //logger.info("Entered the username");
	 
	  
	 
	lp.setPassword(password); //logger.info("Entered the password");
	  
	 
	  
	  lp.clickSubmit(); //test.log(Status.INFO, "Login to fieldez");
	  
	  
	  
	  //logger.info("Logging into application"); Thread.sleep(10000); // Check Test Case is passed
	  
	  if(driver.getTitle().equals("FieldEZ"))
	  
	  { 
		  AssertJUnit.assertTrue(true); System.out.println("Fieldez Login Successful"); //
	 
	 // test.log(Status.PASS, "Login Successful");
	  
	  } 
	  else if(driver.getTitle().equals("Dashboard"))
	  {
	  System.out.println("Fieldez Dashboard Login Successful");
	  //test.log(Status.PASS, "Login Successful"); }
	  }
	  
	  else if(driver.getPageSource().contains("Invalid username/password!")) 
	  {
	  System.out.println("Inavlid Username and Password");
	  AssertJUnit.assertTrue(false); 
	  } 
	  else 
	  {
	  System.out.println("Fieldez Login is Not Successful");
	  AssertJUnit.assertTrue(false);
	  } 
	  
	 } 
	  //BaseClass bc = new BaseClass();
	  //bc.captureScreen(driver,"LoginTest");
	  
	  // logger.error("Login Test Case Failed");
	  
	  //extent.flush(); }
	  
	  @DataProvider(name="DatabaseLogin1")
	  
	  public Object[][] Authentication() throws Exception{
	  
	  Object[][] testObjArray = ExcelUtilities.getTableArray("E:\\SVN\\FZ_Web_Automation_1.0\\com.fieldez.webautomation\\src\\test\\java\\com\\fieldez\\testdata\\FieldezTestData.xlsx","logindata");
	  
	  

	  return testObjArray;
	  
	  }
	  
	
	 @Test(priority=2,enabled=true)
	  public void CallsLinksTest() throws InterruptedException
	  { 
		 try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickcalls();
		 System.out.println("Click calls is passed");
		 }
		 
		 catch (Exception e) 
		 {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		 }
			
      }
	
	 
	 
	 @Test(priority=3,enabled=true)
	  public void CustomerLinksTest() throws InterruptedException
	  { 
	try {
		//LinkPages lpages = new LinkPages(driver);
		LinkPages lpages = new LinkPages(driver);
		 lpages.clickCustomer();
		 System.out.println("Click customer is passed");
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	  } 
		 
	 @Test(priority=4,enabled=true)
	  public void ProductLinksTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickProduct();
		 System.out.println("Click Product is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	  } 
	 
	 @Test(priority=5,enabled=true)
	  public void AssetLinksTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		lpages.clickAsset();
		 System.out.println("Click Asset is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	  } 
	 
	 @Test(priority=6,enabled=true)
	  public void InvoiceLinksTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickInvoice();
		 System.out.println("Click Invoice is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	  } 
	 
	 @Test(priority=7,enabled=true)
	  public void InvoiceDashboardTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		lpages.clickInvoiceDashboard();
		 System.out.println("Click Invoice Dashboard is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 
	 
	 @Test(priority=8,enabled=true)
	  public void QuotesLinkTest() throws InterruptedException
	  { 
	try {
		LinkPages lpages = new LinkPages(driver);
		lpages.ClickQuotes();
		 System.out.println("Click Quotes is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 
	 
	 
	 @Test(priority=9,enabled=true)
	  public void AttendanceLinkTest() throws InterruptedException
	  { 
	try {
		LinkPages lpages = new LinkPages(driver);
		lpages.clickAttendance();
		 System.out.println("Click Attendance is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 
	 
	 @Test(priority=10,enabled=true)
	  public void LeaveLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickLeave();
		 System.out.println("Click leave is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 
	 
	 
	 @Test(priority=11,enabled=true)
	  public void EffortLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickEffort();
		 System.out.println("Click Effort is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 
	 @Test(priority=12,enabled=true)
	  public void MessageBoardLink() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.messageboard();
		 System.out.println("Message Board link is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 
	 
	 @Test(priority=12,enabled=true)
	  public void CustReportsLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickCustomReports();
		 System.out.println("Click CustomeReports is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 
	 
	 
	 
	 @Test(priority=14,enabled=true)
	  public void LineitemReportsLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickLineItemReports();
		 System.out.println("Click Line Item Reports is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		
		}
	
	  } 
	 
	 @Test(priority=15,enabled=true)
	  public void AttednaceReportsLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickattendanceReports();
		 System.out.println("Click Attendance Reports is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
	
	  } 
	 
	 @Test(priority=16,enabled=true)
	  public void ReportsbetaLinkTest() throws InterruptedException
	  { 
	try {
		      LinkPages lpages = new LinkPages(driver);
		      lpages.clickReportsbeta();
		      System.out.println("Click Reports Beta is passed");
		 
		/*String actualtitle =lpages.getTitle();
		String expectedTitle ="Reports";
		System.out.println("Title is"+actualtitle);
		Assert.assertEquals(actualtitle, expectedTitle);*/
		
		       if(driver.getPageSource().contains("Reports"))
		    {
		    	   
		    	   
			   AssertJUnit.assertTrue(true);
			   System.out.println("Reports is Successful");
		    }
               else
		    {
		    	  
			System.out.println("Reports is not Successful");
			AssertJUnit.assertTrue(false);
			
			}
		
		
		// Assert.assertNotNull(lpages.ReportsBeta);
		// assertThat(title, Reports );
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
	
	  } 
	 
	 
	 @Test(priority=17,enabled=true)
	  public void DayviewschedulerLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickScheduleDay();
		 System.out.println("Click Daily View is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 
			 
			 
	 @Test(priority=19,enabled=true)
	  public void weekviewschedulerLinkTest() throws InterruptedException
	  { 
		 try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickScheduleWeek();
		 System.out.println("Click Week View is passed");
		 }	
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	  } 
			 
			 
	 @Test(priority=18,enabled=true)
	  public void daymapschedulerLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickScheduleDayMap();
		 System.out.println("Click Day Map View is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 	
	 
	 
	 
	 @Test(priority=20,enabled=true)
	  public void BeatplanLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickBeatPlan();
		 System.out.println("Click Beat plan is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 	
	 
	 @Test(priority=21,enabled=true)
	  public void ExpenseLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickExpense();
		 System.out.println("Click Expense is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 	
	 
	 
	 @Test(priority=22,enabled=false)
	  public void HelpLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		  lpages.ClickHelp();
		 System.out.println("Click Help link is passed");
		 
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 	
			 
			
			
	 @Test(priority=23,enabled=true)
	  public void ManageUserLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickManageUser();
		 System.out.println("Click Manage user link is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 	
			
			
	 @Test(priority=24,enabled=true)
	  public void ManageRolesLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickManageRoles();
		 System.out.println("Click Manage Roles link is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 		
			
		
	 @Test(priority=25,enabled=true)
	  public void ManagePermissionLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		 lpages.clickManagePermissions();
		 System.out.println("Click Manage Permission link is passed");
		 
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 		
	 
		
	 @Test(priority=26,enabled=true)
	  public void AdvanceSettingsLinkTest() throws InterruptedException
	  { 
	try {
		 LinkPages lpages = new LinkPages(driver);
		lpages.ClickAdvanceSettings();
		 System.out.println("Click Advance settings link is passed");
		// Assert.assertTrue(Content.equals(ExcelData));
		
	}
	
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	  } 		
			
			
			
}			 
			 

