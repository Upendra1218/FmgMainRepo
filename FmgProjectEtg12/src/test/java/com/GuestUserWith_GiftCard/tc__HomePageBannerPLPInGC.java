package com.GuestUserWith_GiftCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePagePlp;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__HomePageBannerPLPInGC extends baseClass{
	 @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
    public void homePageBannerPLPInGC() throws InterruptedException {
        
       if(isBrowserLaunched){
        

        // Execute the scenario to navigate to the PLP page from the home page banner
        homePagePlp.homePagePLP();

        // Initialize MinicartViewCartProcess to perform the checkout process
        MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
        // Perform the checkout process
        cartProcess.checkoutprocess();

      //gc payment 
	     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
	     gc.paymentByGiftCard();
       }
    }


}
