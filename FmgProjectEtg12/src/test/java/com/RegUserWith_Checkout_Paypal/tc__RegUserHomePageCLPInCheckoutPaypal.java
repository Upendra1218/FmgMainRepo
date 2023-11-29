package com.RegUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePageClp;
import com.testcases.baseClass;

public class tc__RegUserHomePageCLPInCheckoutPaypal extends baseClass {
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" })
	    public void HomePageCLPInCheckoutPaypal() throws InterruptedException {
    	 // Validate login
        if (isLoggedIn) {

	        // Execute the scenario to navigate from the home page to the CLP (Category Listing Page)
	        homePageClp.homePageCLP();
	        
	     // Initialize MinicartViewCartProcess to perform the checkout process
	        MiniCartViewCartRegUser cartProcess = new MiniCartViewCartRegUser();
	        // Perform the checkout process
	        cartProcess.checkoutprocess();

	     // Initialize CheckOutProcessByPayPal to perform the PayPal checkout process
	        CheckOutProcessByPayPal cpp = new CheckOutProcessByPayPal();
	        // Perform the PayPal checkout process
	        cpp.checkoutprocessFromCheckout();
        }
	    }
}
