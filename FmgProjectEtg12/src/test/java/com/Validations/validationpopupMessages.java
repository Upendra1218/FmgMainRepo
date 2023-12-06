package com.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.commonfunctionality.waitForTheElement;
import com.testcases.baseClass;

public class validationpopupMessages extends baseClass{
	
   // Method to validate if a product is added to the cart
   public static void validatingProductisAddtoCart(WebDriver driver) {
	   test.info("Validating product is added to the cart");
	   
	   // Find elements with text "This item is currently not available"
	   List<WebElement> Stocksize = driver.findElements(By.xpath("//div[contains(text(), 'This item is currently not available')]"));
	   test.info("Verify that the product is available");
	   
	   // Check if the element is present
	   if (Stocksize.size() > 0) {
	    	logger.info("Product is not available");
	    } else {
	    	 		
	    	
	    	// Create a FluentWait for dynamic element wait
	    	Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
	        // Wait for the success alert to be visible
	    	
	    	// Check if either of the conditions is met
	    	WebElement popupMessage = null;
	    	if (wait.until(ExpectedConditions.or(
	    	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully added to your cart.')]")),
	    	        ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'! Quantity adjusted to maximum available.')]"))
	    	))) { 
	    	    // One of the conditions is met, so determine which one
	    	    if (driver.findElements(By.xpath("//div[contains(text(),'Successfully added to your cart.')]")).size() > 0) {
	    	        popupMessage = driver.findElement(By.xpath("//div[contains(text(),'Successfully added to your cart.')]"));
	    	    } else {
	    	    	popupMessage = driver.findElement(By.xpath("//div[contains(text(),'! Quantity adjusted to maximum available.')]"));
	    	    }
	    	}

	    	if (popupMessage != null) {
	    		
		        // Get the text of the alert
		        String actualAddToCart = popupMessage.getText();
		        // Expected alert text
		        String expectedAddToCart = "Successfully added to your cart.";
		        
		        // Check if the actual alert text matches the expected text
		        if (actualAddToCart.equals(expectedAddToCart)) {
		            // Success message is displayed
		        	test.pass("Product added to cart");
		            logger.info("Product is added to cart");
		            // Perform actions or assertions here for the success case
		        } else {
		            // Success message is not as expected
		        	test.pass("Product is added to cart");
		            logger.info("Product is added to cart");
		            // Perform actions or assertions here for the failure case
		        }
	    	} else {
	    	    System.out.println("Neither condition is met.");
	    	}
	    	
	    }
   }
   
   // Method to validate if a gift card is added to the cart
   public static void validatingGiftCardAddtoCart(WebDriver driver) {
	   test.info("Validating gift card is added to the cart");
	   
	   // Create a FluentWait for dynamic element wait
	   Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
	   // Wait for the success alert to be visible
	   WebElement gifcartAddtoCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
	   // Get the text of the alert
	   String actualAddToCart = gifcartAddtoCart.getText();
	   // Expected alert text
	   String expectedAddToCart = "Gift Certificate added to cart";
	   
	   // Check if the actual alert text matches the expected text
	   if (actualAddToCart.equals(expectedAddToCart)) {
	       // Success message is displayed
       	   test.pass("Gift Certificate added to cart");
           logger.info("Gift Certificate added to cart");
           // Perform actions or assertions here for the success case
	   } else {
	       // Success message is not as expected
       	   test.fail("Gift Certificate not added to cart");
           logger.info("Gift Certificate not added to cart");
	   }
   }
   
   // Method to validate if a product is removed from the mini cart
   public static void removeproductformminicartValidation() {
	   test.info("Validate product is removed from the mini cart");
	   
	   // Create a FluentWait for dynamic element wait
	   Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
	   // Wait for the success alert to be visible
	   WebElement removeproduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger remove-to-basket-alert text-center']")));
	   // Get the text of the alert
	   String removeproductfromcart = removeproduct.getText();
	   // Expected alert text
	   String expectedAddToCart = "Product Removed from cart";
	   
	   // Check if the actual alert text matches the expected text
	   if (removeproductfromcart.equals(expectedAddToCart)) {
	       // Success message is displayed
       	   test.pass("Product is removed from the cart");
           logger.info("Product is removed from the cart");
           // Perform actions or assertions here for the success case
	   } else {
	       // Success message is not as expected
       	   test.fail("Product is not removed from the cart");
           logger.info("Product is not removed from the cart");
	   }
   }
   
   // Method to validate if a product is added to the wishlist
   public static void validatingProductisAddtoWishList(WebDriver driver) {
	   test.info("Validating product is added to the wishlist");
	   
	   // Create a FluentWait for dynamic element wait
	   Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement addTowishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'add-to-wishlist-alert')]")));
       // Get the text of the alert   
       String actualAddToCart = addTowishList.getText();
       
       logger.info(actualAddToCart);
       // Expected alert text
       String expectedAddToCart = "The product has been added to your wishlist.";
       
       // Check if the actual alert text matches the expected text
       if (actualAddToCart.equals(expectedAddToCart)) {
           // Success message is displayed
       	   test.pass("Product added to wishlist");
           logger.info("Product is added to wishlist");
           // Perform actions or assertions here for the success case
       } else {
           // Success message is not as expected
       	   test.fail("Product is not added to wishlist");
           logger.info("Product is not added to wishlist");
       }
   }
   
   // Method to validate if a product is added to the wishlist
   public static void validatingProductisAddtoWishListfromPDP(WebDriver driver) {
	   test.info("Validating product is added to the wishlist");
	   
	   // Create a FluentWait for dynamic element wait
	   Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement addTowishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully added to your favorites')]")));
       // Get the text of the alert   add-to-wishlist-alert text-center alert-success
       String actualAddToCart = addTowishList.getText();
       // Expected alert text
       String expectedAddToCart = "Successfully added to your favorites";
       
       // Check if the actual alert text matches the expected text
       if (actualAddToCart.equals(expectedAddToCart)) {
           // Success message is displayed
       	   test.pass("Product added to wishlist");
           logger.info("Product is added to wishlist");
           // Perform actions or assertions here for the success case 
       } else {
           // Success message is not as expected
       	   test.fail("Product is not added to wishlist");
           logger.info("Product is not added to wishlist");
       }
   }
   
