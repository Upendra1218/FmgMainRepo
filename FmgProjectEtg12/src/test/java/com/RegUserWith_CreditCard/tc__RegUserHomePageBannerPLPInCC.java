package com.RegUserWith_CreditCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.CreditCardPaymentProcessReg;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePagePlp;
import com.testcases.baseClass;

public class tc__RegUserHomePageBannerPLPInCC extends baseClass {
    
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" }, alwaysRun = true)
    public void HomePageBannerPLP() throws InterruptedException {
    	 // Validate login
        if (isLoggedIn) {

        // Execute the scenario to navigate to the PLP page from the home page banner
        homePagePlp.homePagePLP();

        // Initialize MinicartViewCartProcess to perform the checkout process
        MiniCartViewCartRegUser cartProcess = new MiniCartViewCartRegUser();
        // Perform the checkout process
        cartProcess.checkoutprocess();

        // Initialize CreditCardPaymentProcess to perform the payment using a credit card
        CreditCardPaymentProcess ccPaymentProcess = new CreditCardPaymentProcess();
        // Perform the payment using a credit card
        ccPaymentProcess.paymentByCreditCard();
        }
    }
}
