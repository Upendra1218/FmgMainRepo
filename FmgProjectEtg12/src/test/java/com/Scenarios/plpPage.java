// Import necessary classes and packages
package com.Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// Import relevant page objects and base class
import com.PageObjects.productListingPage;
import com.testcases.baseClass;

// Class definition for plpPage, which extends the baseClass
public class plpPage extends baseClass {

    // Method to add a product to the cart from the Product Listing Page (PLP)
    public static void addtocartplp() throws InterruptedException {
    
        // Initialize productListingPage to interact with the product listing page
        productListingPage plp = new productListingPage(driver);
        
        // Check if the Product Listing Page (PLP) is loaded
        List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
        if(plpPagecheck.size() > 0) {
            
            // Call the method to display the name of the PLP
            plp.nameofPlp();
            
            // Sort the filters on the Product Listing Page
            // The '2' represents the index of the filter; you may need to adjust it based on your application
            plp.selecttheFilters(2, driver);
            Thread.sleep(7000);  // Introducing a delay (in milliseconds) for demonstration purposes

            // Select a filter from the Product Listing Page
            plp.selectaFilterFormPLP();
            
            // Select the reset button to reset the filters
            plp.selecttheResetButton();

            // Add a product to the wishlist from the Product Listing Page
            plp.selecttheWishlist();
            
            Thread.sleep(3000);  // Introducing a delay (in milliseconds) for demonstration purposes

            // Add a product to the cart from the Product Listing Page
            plp.addMultipleProductsFromPlp();
            Thread.sleep(3000);  // Introducing a delay (in milliseconds) for demonstration purposes

            // Retrieve and display product prices and book details
            plp.tierPrice();
        }
    }
}
