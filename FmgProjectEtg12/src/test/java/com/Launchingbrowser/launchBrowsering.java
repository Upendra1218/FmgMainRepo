package com.Launchingbrowser;

import org.testng.annotations.Test;

import com.PageObjects.homePage;
import com.Validations.browserValidation;
import com.testcases.baseClass;

public class launchBrowsering extends baseClass{
	@Test
	public void chromeBrowser() throws InterruptedException {
		
		//launching the browser and passing the url into it
		 driver.get(baseURL);
		 test.pass("Entered into url");
		 logger.info("Placing the order as guest user");
		 //validation
		 browserValidation.validateBroweserlaunches();
		 
		 homePage hp = new homePage(driver);
		 hp.clickconsentTracking();
	}

}
