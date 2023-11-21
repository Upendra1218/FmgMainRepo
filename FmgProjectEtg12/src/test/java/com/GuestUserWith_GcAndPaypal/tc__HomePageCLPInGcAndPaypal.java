package com.GuestUserWith_GcAndPaypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePageClp;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__HomePageCLPInGcAndPaypal extends baseClass{
	 @Test
	    public void homePageCLPInGcAndPaypal() throws InterruptedException {
	        // Launch the browser and navigate to the URL
	        launchBrowsering lb = new launchBrowsering();
	        lb.chromeBrowser();

	        // Execute the scenario to navigate from the home page to the CLP (Category Listing Page)
	        homePageClp.homePageCLP();
	        
	     // Initialize MinicartViewCartProcess to perform the checkout process
	        MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
	        // Perform the checkout process
	        cartProcess.checkoutprocess();

	      //semi gc and cc 
			Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
			gCandCC.paymentProccessByGCandCC(driver);
	    }
}
