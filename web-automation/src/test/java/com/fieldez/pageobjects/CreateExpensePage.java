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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fieldez.testcases.BaseClass1;
import com.fieldez.utilities.ExplicitWaits;
import com.fieldez.utilities.Generate_Radom_Data;

public class CreateExpensePage {

	ExplicitWaits ew = new ExplicitWaits();
		//Driver object
	    WebDriver ldriver; //local driver
	    Generate_Radom_Data genData;
	    
	    //Constructor LoginPage
	    
		public CreateExpensePage(WebDriver rdriver)
	  {
			//Initiate the drivers ,Remote Driver
			ldriver=rdriver; 
			
			//PageFactory Class  //This initElements method will create all WebElements
			PageFactory.initElements(rdriver, this);
	  }
		
		
	 
	    // Web Elements are identified by "FindBy" Annotation
	    
	    //Advanced Link
	    @FindBy(xpath="//a[@class='dropdown-toggle'][contains(text(),'Advanced')]")
		@CacheLookup
		WebElement AdvancedLink;
	    
	    
	  //Expense Link
	    @FindBy(xpath="//span[contains(text(),'Expense')]")
		@CacheLookup
		WebElement ExpenseLink;
	    
	    // Create Expense Link
		@FindBy(xpath="//a[@class='btn btn-second']")
		@CacheLookup
		WebElement CreateExpenselink;
		
		//-------TC 01 --completed
		
		// Add Line Item
		@FindBy(xpath="//div[@class='btn btn-second']")
		@CacheLookup
		WebElement AddLineitem;
		
		// Select Food or Travel
		@FindBy(xpath="//select[@id='selectedExpenseType']")
		@CacheLookup
		WebElement SelectFood;
		
		// Paid By Button 
		@FindBy(xpath="//select[@id='exampleInputEmail1']")
		@CacheLookup
		WebElement paidBY;
		
		// Amount Value
		@FindBy(xpath="//div[@id='LineItemsModal']//div[3]//div[1]//input[1]")
		@CacheLookup
		WebElement Amount;
		
		// Amount Static value from code
		
		@FindBy(xpath="//div[@id='LineItemsModal']//div[3]//div[1]//input[1]")
		@CacheLookup
		WebElement AmountStatic;
		
		// Save Line Item disabled Button 
		@FindBy(xpath="//button[@class='btn btn-prime disabled']")
		@CacheLookup
		WebElement SavebuttonDisabled;
		
		// Save Line Item Enabled Button 
		@FindBy(xpath="//div[@class='col-sm-9 footer-btn-section form-group']//button[@class='btn btn-prime'][contains(text(),'Save')]")
		@CacheLookup
		WebElement SaveItem;
		
		// Click Expense Date Picker
		@FindBy(css="#dropdown .input-group-addon")
		@CacheLookup
		WebElement ClickCalendar;
		
		// Select Date
		@FindBy(css=".form-group:nth-child(3) .ng-scope:nth-child(4) > .day:nth-child(4)")
		@CacheLookup
		WebElement SelectDate;
		
		
		// Submit Expense
		@FindBy(xpath="//button[@id='step5']")
		@CacheLookup
		WebElement submitexp;
		
		//Select Travel
		@FindBy(xpath="//select[@id='selectedExpenseType']")
		@CacheLookup
		WebElement Travel;
		
		//Select Mode
		@FindBy(xpath="//div[@id='divattribute3']//select[@id='exampleInputEmail1']")
		@CacheLookup
		WebElement Mode;
		
		//Select Location HQ,Non HQ
		@FindBy(xpath="//div[@id='divattribute4']//select[@id='exampleInputEmail1']")
		@CacheLookup
		WebElement Location;
		
		//Select Rate
		@FindBy(xpath="//div[@id='invoice']//div[5]//div[1]//input[1]")
		@CacheLookup
		WebElement Rate;
		
		//Select Distance
		@FindBy(xpath="//div[6]//div[1]//input[1]")
		@CacheLookup
		WebElement Distance;
		
		
		//Cancel Line Item
		@FindBy(xpath="//div[@class='col-sm-9 footer-btn-section form-group']//button[@class='btn btn-cancel'][contains(text(),'Cancel')]]")
		@CacheLookup
		WebElement CancelLineItem;
		
		//Cancel Expense
		@FindBy(xpath="//button[@class='btn btn-cancel pull-right']")
		@CacheLookup
		WebElement CancelExpense;
		
		// View Info of Line items
		@FindBy(xpath="//div[@class='ng-scope']//a[1]//img[1]")
		@CacheLookup
		WebElement ViewInfo;
		
