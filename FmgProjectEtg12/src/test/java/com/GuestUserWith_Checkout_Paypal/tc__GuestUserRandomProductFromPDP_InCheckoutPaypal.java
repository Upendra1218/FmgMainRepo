package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.pdpPage;
import com.testcases.baseClass;

public class tc__GuestUserRandomProductFromPDP_InCheckoutPaypal extends baseClass{
	 @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
	public void GuestUserRandomProductFromPDP_InCheckoutPaypal() throws InterruptedException {
		
	   if(isBrowserLaunched){
	    
	    
	    // Execute the scenario to add a product to the cart from the PDP (Product Detail Page)
	    pdpPage.addtoCartPDP();

	    // Initialize MinicartViewCartProcess to perform the checkout process
	    MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
	    
	    // Perform the checkout process
	    cartProcess.checkoutprocess();
		
	 // Initialize CheckOutProcessByPayPal to perform the PayPal checkout process
        CheckOutProcessByPayPal cpp = new CheckOutProcessByPayPal();
        // Perform the PayPal checkout process
        cpp.checkoutprocessFromCheckout();
	   }
	}
	

}
