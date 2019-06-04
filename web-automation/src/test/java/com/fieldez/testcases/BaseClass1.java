package com.fieldez.testcases;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.fieldez.utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass1 {
	
	
	ReadConfig readconfig=new ReadConfig();
	// Define the common variables for all the test cases
	public String baseURL="http://qa.fieldez.com/emob/login.jsp";
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static WebDriver driver;
	public static Logger logger;
	
	
	// Set Up Method
	@Parameters("browser")
	@BeforeClass
	public void setup(String brw) throws InterruptedException
	{   

		
		// Log4j Set Up
				logger = Logger.getLogger("Fieldez");
				PropertyConfigurator.configure("Log4j.properties");
				
		if(brw.equals("Firefox"))
		{		
		// Set GeckoDriver Property
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		
		//Instantatation the Driver
		driver=new FirefoxDriver();
		}
			
		else if (brw.equals("Chrome"))
	   {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			
			//Instantatation the Driver
			driver=new ChromeDriver();
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
	}
	
	
	
	/*public static String getScreenshot(WebDriver driver) throws IOException
	{    File source;
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		 source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" +System.currentTimeMillis()+".png";
				//+ ".png";
		
		
		File finalDestination = new File(destination);
		
		try {
			FileUtils.copyFile(source, finalDestination);
		}
		
		catch(IOException e) {
			System.out.println("Captured Failed"+e.getMessage());
		}
		//return destination;
		return destination;
	}*/
	
	@AfterClass
	public void OpenTestResults(){
		
		//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		//Instantatation the Driver
	//	driver=new ChromeDriver();
		//System.out.println("Screenshot taken");
		//driver.get("E:\\SVN\\FZ_Web_Automation_1.0\\com.fieldez.webautomation\\test-output\\index.html");
		//driver.manage().window().maximize();
		//Thread.sleep(5000);
		//driver.quit();
		
		
		driver.quit();
	}	}
	

