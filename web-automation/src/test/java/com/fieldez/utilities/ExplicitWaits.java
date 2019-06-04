package com.fieldez.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits {

	public void visibilityOf(WebDriver driver,WebElement element, int timeout) {
		
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
}
