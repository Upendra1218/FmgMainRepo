package com.eachPagetest;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.CLPpage;
import com.PageObjects.homePage;
import com.PageObjects.NavigationProcess;
import com.PageObjects.productListingPage;
import com.Scenarios.pdpPage;
import com.Scenarios.plpPage;
import com.Validations.validationpopupMessages;
import com.commonfunctionality.allAttributesinOneFile;
import com.testcases.baseClass;

public class pdppage extends baseClass{
	@Test
	public void testing() throws InterruptedException {
		

		//https://https://sfccstage.firemountain.org/jewelry-supplies/supplies-by-type/gemstones/faceted-gems/?prefn1=material&prefv1=Diopside
		driver.get("https://storefront:FMG2023@utsf.firemountain.org/beads/beads-by-type/acrylic-beads/");
		//https://
		Thread.sleep(5000);
		
		 homePage hp = new homePage(driver);
		 hp.clickconsentTracking();
		 
		 test.info("Verify that price changes and discount applies");
		 
		 productListingPage plp = new productListingPage(driver);
		 plp.nameofPlp();
		 
		 
		    // Find all color buttons that are enabled
		    List<WebElement> addtoCartBtns = driver.findElements(By.xpath("//div[contains(@class,'product-grid')]//a[contains(@class, 'add-to-cart')]"));
		    int displayedAddToCartCount = 0;
		    for (WebElement item : addtoCartBtns) {
		        if (item.isDisplayed()) {
		        	displayedAddToCartCount++;
		        }
		    }

		    // Get the count of matched elements and log it.
		    int count = displayedAddToCartCount;
		    logger.info("Total add to cart buttons: " + count);
		    int intValueCount=0;
			int productCount = 150;
		    
		    Random random = new Random();
		    
		    int randomAddtocartButton = random.nextInt(count) + 1;
		    int inputQuantiy = random.nextInt(productCount)+1;
		    logger.info(randomAddtocartButton);
		    logger.info("Product input quantity"+inputQuantiy);
		    
		    
	    if(count>0) {
		    	
		    	// Find the quantity input field associated with the clicked button and set the quantity.
		        WebElement inctheQuantity = driver.findElement(By.xpath("(//input[@name='quantity'])[" + randomAddtocartButton + "]"));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", inctheQuantity);
		        Thread.sleep(2000);
		        inctheQuantity.clear(); // Clear the existing value
		        Thread.sleep(2000);
		        inctheQuantity.sendKeys(String.valueOf(inputQuantiy));
		        Thread.sleep(1000);
		        
		        //prodcut is add to cart
		        WebElement clickAddtoCartBtn = driver.findElement(By.xpath("(//div[contains(@class,'product-grid')]//a[contains(@class, 'add-to-cart')])[" + randomAddtocartButton + "]"));
		        // Scroll to the "Add to Cart" button and click it.
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        // Use JavaScript to scroll the element into the middle of the page view
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clickAddtoCartBtn);
		        Thread.sleep(1000);
		        js.executeScript("arguments[0].click();", clickAddtoCartBtn);
		        Thread.sleep(1000);
	        
		 	   String valuecount = inctheQuantity.getAttribute("value");
		       logger.info(valuecount);
		        
		       // Convert the string to an integer
		       intValueCount = Integer.parseInt(valuecount);
		       logger.info(intValueCount);
	
		    }else {
				 NavigationProcess navProcess = new NavigationProcess(driver);
		           // Select a random menu item
		           navProcess.selectRandomMenu(driver);
		           //addToCartFromPlp();
		    
			 }
		    
		   
		 List<WebElement> tierDivPesent = driver.findElements(By.xpath("//div[@class='pricebooks'][" + randomAddtocartButton + "]"));
		 
		 int displayedtierDivPesent = 0;
		    for (WebElement item : tierDivPesent) {
		        if (item.isDisplayed()) {
		        	displayedtierDivPesent++;
		        }
		    }

		    // Get the count of matched elements and log it.
		    int count1 = displayedtierDivPesent;
		 
		 logger.info("Tier price quantity "+count1);
		 if(count1>0) {
			 
			 if(intValueCount<14) {
		        	// Find all color buttons that are enabled
		    	    List<WebElement> priceChangeBartier1 = driver.findElements(By.xpath("//div[@class='pricebook usd-fmg-tier1-prices active']"));
		    	    if(priceChangeBartier1.size()>0) {
		    	    	WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier1-prices active']//div[@class='price']"));
		    	    	String price = priceDiscount.getText();
		    	    	logger.info(price);
		    	    	
		    	    test.pass("The Discount is on the Blue one"+price);
		    	    logger.info("The Discount is on the Blue one");
		    	    }
		        }else if(intValueCount<49) {
		    	    List<WebElement> priceChangeBartier2 = driver.findElements(By.xpath("//div[@class='pricebook usd-fmg-tier2-prices active']"));
		    	    if(priceChangeBartier2.size()>0) {
		    	    	WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier2-prices active']//div[@class='price']"));
		    	    	String price = priceDiscount.getText();
		    	    	logger.info(price);
		    	    test.pass("The Discount is on the Green one"+price);
		    	    logger.info("The Discount is on the Green one");
		    	    }
		        }else if(intValueCount<99) {
		    	    List<WebElement> priceChangeBartier3 = driver.findElements(By.xpath("//div[@class='pricebook usd-fmg-tier3-prices active']"));
		    	    if(priceChangeBartier3.size()>0) {
		    	    	WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier3-prices active']//div[@class='price']"));
		    	    	String price = priceDiscount.getText();
		    	    	logger.info(price);
		    	    test.pass("The Discount is on the Rose one "+price);
		    	    logger.info("The Discount is on the Rose one");
		    	    }
		        }else {
		        	WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier4-prices active']//div[@class='price']"));
			    	String price = priceDiscount.getText();
			    	logger.info(price);
		        	test.pass("The Discount is on the Black one"+price);
		        	logger.info("The Discount is on the Black one");
		        }
		 }		    
		        
	}

}
