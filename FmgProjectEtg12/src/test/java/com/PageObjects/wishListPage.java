package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.testcases.baseClass;

public class wishListPage extends baseClass {

    WebDriver lDriver;

    public wishListPage(WebDriver rDriver) {

        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    // Method to remove products with null values from the wishlist
    public void removeButtonwithProductHavingNullValue() throws InterruptedException {

        // Find all product cards in the wishlist
        List<WebElement> productCards = driver.findElements(By.xpath("//div[contains(@class, 'row') and contains(@class, 'product-card')]"));

        // Iterate through each product card
        for (int i = productCards.size(); i >= 1; i--) {

            // Re-fetch the product cards to avoid stale element reference
            List<WebElement> productCardsUpdated = driver.findElements(By.xpath("//div[contains(@class, 'row') and contains(@class, 'product-card')]"));

            // Get the parent element of the product card
            WebElement productcardparent = productCardsUpdated.get(i - 1);

            // Check if the product has null value elements
            List<WebElement> noofInStockElements = productcardparent.findElements(By.xpath(".//span[@class='value' and @content='null']"));

            if (noofInStockElements.size() > 0) {
                Thread.sleep(3000);

                // Find and click the remove button for the product
                List<WebElement> remove = driver.findElements(By.xpath("(//button[starts-with(@class, 'remove-btn-lg remove-from-wishlist')])[" + i + "]"));

                if (remove.size() > 0) {
                    WebElement removeButton = remove.get(0);

                    if (removeButton.isDisplayed()) {
                        // Scroll to the remove button and click it using JavaScriptExecutor
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", removeButton);
                        Thread.sleep(1000);
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("arguments[0].click();", removeButton);
                        logger.info("Removed the wishlist");
                        test.pass("Removed from the wishlist because the price of the product is null");
                    } else {
                        logger.info("Remove button is not visible");
                    }

                    logger.info("Product name with null value: ");
                }
            } else {
                logger.info("Product value is not null.");
            }
        }
    }
    
    
    public void selectingTheAttributesandChangetheSelectAttributesButtonToAddtoCart() {

        // Find all "Select Attributes" buttons on the page
        List<WebElement> selectAttributesButton = driver.findElements(By.xpath("//button[@class='select-attributes-btn btn btn-outline-primary']"));
        int countOfselectAttributesButton = selectAttributesButton.size();
        System.out.println("The total products with 'Select Attributes' button: " + countOfselectAttributesButton);

        // Iterate through each product with the "Select Attributes" button
        for (int i = countOfselectAttributesButton; i >= 1; i--) {

            try {
                Thread.sleep(5000);
                
                // Find the specific "Select Attributes" button for the current product
                WebElement productsInWishlist1 = driver.findElement(By.xpath("(//button[@class='select-attributes-btn btn btn-outline-primary'])[" + i + "]"));

                // Use JavaScriptExecutor to click the "Select Attributes" button
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", productsInWishlist1);
                
                System.out.println("Clicked on 'Select Attributes'");
                Thread.sleep(5000);

               

                // Find the 'Update' button
                Thread.sleep(5000);
                WebElement updateElement = driver.findElement(By.xpath("//button[@class='btn-update-wishlist-product update-cart-product-global btn btn-primary']"));
                
                // Check if the 'Update' button is enabled
                boolean isEnabled = updateElement.isEnabled();

                if (isEnabled) {
                    // If the 'Update' button is enabled, click it
                    System.out.println("Button is enabled");
                    updateElement.click();
                    logger.info("Clicked on 'Update'");
                    test.pass("Product is changed from 'Select Attributes' to 'Add To Cart'");
                } else {
                    // If the 'Update' button is disabled, handle this case as needed
                    System.out.println("Button is disabled");
                    // You may want to log and handle this scenario accordingly
                }
            } catch (InterruptedException e) {
                // Handle any InterruptedException that may occur during thread sleep
                e.printStackTrace();
            }
        }
    }
    
    
  //button[contains(@class, 'add-to-cart')]
  //button[contains(@class, 'remove-btn')]

    
	 public void allProductsAddedtoCart() {
		 
		// Find all "Add to Cart" buttons on the page within the wishlist section
		 List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[@class='add-to-cart btn btn-primary']"));
		 int countOfAddToCartButtons = addToCartButtons.size();
		 System.out.println("The total products in the wishlist: " + countOfAddToCartButtons);

		 // Iterate through each "Add to Cart" button in reverse order (from last to first)
		 for (int j = countOfAddToCartButtons - 1; j >= 0; j--) {
		     WebElement addToCartButton = addToCartButtons.get(j);

		     try {
		         // Check if the "Add to Cart" button is enabled
		         boolean isEnabled = addToCartButton.isEnabled();

		         if (isEnabled) {
		             // If the button is enabled, click it using JavaScriptExecutor
		             System.out.println("Button is enabled");
		             JavascriptExecutor js = (JavascriptExecutor) driver;
		             js.executeScript("arguments[0].click();", addToCartButton);

		             // Log and report that the product is added to the cart
		             logger.info("Product added to cart");
		             test.pass("Product is successfully added to the cart");
		         } else {
		             // If the button is disabled, remove the product from the wishlist
		             WebElement removeButton = driver.findElement(By.xpath("//button[@class='remove-btn-lg remove-from-wishlist btn btn-light']"));
		             removeButton.click();

		             System.out.println("Button is disabled");
		         }
		     } catch (StaleElementReferenceException e) {
		         // Handle StaleElementReferenceException, which can occur if the DOM changes while iterating
		         // Re-find the "Add to Cart" buttons to prevent StaleElementReferenceException
		         addToCartButtons = driver.findElements(By.xpath("//button[@class='add-to-cart btn btn-primary']"));
		         addToCartButton = addToCartButtons.get(j);

		         // Increment j to repeat the same index in the next iteration
		         j++;
		     }
		 }

	 }
}
