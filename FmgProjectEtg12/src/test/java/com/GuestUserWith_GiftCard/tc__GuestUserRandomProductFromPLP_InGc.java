package com.GuestUserWith_GiftCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.NavigationProcess;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.plpPage;
import com.commonfunctionality.Gc__CC_Paypal;
import com.testcases.baseClass;

public class tc__GuestUserRandomProductFromPLP_InGc extends baseClass{
	
	@Test
    public void guestUserRandomProductFromPLP_InGc() throws InterruptedException {
        // Launch the browser and navigate to the URL
        launchBrowsering lb = new launchBrowsering();
        lb.chromeBrowser();
        
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

      //gc payment 
	     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
	     gc.paymentByGiftCard();
    }

}
