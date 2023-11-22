package com.RegUserWith_CreditCard;

import org.testng.annotations.Test;
import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.NavigationProcess;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.CreditCardPaymentProcessReg;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.plpPage;
import com.testcases.baseClass;

public class tc__RegUserRandomProductFromPLP_InCc extends baseClass {

	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" }, alwaysRun = true)
    public void RegUserRandomProductFromPLP_InCc() throws InterruptedException {
    	 // Validate login
        if (isLoggedIn) {
        
		// Initialize NavigationProcess to perform navigation tasks
        NavigationProcess navProcess = new NavigationProcess(driver);
        // Select a random menu item
        navProcess.selectRandomMenu(driver);

        // Initialize and execute the PLP page scenario to add a product to the cart
        plpPage.addtocartplp();

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
