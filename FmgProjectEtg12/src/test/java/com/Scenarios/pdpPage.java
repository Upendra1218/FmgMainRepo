package com.Scenarios;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.NavigationProcess;
import com.PageObjects.productDescriptionPage;
import com.PageObjects.productListingPage;
import com.commonfunctionality.allAttributesinOneFile;
import com.testcases.baseClass;

public class pdpPage extends baseClass{

	public static void addtoCartPDP() throws InterruptedException {

		List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));
	       if (pdpPagecheck.size() > 0) {
	    	   logger.info("next time me");
	    	   List<WebElement> pdpPageaddToCart = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]//a[contains(@class, 'add-to-cart')]"));
	    	   int displayedAddToCartCount = 0;
	   	    for (WebElement item : pdpPageaddToCart) {
	   	        if (item.isDisplayed()) {
	   	        	displayedAddToCartCount++;
	   	        }
	   	    }
	    	   logger.info(displayedAddToCartCount);
	    	   if(displayedAddToCartCount>0) {
	    		   
	    		   productDescriptionPage pdp = new productDescriptionPage(driver);
	    		   pdp.selecttheWishlist();
	    		   
	    		   allAttributesinOneFile.selectTheAttributesInPdp(driver);
	    		   
	    		   Random random = new Random();
	    	        int randomNumber = random.nextInt(3); // Generates a random number between 0 (inclusive) and 2 (exclusive)

	    	     
	    	        switch (randomNumber) {
	                case 0:
	                	productDescriptionPage.haveAQuestion();
	                    break;
	                case 1:
	                	productDescriptionPage.tierPricesInPdp();
	                    break;
	                case 2:
	                	productDescriptionPage.NoTierSelectionInPdp();
	                    break;
	                default:
	                	 System.out.println("Invalid random number");
	    	        }
	    		   
	    	   }else {
	    		   logger.info("notify me");
	    		   
		         
	    		   NavigationProcess navProcess = new NavigationProcess(driver);
		           // Select a random menu item
	        	   navProcess.selectRandomMenu(driver);
		           
		           productListingPage.selectRandomProduct();
		   		   //adding produuct to cart
		           allAttributesinOneFile.selectTheAttributesInPdp(driver);
	    	   }
//	   		   List<WebElement> pdpPagecheckNotfy = driver.findElements(By.xpath("//button[contains(@class,'notify-product-button')]"));
//	   	       if (pdpPagecheckNotfy.size() > 0) {
//	      	   
//	   	       }
	       }else {   
	    	   
	    	   NavigationProcess navProcess = new NavigationProcess(driver);
	           // Select a random menu item
        	   navProcess.selectRandomMenu(driver);
	           
	           productListingPage.selectRandomProduct();
	   		   //adding produuct to cart
	           allAttributesinOneFile.selectTheAttributesInPdp(driver);
	       }
	}
}
