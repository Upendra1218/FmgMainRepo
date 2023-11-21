package com.RegUserWith_GcAndPaypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePageClp;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__RegUserHomePageCLPInGcAndPaypal extends baseClass{
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" }, alwaysRun = true)
	    public void homePageCLPInGcAndPaypal() throws InterruptedException {
    	 // Validate login
        if (isLoggedIn) {

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
}
