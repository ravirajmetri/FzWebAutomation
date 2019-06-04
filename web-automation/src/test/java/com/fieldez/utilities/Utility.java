package com.fieldez.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility 
	{
	 
		public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException
		{   String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			System.out.println(src);
			
			String path=System.getProperty("user.dir")+"/FailedScreen/"+screenshotName+dateName+".png";
			System.out.println(path);
			File destination=new File(path);
			System.out.println(destination);
			FileUtils.copyFile(src, destination);
			System.out.println(destination);
			//System.out.println("Capture Failed "+e.getMessage());
				
			return path;
		}
		
	}

