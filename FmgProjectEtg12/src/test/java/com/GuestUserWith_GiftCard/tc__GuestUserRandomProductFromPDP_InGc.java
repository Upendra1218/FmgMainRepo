package com.GuestUserWith_GiftCard;

import org.testng.annotations.Test;

import com.PaymentProccess.MiniCartChekoutButton;
import com.Scenarios.pdpPage;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__GuestUserRandomProductFromPDP_InGc extends baseClass{
	
	 @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
	public void guestUserRandomProductFromPDP_InGc() throws InterruptedException {
		
	   if(isBrowserLaunched){
	    
	    
	    // Execute the scenario to add a product to the cart from the PDP (Product Detail Page)
	    pdpPage.addtoCartPDP();

	    // Initialize MinicartViewCartProcess to perform the checkout process
	    MiniCartChekoutButton cartProcess = new MiniCartChekoutButton();
	    
	    // Perform the checkout process
	    cartProcess.checkoutprocess();
		
	  //gc payment 
	     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
	     gc.paymentByGiftCard();
	   }
	}
	

}
