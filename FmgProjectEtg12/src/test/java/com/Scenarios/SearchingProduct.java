package com.Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.homePage;
import com.PageObjects.productListingPage;
import com.commonfunctionality.addtoCartValidation;
import com.testcases.baseClass;

public class SearchingProduct extends baseClass{

	public  void searchingProduct() throws InterruptedException {

   	  //searching a product
       homePage homepage = new homePage(driver);
       homepage.clickOnSearchBar(searchBar);
       test.info("searched a product " +searchBar);
       Thread.sleep(3000);
       //clicked on searched product
       homepage.clickOnSearchedProduct();
       test.info("clicked on searched product");
       Thread.sleep(2000);
       
       List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));
       logger.info(pdpPagecheck.size());
       if (pdpPagecheck.size() > 0) {
   	    logger.info("PDP page is already loaded");
   	    test.pass("PDP page is loaded successfully");
   	    // Initialize and execute the PLP page scenario to add a product to the cart
   	    pdpPage.addtoCartPDP();
   	}else {
   		List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
   		logger.info(pdpPagecheck.size());
		if(plpPagecheck.size()>0) {
			// Initialize productListingPage to interact with the product listing page
	        productListingPage.selectRandomProduct();
	        if (pdpPagecheck.size() > 0) {
	    	    logger.info("PDP page is already loaded");
	    	    test.pass("PDP page is loaded successfully");
	    	    // Initialize and execute the PLP page scenario to add a product to the cart
	    	    pdpPage.addtoCartPDP();
	        }
		}
			
   	}
		  
	}

}
