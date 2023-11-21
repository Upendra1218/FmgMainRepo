package com.RegUserWith_Checkout_Paypal;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.SearchingProduct;
import com.testcases.baseClass;

public class tc__BySearchingProduct_RegUser_InCheckoutPaypal extends baseClass {
    
    // Create a SoftAssert object to perform soft assertions
    SoftAssert softAssert = new SoftAssert();

 // Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" }, alwaysRun = true)
    public void bySearchingProduct_RegUser_InCheckoutPaypal() throws InterruptedException {
        
    	 // Validate login
        if (isLoggedIn) {
        
        // Search for a product
        SearchingProduct sp1 = new SearchingProduct();
        sp1.searchingProduct();

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
