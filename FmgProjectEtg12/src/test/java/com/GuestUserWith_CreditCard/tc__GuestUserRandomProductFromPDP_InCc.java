package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.pdpPage;
import com.testcases.baseClass;

public class tc__GuestUserRandomProductFromPDP_InCc extends baseClass {
    
    @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
    public void ProductFromPDP() throws InterruptedException {
        
       if(isBrowserLaunched){
        
        
        // Execute the scenario to add a product to the cart from the PDP (Product Detail Page)
        pdpPage.addtoCartPDP();

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
