package com.GuestUserWith_GcAndCC;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.pdpPage;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__GuestUserRandomProductFromPDP_InGcAndCc extends baseClass{
	@Test
	public void guestUserRandomProductFromPDP_InGcAndCc() throws InterruptedException {
		// Launch the browser and navigate to the URL
	    launchBrowsering lb = new launchBrowsering();
	    lb.chromeBrowser();
	    
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
