package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;
import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.NavigationProcess;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MiniCartChekoutButton;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.plpPage;
import com.testcases.baseClass;

public class tc__GuestUserRandomProductFromPLP_InCc extends baseClass {

	 @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
    public void GuestUserRandomProductFromPLP_InCc() throws InterruptedException {
        
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

        // Initialize CreditCardPaymentProcess to perform the payment using a credit card
        CreditCardPaymentProcess ccPaymentProcess = new CreditCardPaymentProcess();
        // Perform the payment using a credit card
        ccPaymentProcess.paymentByCreditCard();
        
       }
    }
}
