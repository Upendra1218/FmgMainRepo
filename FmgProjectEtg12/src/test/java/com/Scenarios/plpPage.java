// Import necessary classes and packages
package com.Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.productListingPage;
import com.testcases.baseClass;

// Class definition for plpPage, which extends the baseClass
public class plpPage extends baseClass {

    // Method to add a product to the cart from the Product Listing Page (PLP)
    public static void addtocartplp() throws InterruptedException {
    
        // Initialize productListingPage to interact with the product listing page
        productListingPage plp = new productListingPage(driver);
        
		List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
		if(plpPagecheck.size()>0) {
			
	        // Step 1: Sort the filters on the Product Listing Page
	        plp.selecttheFilters(2, driver);
	        Thread.sleep(7000);  // Introducing a delay (in milliseconds) for demonstration purposes

	        // Step 2: Select a filter from the Product Listing Page
	        //plp.selectaFilterFormPLP();

	        // Step 3: Add a product to the wishlist from the Product Listing Page
	        plp.selecttheWishlist();
	        Thread.sleep(3000);  // Introducing a delay (in milliseconds) for demonstration purposes

	        // Step 4: Add a product to the cart from the Product Listing Page
//	        plp.addToCartFromPlp();
//	        Thread.sleep(3000);  // Introducing a delay (in milliseconds) for demonstration purposes

	        // Step 5: Retrieve and display product prices and book details
	        plp.tierPrice();
		}
                

    }
}
