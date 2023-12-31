package com.GuestUserWith_GcAndCC;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.NavigationProcess;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.plpPage;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__GuestUserRandomProductFromPLP_InGcAndCc extends baseClass{
	 @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
    public void guestUserRandomProductFromPLP_InGcAndCc() throws InterruptedException {
        
       if(isBrowserLaunched){
        
        
		// Initialize NavigationProcess to perform navigation tasks
        NavigationProcess navProcess = new NavigationProcess(driver);
        // Select a random menu item
        navProcess.selectRandomMenu(driver);

        // Initialize and execute the PLP page scenario to add a product to the cart
        plpPage.addtocartplp();

        // Initialize MinicartViewCartProcess to perform the checkout process
        MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
        // Perform the checkout process
        cartProcess.checkoutprocess();

      //semi gc and cc 
      		Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
      		gCandCC.paymentProccessByGCandCC(driver);
       }
    }
}
