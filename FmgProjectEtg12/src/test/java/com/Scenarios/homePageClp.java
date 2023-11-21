package com.Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.CLPpage;
import com.PageObjects.homePage;
import com.PageObjects.productListingPage;
import com.testcases.baseClass;

public class homePageClp extends baseClass{

    public static void homePageCLP() throws InterruptedException {
        
        // Select a banner from the home page
        homePage hp = new homePage(driver);
        hp.homepageClickClp();
        
        // Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
        List<WebElement> clpPagecheck = driver.findElements(By.xpath("//div[@id='maincontent']"));
        List<WebElement> bannerscheck = driver.findElements(By.xpath("//div[@class='hero-banner']"));
        logger.info(clpPagecheck.size());
        logger.info(bannerscheck.size());
        
        // If banners are found on the page, select a hero banner.
        if (bannerscheck.size() > 0) {
            productListingPage plp = new productListingPage(driver);
            plp.selectHeroBanner();
        } else if (clpPagecheck.size() > 0) {
            // Move to CLP (Category Listing Page) from the home page.
            CLPpage clp = new CLPpage(driver);
            clp.selectaClpRandomly();
            List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
            
            // If PLP is loaded, proceed to add a product to the cart.
            if (plpPagecheck.size() > 0) {
                logger.info("PLP page is already loaded");
                test.pass("PLP page is loaded successfully");
                // Initialize and execute the PLP page scenario to add a product to the cart
                 plpPage.addtocartplp();
                List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));
                if (pdpPagecheck.size() > 0) {
            	    logger.info("PDP page is already loaded");
            	    test.pass("PDP page is loaded successfully");
            	    // Initialize and execute the PLP page scenario to add a product to the cart
            	    pdpPage.addtoCartPDP();
            	}
            } else {
                logger.info("PDP page is already loaded");
            }
        }else {
        	logger.info("The clp or any other page is not loaded");
        }
    }
}

