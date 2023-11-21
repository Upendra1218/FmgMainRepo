package com.GuestUserWith_GcAndCC;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.SearchingProduct;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__BySearchingProduct_GuestUser_InGcAndCc extends baseClass{
	@Test
    public void bySearchingProduct_GuestUser_InGcAndCc() throws InterruptedException {
        
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

      //semi gc and cc 
      		Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
      		gCandCC.paymentProccessByGCandCC(driver);
    }

}
