package com.RegUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.NavigationProcess;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.plpPage;
import com.testcases.baseClass;

public class tc__RegUserRandomProductFromPLP_InCheckoutPaypal extends baseClass{
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" })
	    public void RegUserRandomProductFromPLP_InCheckoutPaypal() throws InterruptedException {
    	 // Validate login
        if (isLoggedIn) {
	        
			// Initialize NavigationProcess to perform navigation tasks
	        NavigationProcess navProcess = new NavigationProcess(driver);
	        // Select a random menu item
	        navProcess.selectRandomMenu(driver);

	        // Initialize and execute the PLP page scenario to add a product to the cart
	        plpPage.addtocartplp();

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
