package com.Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.homePage;
import com.testcases.baseClass;

public class homePagePlp extends baseClass{
	
    public static void homePagePLP() throws InterruptedException {
        
        // Select a banner from the home page
        homePage hp = new homePage(driver);
        hp.selectHeroBanner();
        
        // Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
        List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
        
        // If the PLP page is loaded, proceed to add a product to the cart.
        if (plpPagecheck.size() > 0) {
            logger.info("PLP page is already loaded");
            // Initialize and execute the PLP page scenario to add a product to the cart
            plpPage.addtocartplp();
        } else {
            // If the PDP (Product Detail Page) is loaded, log that it's already loaded.
            logger.info("PDP page is already loaded");
        }
    }
}

