package com.Validations;

import org.openqa.selenium.NoSuchWindowException;

import com.testcases.baseClass;

public class browserValidation extends baseClass{
	
	public static void validateBroweserlaunches() {
		test.info("Validate the browser launched");
		//Browser crashes
		if (isBrowserRunning()) {
			logger.info("Browser launched succesfully"); 
			test.pass("Browser launched succesfully");
			isBrowserLaunched = true;
        }else {
			logger.info("Browser launched Failed"); 
			test.fail("Browser launched Failed");
        }
	}
	
	//validate the browser is running or not
	   private static boolean isBrowserRunning() {
		   try {
		        driver.getTitle();

		        // Clear all cookies
		       // driver.manage().deleteAllCookies();
		        return true;
		    } catch (NoSuchWindowException e) {
		        return false;
		    } catch (Exception e) {
		        // Handle any other exceptions
		        return false;
		    }
	    }

}
