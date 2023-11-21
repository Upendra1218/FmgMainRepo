package com.RegUserWith_GcAndCC;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.pdpPage;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__RegUserRandomProductFromPDP_InGcAndCc extends baseClass{
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" }, alwaysRun = true)
	public void guestUserRandomProductFromPDP_InGcAndCc() throws InterruptedException {
    	 // Validate login
        if (isLoggedIn) {
	    // Execute the scenario to add a product to the cart from the PDP (Product Detail Page)
	    pdpPage.addtoCartPDP();

	    // Initialize MinicartViewCartProcess to perform the checkout process
	    MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
	    
	    // Perform the checkout process
	    cartProcess.checkoutprocess();
		
	  //semi gc and cc 
	  		Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
	  		gCandCC.paymentProccessByGCandCC(driver);
        }
	}
	

}
