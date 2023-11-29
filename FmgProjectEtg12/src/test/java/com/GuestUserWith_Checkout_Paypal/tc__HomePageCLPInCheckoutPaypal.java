package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePageClp;
import com.testcases.baseClass;

public class tc__HomePageCLPInCheckoutPaypal extends baseClass {
	 @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
	    public void HomePageCLPInCheckoutPaypal() throws InterruptedException {
	        
	       if(isBrowserLaunched){
	        

	        // Execute the scenario to navigate from the home page to the CLP (Category Listing Page)
	        homePageClp.homePageCLP();
	        
	     // Initialize MinicartViewCartProcess to perform the checkout process
	        MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
	        // Perform the checkout process
	        cartProcess.checkoutprocess();

	     // Initialize CheckOutProcessByPayPal to perform the PayPal checkout process
	        CheckOutProcessByPayPal cpp = new CheckOutProcessByPayPal();
	        // Perform the PayPal checkout process
	        cpp.checkoutprocessFromCheckout();}
	    }
}
