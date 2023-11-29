package com.RegUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePagePlp;
import com.testcases.baseClass;

public class tc__RegUserHomePageBannerPLPInCheckoutPaypal extends baseClass{
	
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" })
    public void HomePageBannerPLPInCheckoutPaypal() throws InterruptedException {
    	 // Validate login
        if (isLoggedIn) {

        // Execute the scenario to navigate to the PLP page from the home page banner
        homePagePlp.homePagePLP();

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
