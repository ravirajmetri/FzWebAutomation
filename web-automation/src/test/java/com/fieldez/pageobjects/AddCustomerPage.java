package com.fieldez.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AddCustomerPage {
	
		//Driver object
	    WebDriver ldriver; //local driver
		
	    //Constructor LoginPage
		public AddCustomerPage(WebDriver rdriver)
	  {
			//Initiate the drivers ,Remote Driver
			ldriver=rdriver; 
			
			//PageFactory Class  //This initElements method will create all WebElements
			PageFactory.initElements(rdriver, this); 
	  }
		
		
	     // Add Login Elements here in this Class
	    // Web Elements are identified by "FindBy" Annotation
	    
	    //Customer Link
	    @FindBy(xpath=".//*[@id='bs-example-navbar-collapse-1']/ul[1]/li[2]/a")
		@CacheLookup
		WebElement CustomerLink;
		
	    
	    // add customer link
		@FindBy(xpath="//a[contains(@title,'Add Customer')]")
		@CacheLookup
		WebElement AddCustomerButton;
		
		//Pass Customer Name
		@FindBy(xpath=".//*[@title='Enter Customer Name here']")
		@CacheLookup
		WebElement CustomerFirstName;
		
		//Pass Customer last Name
		@FindBy(xpath="//div[3]//div[1]//div[1]//div[1]//input[1]")
		@CacheLookup
		WebElement CustomerLastName;
		
		// Click Submit
		@FindBy(xpath=".//*[@id='createCustomerBtn']")
		@CacheLookup
		WebElement ClickSubmit;
		
		
		
			
		
		public void clickcustomer()
		{   ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			CustomerLink.click();
		}
		
		public void Clickcustomerbutton()
		{
			
			ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//WebElement AddCustomerButton1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]")));
			AddCustomerButton.click();
			
		}
		public void  inputCustomerName(String Customername)
		{   ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			CustomerFirstName.sendKeys(Customername);
			
		}
		public void  inputCustomerlastName(String Customerlastname)
		
		{   ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			CustomerLastName.sendKeys(Customerlastname);
			
		}
		
		
		public void saveCustomer() throws InterruptedException
		{   ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			ClickSubmit.click();
			Thread.sleep(10000);
		}	
		
		
	}


