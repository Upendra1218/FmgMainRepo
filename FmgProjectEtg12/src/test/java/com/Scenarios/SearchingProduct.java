package com.Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.homePage;
import com.commonfunctionality.addtoCartValidation;
import com.testcases.baseClass;

public class SearchingProduct extends baseClass{

	public  void searchingProduct() throws InterruptedException {

		
   	  //searching a product
       homePage homepage = new homePage(driver);
       homepage.clickOnSearchBar(this.searchBar);
       test.info("searched a product " + this.searchBar);
       
       //clicked on searched product
       homepage.clickOnSearchedProduct();
       test.info("clicked on searched product");
   
       List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));
       if (pdpPagecheck.size() > 0) {
   	    logger.info("PDP page is already loaded");
   	    test.pass("PDP page is loaded successfully");
   	    // Initialize and execute the PLP page scenario to add a product to the cart
   	    pdpPage.addtoCartPDP();
   	}
		  
	}

}
