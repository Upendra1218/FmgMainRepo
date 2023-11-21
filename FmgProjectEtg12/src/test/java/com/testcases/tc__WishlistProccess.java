package com.testcases;

import org.openqa.selenium.WebDriver;
import com.PageObjects.homePage;

import com.PageObjects.productListingPage;



public class tc__WishlistProccess extends baseClass {

	
	public void wishlistPage(WebDriver driver) throws InterruptedException {
//	 navigationPage navPage= new navigationPage(driver);
//     
//	 //navigates to pdp page randomly
//     navigationProccess nav = new navigationProccess();
//     nav.commonNavigationProccess();
     
     productListingPage plp = new productListingPage(driver);
     plp.selecttheWishlist();
     logger.info("Added product to wishlist");
    
     homePage hp=new homePage(driver);
     Thread.sleep(3000);
     hp.clickOnWishlist(driver);
	 logger.info("clicked on  wishlist");
	 
	 
	

	 Thread.sleep(10000);

	


			}
	
	}


	

