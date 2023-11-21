package com.RegUserWith_GcAndPaypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.SearchingProduct;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__BySearchingProduct_RegUser_InGcAndPaypal extends baseClass {
	 
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" }, alwaysRun = true)
    public void bySearchingProduct_GuestUser_InGcAndPaypal() throws InterruptedException {
        
    	 // Validate login
        if (isLoggedIn) {
        
        // Search for a product
        SearchingProduct sp1 = new SearchingProduct();
        sp1.searchingProduct();

        // Initialize MinicartViewCartProcess to perform the checkout process
        MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
        // Perform the checkout process
        cartProcess.checkoutprocess();

        //gc and paypal
		  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
		  gcAndPaypal.paymentProccessByGCandPaypal();
        }
    }
}
