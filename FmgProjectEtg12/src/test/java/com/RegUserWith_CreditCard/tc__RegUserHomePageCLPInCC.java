package com.RegUserWith_CreditCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.CreditCardPaymentProcessReg;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePageClp;
import com.testcases.baseClass;

public class tc__RegUserHomePageCLPInCC extends baseClass {
    
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" })
    public void HomePageCLPInCC() throws InterruptedException {
    	 // Validate login
        if (isLoggedIn) {
        
        Thread.sleep(5000);
        
   
        // Execute the scenario to navigate from the home page to the CLP (Category Listing Page)
        homePageClp.homePageCLP();
        
        // Initialize MinicartViewCartProcess to perform the checkout process
        MiniCartViewCartRegUser cartProcess = new MiniCartViewCartRegUser();
        // Perform the checkout process
        cartProcess.checkoutprocess();

        // Initialize CreditCardPaymentProcess to perform the payment using a credit card
        CreditCardPaymentProcessReg ccPaymentProcess = new CreditCardPaymentProcessReg();
        // Perform the payment using a credit card
        ccPaymentProcess.paymentByCreditCard();
        }
    }
}
