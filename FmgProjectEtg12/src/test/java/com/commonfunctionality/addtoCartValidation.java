package com.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.testcases.baseClass;

public class addtoCartValidation extends baseClass{
	
   public static void validatingProductisAddtoCart(WebDriver driver) {
	   test.info("Validating product is add to the cart");
	   List<WebElement> cartEnabledList =driver.findElements(By.xpath("//button[contains(@class,'add-to-cart')]"));
	   if(cartEnabledList.size()>0) {
		   WebElement cartEnabled =driver.findElement(By.xpath("//button[contains(@class,'add-to-cart')]"));
		   if(cartEnabled.isEnabled()) {
		    Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
	        // Wait for the success alert to be visible
	        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
	        // Get the text of the alert
	        String actualAddToCart = addToCart.getText();
	        // Expected alert text
	        String expectedAddToCart = "Product added to cart";
	        if (actualAddToCart.equals(expectedAddToCart)) {
	            // Success message is displayed
	        	test.pass("Product added to cart");
	            logger.info("Product is  added to cart");
	            System.out.println("Successfully product added to cart: " + actualAddToCart);
	            // Perform actions or assertions here for the success case
	        }else {
	            // Success message is not as expected
	        	test.fail("Product is not added to cart");
	            logger.info("Product is not added to cart");
	            System.out.println("The product is not added to cart because it should show: " + expectedAddToCart + " but found: " + actualAddToCart);
	            // Perform actions or assertions here for the failure case
	         
	          }
		   } 
	   }
   }
   
   public static void validatingGiftCardAddtoCart(WebDriver driver) {
	   
	   test.info("Validating gift card is add to the cart");
	   
	    Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement gifcartAddtoCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
       // Get the text of the alert
       String actualAddToCart = gifcartAddtoCart.getText();
       // Expected alert text
       String expectedAddToCart = "Gift Certificate added to cart";
       if (actualAddToCart.equals(expectedAddToCart)) {
           // Success message is displayed
       	   test.pass("Gift Certificate added to cart");
           logger.info("Gift Certificate added to cart");
           System.out.println("Successfully gift card added to cart: " + actualAddToCart);
           // Perform actions or assertions here for the success case
       }else {
           // Success message is not as expected
       	   test.fail("Gift Certificate not added to cart");
           logger.info("Gift Certificate not added to cart");
           System.out.println("The product is not added to cart because it should show: " + expectedAddToCart + " but found: " + actualAddToCart);
           // Perform actions or assertions here for the failure case
        
         }
   }

}
