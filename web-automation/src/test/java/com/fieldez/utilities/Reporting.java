package com.fieldez.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fieldez.testcases.BaseClass1;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;	 

public class Reporting extends TestListenerAdapter{
	
	
	    public ExtentHtmlReporter htmlReporter;
	    public ExtentReports extent;
	    public ExtentTest logger;
	           WebDriver driver;
	
		
	public void onStart(ITestContext testContext)
	
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/Extent-Reports"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","qa.fieldez.com");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","Raviraj");
		
		htmlReporter.config().setDocumentTitle("Fieldez Automation Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	    //logger.log(Status.PASS, MarkupHelper.createLabel(tr.getTestName(), ExtentColor.GREEN));
	    //logger.getStatus();
	   // logger.getExtent();
	}
	
	public void onTestFailure(ITestResult result)
	{ logger=extent.createTest(result.getName()); // create new entry in th report
	logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
	logger.log(Status.FAIL,result.getThrowable());
		
		/*if(result.getStatus()==ITestResult.FAILURE)
		{
		logger=extent.createTest(result.getName()); // create new entry in th report
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		logger.log(Status.FAIL,result.getThrowable());
		 //screenshotPath=null;
		try {
			String screenshotPath = Utility.getScreenshot(driver, result.getName());
			logger.fail("ScreenCast" + logger.addScreencastFromPath(screenshotPath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		}*/
		
	}	
	
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}

