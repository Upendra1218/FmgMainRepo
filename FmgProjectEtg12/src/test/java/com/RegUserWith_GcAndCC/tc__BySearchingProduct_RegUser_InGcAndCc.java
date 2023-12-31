package com.RegUserWith_GcAndCC;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.SearchingProduct;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__BySearchingProduct_RegUser_InGcAndCc extends baseClass{
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" })
    public void bySearchingProduct_RegUser_InGcAndCc() throws InterruptedException {
        
    	 // Validate login
        if (isLoggedIn) {
        
        // Search for a product
        SearchingProduct sp1 = new SearchingProduct();
        sp1.searchingProduct();

        // Initialize MinicartViewCartProcess to perform the checkout process
        MiniCartViewCartRegUser cartProcess = new MiniCartViewCartRegUser();
        // Perform the checkout process
        cartProcess.checkoutprocess();

      //semi gc and cc 
      		Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
      		gCandCC.paymentProccessByGCandCC(driver);
        }
    }

}
