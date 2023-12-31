package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePageClp;
import com.testcases.baseClass;

public class tc__HomePageCLPInCC extends baseClass {
    
	 @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
    public void HomePageCLPInCC() throws InterruptedException {
        
       if(isBrowserLaunched){
        
        
        Thread.sleep(5000);
        
   
        // Execute the scenario to navigate from the home page to the CLP (Category Listing Page)
        homePageClp.homePageCLP();
        
     // Initialize MinicartViewCartProcess to perform the checkout process
        MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
        // Perform the checkout process
        cartProcess.checkoutprocess();

        // Initialize CreditCardPaymentProcess to perform the payment using a credit card
        CreditCardPaymentProcess ccPaymentProcess = new CreditCardPaymentProcess();
        // Perform the payment using a credit card
        ccPaymentProcess.paymentByCreditCard();
       }
    }
}
