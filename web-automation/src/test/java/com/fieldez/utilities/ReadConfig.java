package com.fieldez.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	
	//Create the Properties object
	Properties pro;
	
	//Create the Constructor



      public ReadConfig()
         
      {
           // Path where config.properties file is stored	   
	       File src = new File("./Configurations/config.properties");

	       try
	       {
		       // FileInputStream is opening the config.properties in input mode	   
	    	   FileInputStream fis = new FileInputStream(src);
	    	   
	    	   // pro Object Instantiating
		       pro = new Properties();
		       
		       // Load is a method which will load the complete config.properties file from the above path at run time
		       pro.load(fis);
	       } 
	       
	       // If file not available then below exception
	       catch (Exception e)  
	       {
		        System.out.println("Exception is " + e.getMessage());
	       }
      }

      // Method to get the url from config.properties URL
      public String getApplicationURL()
  	{
    	  
    	// baseURL value is fetched from config.properties file  
  		String url=pro.getProperty("baseURL");
  		return url;
  	}
      
      // Method to get the username from config.properties URL
     public String getusername()
  	{
    	  
    	// username value is fetched from config.properties file  
  		String username=pro.getProperty("username");
  		return username;
  	}
      
    public String getpassword()
  	{
  	String password=pro.getProperty("password");
  	return password;
  	}
  	
  	public String getChromePath()
  	{
  	String chromepath=pro.getProperty("chromepath");
  	return chromepath;
  	}
  	
  
  	public String getFirefoxPath()
  	{
  	String firefoxpath=pro.getProperty("FireFoxpath");
  	return firefoxpath;
  	}
  	
      
}
