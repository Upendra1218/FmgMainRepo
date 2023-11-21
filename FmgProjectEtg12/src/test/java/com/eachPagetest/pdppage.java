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
		
//        // Launch the browser and navigate to the URL
//        launchBrowsering lb = new launchBrowsering();
//        lb.chromeBrowser();
//        Thread.sleep(4000);
//        int randomNumbermenu = 8;
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//     // Locate and hover over the randomly selected top-level menu item.
//        WebElement sales = driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown')])[" + randomNumbermenu + "]"));
//        js.executeScript("arguments[0].click();", sales);
//        Thread.sleep(2000);
//        //sales.click();
//        //select a banner form the listed below
//        productListingPage hm = new productListingPage(driver);
//        hm.selectHeroBanner();
//        
//        List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
//        List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));
//      
//        
//        if (plpPagecheck.size() > 0 ) {
//            logger.info("PLP page is already loaded");
//            // Initialize and execute the PLP page scenario to add a product to the cart
//            plpPage.addtocartplp();
//        } else if(pdpPagecheck.size()>0) {
//        	 logger.info("pdp page is already loaded");
//        	 pdpPage.addtoCartPDP();
//        }
//        else {
//            // Move to CLP to the PLP
//            CLPpage clp = new CLPpage(driver);
//            clp.selectaClpRandomly();
//        }
//	   
//	   Thread.sleep(13000);
//	
		
		//https://https://sfccstage.firemountain.org/jewelry-supplies/supplies-by-type/gemstones/faceted-gems/?prefn1=material&prefv1=Diopside
		driver.get("https://storefront:FMG2023@utsf.firemountain.org/beads/beads-by-type/acrylic-beads/");
		//https://
		Thread.sleep(5000);
		
		 homePage hp = new homePage(driver);
		 hp.clickconsentTracking();
		 
		 test.info("Verify that price changes and discount applies");
			

		 List<WebElement> quantityInput = driver.findElements(By.xpath("//input[@name='quantity']"));
		 int intValueCount=0;
		 int productQuantityCount = quantityInput.size();
		 int productCount = 150;
		// Create a random number generator.
	    Random random = new Random();
        // Generate a random index to select an "Add to Cart" button.
	    int randomquantityInput = random.nextInt(productQuantityCount) + 1;
	    int inputQuantiy = random.nextInt(productCount)+1;
	    logger.info(randomquantityInput);
	    logger.info("Product input quantity"+inputQuantiy);
		 if(quantityInput.size()>0) {
			 
		    // Find the quantity input field associated with the clicked button and set the quantity.
	        WebElement inctheQuantity = driver.findElement(By.xpath("(//input[@name='quantity'])[" + randomquantityInput + "]"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", inctheQuantity);
	        Thread.sleep(2000);
	        inctheQuantity.clear(); // Clear the existing value
	        Thread.sleep(2000);
	        inctheQuantity.sendKeys(String.valueOf(inputQuantiy));
	        Thread.sleep(1000);
	        
	        //prodcut is add to cart
	        WebElement clickAddtoCartBtn = driver.findElement(By.xpath("(//div[contains(@class,'product-grid')]//a[contains(@class, 'add-to-cart')])[" + randomquantityInput + "]"));
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


		 List<WebElement> tierDivPesent = driver.findElements(By.xpath("//div[@class='pricebooks'][" + randomquantityInput + "]"));
		 
		 int displayedtierDivPesent = 0;
		    for (WebElement item : tierDivPesent) {
		        if (item.isDisplayed()) {
		        	displayedtierDivPesent++;
		        }
		    }

		    // Get the count of matched elements and log it.
		    int count = displayedtierDivPesent;
		 
		 logger.info("Tier price quantity "+count);
		 if(count>0) {
			 
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
