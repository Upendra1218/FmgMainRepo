package com.RegUserWith_GiftCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePageClp;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__RegUserHomePageCLPInGc extends baseClass{
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" })
	    public void homePageCLPInGc() throws InterruptedException {
    	 // Validate login
        if (isLoggedIn) {

	        // Execute the scenario to navigate from the home page to the CLP (Category Listing Page)
	        homePageClp.homePageCLP();
	        
	     // Initialize MinicartViewCartProcess to perform the checkout process
	        MiniCartViewCartRegUser cartProcess = new MiniCartViewCartRegUser();
	        // Perform the checkout process
	        cartProcess.checkoutprocess();

	      //gc payment 
		     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
		     gc.paymentByGiftCard();
        }
	    }

}