// Method to validate if a product is added to the wishlist
   public static void validatingProductisSaveforLater(WebDriver driver) {
	   test.info("Validating product is added to the saveForLater");
	   
	   // Create a FluentWait for dynamic element wait
	   Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement saveForLater = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Product is added to save for later')]")));
       // Get the text of the alert   add-to-wishlist-alert text-center alert-success
       String actualAddToCart = saveForLater.getText();
       // Expected alert text
       String expectedAddToCart = "Successfully added to your favorites";
       
       // Check if the actual alert text matches the expected text
       if (actualAddToCart.equals(expectedAddToCart)) {
           // Success message is displayed
       	   test.pass("Product added to saveForLater");
           logger.info("Product is added to saveForLater");
           // Perform actions or assertions here for the success case 
       } else {
           // Success message is not as expected
       	   test.fail("Product is not added to saveForLater");
           logger.info("Product is not added to saveForLater");
       }
   }
   
   // Method to validate if adding a product to the wishlist results in an error
   public static void validatingProductisAddtoWishListerror(WebDriver driver) {
	   test.info("Validating error message displayed");
	   
	   // Create a FluentWait for dynamic element wait
	   Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement addTowishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully removed from your favorites')]")));
       // Get the text of the alert
       String actualAddToCart = addTowishList.getText();
       // Expected alert text
       String expectedAddToCart = "Successfully removed from your favorites";
       
       // Check if the actual alert text matches the expected text
       if (actualAddToCart.equals(expectedAddToCart)) {
           // Success message is displayed
       	   test.pass(expectedAddToCart+ "Error diaplayed successfully");
           logger.info(expectedAddToCart+ "Error diaplayed successfully");
       } else {
           // Success message is not as expected
       	   test.fail(expectedAddToCart+ "Error not diaplayeds");
           logger.info(expectedAddToCart+ "Error not diaplayeds");
       }
   }
   
//   // Create a FluentWait for dynamic element wait
//  	Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
//      // Wait for the success alert to be visible
//      WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'Successfully added to your cart.')])[" + i + "]")));
//      // Get the text of the alert
//      String actualAddToCart = addToCart.getText();
//      // Expected alert text
//      String expectedAddToCart = "Successfully added to your cart.";
//      
//      // Check if the actual alert text matches the expected text
//      if (actualAddToCart.equals(expectedAddToCart)) {
//          // Success message is displayed
//      	test.pass("Product added to cart");
//          logger.info("Product is added to cart");
//          // Perform actions or assertions here for the success case
//      } else {
//          // Success message is not as expected
//      	test.fail("Product is not added to cart");
//          logger.info("Product is not added to cart");
//          // Perform actions or assertions here for the failure case
//      }
}
