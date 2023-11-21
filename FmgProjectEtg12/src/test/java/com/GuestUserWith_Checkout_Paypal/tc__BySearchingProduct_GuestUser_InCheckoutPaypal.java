package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.SearchingProduct;
import com.testcases.baseClass;

public class tc__BySearchingProduct_GuestUser_InCheckoutPaypal extends baseClass {
    
    // Create a SoftAssert object to perform soft assertions
    SoftAssert softAssert = new SoftAssert();

    @Test(invocationCount = 2)
    public void bySearchingProduct_GuestUser_InCheckoutPaypal() throws InterruptedException {
        
        // Launch the browser and navigate to the URL
        launchBrowsering lb = new launchBrowsering();
        lb.chromeBrowser();
        
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