		// Close View Info of Line items
		@FindBy(xpath="//div[@id='LineItemsModal1']//button[@class='close'][contains(text(),'×')][contains(text(),'×')]")
		@CacheLookup
		WebElement CloseViewInfo;
		
		// Delete Line item Icon
		@FindBy(xpath="//a[3]//img[1]")
		@CacheLookup
		WebElement DeleteItemIcon;
		
		public void AdvancedLink() throws InterruptedException
		{   
			AdvancedLink.click();
		}
		
		public void ExpenseLink() throws InterruptedException
		
		{   
			ew.visibilityOf(ldriver, ExpenseLink, 10);
			ExpenseLink.click();
		}
		
		
		public void CreateExpense() throws InterruptedException
		
		{   ew.visibilityOf(ldriver, CreateExpenselink, 10);
			CreateExpenselink.click();
			ldriver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
			
		}
		
		public void AddLineItem() throws InterruptedException
		{   
			ew.visibilityOf(ldriver, AddLineitem, 10);
			AddLineitem.click();
			
		}
		
		
		public void selectFoodTravel() throws InterruptedException
		{   
			ew.visibilityOf(ldriver, SelectFood, 10);
			Select SF = new Select(SelectFood);
			SF.selectByVisibleText("Food");
		}
		
		public void selectTravel() throws InterruptedException
		{   
			ew.visibilityOf(ldriver, Travel, 10);
			Select SF = new Select(Travel);
			SF.selectByVisibleText("Travel");
		}
		
		public void PaidBy() throws InterruptedException
		{   
			ew.visibilityOf(ldriver, paidBY, 10);
			Select pb = new Select(paidBY);
			pb.selectByVisibleText("Company");
		}
		public void Amount(String amt1) throws InterruptedException
		{   
			ew.visibilityOf(ldriver, Amount, 10);
			Amount.sendKeys(amt1);
		}
		
		public void Mode() throws InterruptedException
		{   
			ew.visibilityOf(ldriver, Mode, 10);
			Select pb = new Select(Mode);
			pb.selectByVisibleText("Air");
		}
		
		public void Location() throws InterruptedException
		{   
			ew.visibilityOf(ldriver, Location, 10);
			Select pb = new Select(Location);
			pb.selectByVisibleText("HQ");
			
		}
		
		public void Rate(String rate) throws InterruptedException
		{   
			ew.visibilityOf(ldriver, Rate, 10);
			Rate.sendKeys(rate);
		}
		
		public void Distance(String kms) throws InterruptedException
		{   ew.visibilityOf(ldriver, Distance, 10);
			Distance.sendKeys(kms);
			
		}
		
		public void savebuttondisabled() throws InterruptedException
		{   
			ew.visibilityOf(ldriver,SavebuttonDisabled, 10);
			SavebuttonDisabled.click();
		}
		
		
		public void savebuttonEnabled() throws InterruptedException
		{   
			ew.visibilityOf(ldriver,SaveItem, 10);
			SaveItem.click();
		}
		
		public void clickDatePicker() throws InterruptedException
		{   
			ew.visibilityOf(ldriver,ClickCalendar, 10);
			ClickCalendar.click();
		}
		
		
		public void SelectExpenseDate() throws InterruptedException
		{   
			ew.visibilityOf(ldriver,SelectDate, 10);
            SelectDate.click();
		}
		
		public void SubmitExpense() throws InterruptedException
		{   
			ew.visibilityOf(ldriver,submitexp, 10);
			submitexp.click();
		}
		
		public void CancelLineItem() throws InterruptedException
		{
			ew.visibilityOf(ldriver,CancelLineItem, 10);
			CancelLineItem.click();
		}
		
		public void CancelExpense() throws InterruptedException
		{
			ew.visibilityOf(ldriver,CancelExpense, 10);
			CancelExpense.click();		
		}
		
		public void Static_Amount() throws InterruptedException
		{   ew.visibilityOf(ldriver,AmountStatic, 10);
			AmountStatic.sendKeys("3000");	
		}
		
		public void viewInfoicon() throws InterruptedException
		{
			ew.visibilityOf(ldriver,ViewInfo, 10);
		    ViewInfo.click();
		
		}
		
		public void CloseViewInfoicon() throws InterruptedException
		{
			ew.visibilityOf(ldriver,CloseViewInfo, 10);
			CloseViewInfo.click();
			
		}
		
		public void DeleteLineItemIcon() throws InterruptedException
		{
			ew.visibilityOf(ldriver,DeleteItemIcon, 10);
			DeleteItemIcon.click();
			
		}
}




