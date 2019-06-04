package com.fieldez.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Driver object
    WebDriver ldriver; //local driver
	
    //Constructor LoginPage
	public LoginPage(WebDriver rdriver)
  {
		//Initiate the drivers ,Remote Driver
		ldriver=rdriver; 
		
		//PageFactory Class  //This initElements method will create all WebElements
		PageFactory.initElements(rdriver, this); 
  }
	
	
     // Add Login Elements here in this Class
    // Web Elements are identified by "FindBy" Annotation
    
    //username element
    @FindBy(name="username")
	@CacheLookup
	WebElement txtUserName;
	
    
    // password element
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	//login button element
	@FindBy(xpath=".//button[@name='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	
	// Click logout button element
	@FindBy(xpath=".//*[@id='profile-img']")
	@CacheLookup
	WebElement ClickLogout;
	
	// Click Signout Button element
	@FindBy(xpath=".//*[@id='bs-example-navbar-collapse-1']/div/div/div[4]/a")
	@CacheLookup
	WebElement Signout;
	
		
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	
	public void clickSubmit()
	{
		btnLogin.click();
	}	
	
	public void clickLogout()
	{
		ClickLogout.click();
		Signout.click();
	}
}
