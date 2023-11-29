package com.RegUserWith_CreditCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.CreditCardPaymentProcessReg;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.pdpPage;
import com.testcases.baseClass;

public class tc__RegUserRandomProductFromPDP_InCc extends baseClass {
    int minicartCountValue;
    
 // Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" })
    public void ProductFromPDP() throws InterruptedException {
    	 // Validate login
        if (isLoggedIn) {
        
        // Execute the scenario to add a product to the cart from the PDP (Product Detail Page)
        pdpPage.addtoCartPDP();

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
