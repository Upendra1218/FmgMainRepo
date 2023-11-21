package com.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.testcases.baseClass;

public class validatingInstock extends baseClass{

	public static void inStockValidation() {
		

 		List<WebElement> Stocksize = driver.findElements(By.xpath("//div[contains(text(), 'This item is currently not available')]"));
 		test.info("Verify that the product is avaliable");
 	    // Check if the element is present
 	    if (Stocksize.size() <= 0) {
 	    	test.pass("The product is avaliable");
 	    	
 	    	List<WebElement> addtoCartButton = driver.findElements(By.xpath("//button[contains(@class, 'add-to-cart')]"));
 	    	List<WebElement> addAlltoCartButton = driver.findElements(By.xpath("//button[contains(@class, 'add-to-cart-global')]"));

 	    	
 	    	//addtocartbutton is enabled
 	    	test.info("Verify that the product is avaliable");
 	    	if(addAlltoCartButton.size()>0) {
 	    		test.info("Verify that the add all to cart button");
 	    		logger.info("addallto buttonenabled");
 	    		WebElement addalltoCartButtonClick = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart-global')]"));
 	   		    JavascriptExecutor js = (JavascriptExecutor)driver;
 	   		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addalltoCartButtonClick);
	             js.executeScript("arguments[0].click();", addalltoCartButtonClick);
	            test.pass("Successfully clicked on the add all to cart button");
 	    		//addalltoCartButtonClick.click();
 	    		
 	    	}else if(addtoCartButton.size()>0) {
 	    		test.info("Verify that the add to cart button");
 	    		logger.info("add to buttonenabled");
 	    		WebElement addtoCartButtonClick = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart')]"));
 	    		JavascriptExecutor js = (JavascriptExecutor)driver;
 	            js.executeScript("arguments[0].click();", addtoCartButtonClick);
 	           test.pass("Successfully clicked on the add to cart button");
 	    		//addtoCartButtonClick.click();
 	    	}else {
 	    		logger.info("out of stock");
 	    		test.fail("The product is out of stock");
 	    	}

 	       
 	    }else {
 	    	logger.info("Product is out of stock");
 	    	
 	    }

	}
	
	//buyNowButton
	
	public static void buyNowButton() {
		
	}
}
