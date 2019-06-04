package com.fieldez.pageobjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

	public class LinkPages {
		
			//Driver object
		    WebDriver ldriver; //local driver
		    
		    //Constructor LoginPage
			public LinkPages(WebDriver rdriver)
		  {
				//Initiate the drivers ,Remote Driver
				ldriver=rdriver; 
				
				//PageFactory Class  //This initElements method will create all WebElements
				PageFactory.initElements(rdriver, this); 
				
				//ldriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  }
			
			
		     // Add Login Elements here in this Class
		    // Web Elements are identified by "FindBy" Annotation
		    
		    // Calls Tab Link
		    @FindBy(xpath=".//*[@id='callTab']/a")
			@CacheLookup
			WebElement Calls;
			

		 // Calls Tab WorkFlow Link
		    @FindBy(xpath=".//*[@id='3690']/a/span")
			@CacheLookup
			WebElement CallsWorkflow;
		    
		    // Customer link
			@FindBy(xpath=".//*[@id='bs-example-navbar-collapse-1']/ul[1]/li[2]/a")
			@CacheLookup
			WebElement Customer;
			
			//Product Header Link
			@FindBy(xpath="//a[contains(@href, 'productList.action#/') and @class='dropdown-toggle']")
			@CacheLookup
			WebElement ProductHeader;
			
			
			
			//Product Link
			@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']/ul/li[3]/ul/li/a/span")
			@CacheLookup
			WebElement Product;
			
			//Asset link
			@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']/ul/li[3]/ul/li[2]/a/span")
			@CacheLookup
			WebElement Asset;
			
			
			//Finance Header Link
			@FindBy(xpath=".//a[text()='Finance']")
			@CacheLookup
			WebElement FinanceHeader;
			
			// Invoice Link
			@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']/ul/li[4]/ul/li[1]/a/span")
			@CacheLookup
			WebElement Invoice;
			
			// Quotes Link
			@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']/ul/li[4]/ul/li[2]/a/span")
			@CacheLookup
			WebElement Quotes;
			
			// Invoice Dashboard Link
			@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']/ul/li[4]/ul/li[3]/a/span")
			@CacheLookup
			WebElement InvoiceDashboard;
			
			// Timesheet Link
			@FindBy(xpath="//a[contains(text(),'Timesheet')]")
			@CacheLookup
			WebElement Timesheet;
			
			// Time sheet Attendance Link
			@FindBy(xpath="//a[contains(text(),'Attendance') and @href=\"attendance.history.action#/\"]")
			@CacheLookup
			WebElement TimesheetAttendance;
			
			
			// Time sheet Leave Link
			@FindBy(xpath="/html/body/nav/div/div[2]/ul[1]/li[5]/ul/li[2]/a/span")
			@CacheLookup
			WebElement Timesheetleave;
			
			// Time sheet Effort Link
			@FindBy(xpath="/html/body/nav/div/div[2]/ul[1]/li[5]/ul/li[3]/a/span")
			@CacheLookup
			WebElement TimesheetEffort;
			
			// MessageBoard Link
			@FindBy(xpath="//a[contains(text(),'Message Board')]")
			@CacheLookup
			WebElement MessageBoard;
			
			// Report Link
			@FindBy(linkText="Report")
			@CacheLookup
			WebElement Reports;
			
			// Custom Report Link
			@FindBy(xpath="/html/body/nav/div/div[2]/ul[1]/li[7]/ul/li[1]/a/span")
			@CacheLookup
			WebElement CustomReports;
			
			           // Line Item Report Link
						@FindBy(xpath="/html/body/nav/div/div[2]/ul[1]/li[7]/ul/li[2]/a")
						@CacheLookup
						WebElement LineItemReports;
						
						// Attendance Report Link
						@FindBy(css="li:nth-child(7) li:nth-child(3) span")
						@CacheLookup
						WebElement AttendanceReports;
						
						// Report  Beta Link
						@FindBy(xpath="//a[@href='myReport.action']")
						@CacheLookup
						WebElement ReportsBeta;
			
						//---------------------------------------------------------------------
						

						// Scheduler Link
						@FindBy(linkText="Schedule")
						@CacheLookup
						WebElement Scheduler;
						

						// Scheduler Day View Link
						@FindBy(xpath="//a[@href='dailyscheduler.action']//span[contains(text(),'Day View')]")
						@CacheLookup
						WebElement ScheduleDay;
						
						// Scheduler Week View  Link
						@FindBy(xpath="//span[contains(text(),'Week View')]")
						//@CacheLookup
						WebElement ScheduleWeek;
						
						// Scheduler Day Map View  Link
						@FindBy(xpath="//a[@href='dailyschedulerMap.action']//span[contains(text(),'Day Map View')]")
						@CacheLookup
						WebElement ScheduleDayMap;
						
						// Advanced Link
						@FindBy(linkText="Advanced")
						@CacheLookup
						WebElement Advanced;
						
						
						
						// Beat Plan Link
						@FindBy(xpath="//span[contains(text(),'Beat Plan')]")
						@CacheLookup
						WebElement BeatPlan;
						
						// Expense Link
						@FindBy(xpath="//span[contains(text(),'Expense')]")
						@CacheLookup
						WebElement ExpenseLink;
						
						// Settings
						@FindBy(xpath="//img[@src='../image/setting.png']")
						@CacheLookup
						WebElement Settings;
						

						// Manager User
						@FindBy(xpath="//a[contains(text(),'Manage Users')]")
						@CacheLookup
						WebElement UserList;
						
						// Manage Roles
						@FindBy(xpath="//a[contains(text(),'Manage Roles')]")
						@CacheLookup
						WebElement RoleList;
						
						// Manage Permissions
						@FindBy(xpath="//a[contains(text(),'Manage Permission')]")
						@CacheLookup
						WebElement PermissionList;
						
						// Advance Settings
						@FindBy(xpath="//a[contains(text(),'Advanced Settings')]")
						@CacheLookup
						WebElement AdvanceSettings;
						
						// Help
						@FindBy(xpath="//img[@src='../image/help.png']")
						@CacheLookup
						WebElement Help;
						
						
						
			public void clickcalls() throws InterruptedException
			{
				Calls.click();
				CallsWorkflow.click();
				Assert.assertNotNull(CallsWorkflow);
				Thread.sleep(1000);
			}
			
			public void clickCustomer() throws InterruptedException
			{
				Customer.click();
				Thread.sleep(1000);
				Assert.assertNotNull(Customer);
			}
			
			public void clickProduct() throws InterruptedException
			{
				
				ProductHeader.click();
				Product.click();
				Thread.sleep(1000);
				Assert.assertNotNull(Product);
			}
			
			public void clickAsset() throws InterruptedException
			{
				Customer.click();
				Thread.sleep(1000);
				ProductHeader.click();
				Asset.click();
				Thread.sleep(1000);
			}

			public void clickInvoice() throws InterruptedException
			{
				FinanceHeader.click();
				Invoice.click();
				Thread.sleep(1000);
			}
			public void ClickQuotes() throws InterruptedException
			{   
				
				FinanceHeader.click();
				Quotes.click();
				Thread.sleep(1000);
			}
			public void clickInvoiceDashboard() throws InterruptedException
			{   FinanceHeader.click();
				InvoiceDashboard.click();
				Thread.sleep(1000);
			}
			
			public void clickAttendance() throws InterruptedException
			{   Timesheet.click();
				TimesheetAttendance.click();
				Thread.sleep(1000);
			}
			
			public void clickLeave() throws InterruptedException
			{    Timesheet.click();
				Timesheetleave.click();
				Thread.sleep(1000);
			}
			
			
			public void clickEffort() throws InterruptedException
			{   
				Timesheet.click();
				TimesheetEffort.click();
				Thread.sleep(1000);
			}
			
			public void messageboard() throws InterruptedException
			{   
				
				MessageBoard.click();
				Thread.sleep(1000);
			}
			public void clickCustomReports() throws InterruptedException
			{   
				//ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Reports.click();
				Thread.sleep(2000);
				CustomReports.click();
				Thread.sleep(2000);
			}
			public void clickLineItemReports() throws InterruptedException 
			{   
				//ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Reports.click();
				Thread.sleep(2000);
				LineItemReports.click();
				Thread.sleep(2000);
			}
			
			public void clickattendanceReports() throws InterruptedException 
			{    
				//ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//Thread.sleep(5000);
				Reports.click();
				Thread.sleep(2000);
				AttendanceReports.click();
				Thread.sleep(2000);
			}
			
			
			public  void clickReportsbeta() throws InterruptedException
			{   
				
				Reports.click();
				Thread.sleep(2000);
				ReportsBeta.click();
                 Thread.sleep(2000);	 
			}
			
			
			
			public void clickScheduleDay() throws InterruptedException
			{   Scheduler.click();
				ScheduleDay.click();
				Thread.sleep(3000);
			}
			
			
			public void clickScheduleWeek() throws InterruptedException
			{   //Scheduler.click();
			    Thread.sleep(3000);
			    String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
			    
			 // Execute the Java Script for the element which we find out
			 ((JavascriptExecutor) ldriver).executeScript(js, ScheduleWeek);
			 
		        //Explicitly Wait Condition     
		        //new WebDriverWait(ldriver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Week View')]")));
			    if( ldriver.findElement(By.xpath("//span[contains(text(),'Week View')]"))!= null){
			    	System.out.println("Element is present");
			    	}else{
			    	System.out.println("Element is absent");
			    	} 	

			    if( ldriver.findElement(By.xpath("//span[contains(text(),'Week View')]")).isDisplayed()){
			    	System.out.println("Element is Visible");
			    	}else{
			    	System.out.println("Element is InVisible");
			    	}   
			    
			    ScheduleWeek.click();
				Thread.sleep(3000);  
				Assert.assertNotNull(ScheduleWeek);
			}
			
			
			public void clickScheduleDayMap() throws InterruptedException
			{    //Scheduler.click();
			     Thread.sleep(2000);
			    /* String js1 = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
				    
				 // Execute the Java Script for the element which we find out
				 ((JavascriptExecutor) ldriver).executeScript(js1, ScheduleDayMap);*/
				ScheduleDayMap.click();
				Thread.sleep(1000);
			}
			
			
			public void clickBeatPlan() throws InterruptedException
			{   Advanced.click();
				BeatPlan.click();
				Thread.sleep(1000);
			}
			public void clickExpense() throws InterruptedException
			{   Advanced.click();
			    ExpenseLink.click();
				Thread.sleep(1000);
			}
			public void ClickHelp() throws InterruptedException
			{
				Help.click();
				Thread.sleep(1000);
			}
			
			public void clickManageUser() throws InterruptedException
			{   Settings.click();
			    Thread.sleep(5000);
			  
			    UserList.click();
				Thread.sleep(2000);
				//Assert.assertNotNull(UserList);
			}
			
			
			public void clickManageRoles() throws InterruptedException
			{     Settings.click();
			      Thread.sleep(1000);
				  RoleList.click();
				Thread.sleep(2000);
			}
			
			
			public void clickManagePermissions() throws InterruptedException
			{    Settings.click();
			     Thread.sleep(1000);
				PermissionList.click();
				Thread.sleep(2000);
			}
			
			
			
			public void ClickAdvanceSettings() throws InterruptedException
			{    Settings.click();
			     Thread.sleep(1000);
				 AdvanceSettings.click();
				// Thread.sleep(3000);
			}
			
			
			
					
			
}
