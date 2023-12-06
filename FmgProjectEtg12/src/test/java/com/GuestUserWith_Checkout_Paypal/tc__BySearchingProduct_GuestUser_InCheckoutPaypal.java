package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MiniCartChekoutButton;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.SearchingProduct;
import com.testcases.baseClass;

public class tc__BySearchingProduct_GuestUser_InCheckoutPaypal extends baseClass {
    

    @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
    public void bySearchingProduct_GuestUser_InCheckoutPaypal() throws InterruptedException {
    	
    	if(isBrowserLaunched){
    		// Search for a product
            SearchingProduct sp1 = new SearchingProduct();
            sp1.searchingProduct();

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

