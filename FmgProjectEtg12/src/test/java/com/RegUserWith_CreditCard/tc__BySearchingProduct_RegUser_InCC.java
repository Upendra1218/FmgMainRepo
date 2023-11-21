

package com.RegUserWith_CreditCard;

import com.PaymentProccess.CreditCardPaymentProcessReg;
import com.PaymentProccess.MiniCartViewCartRegUser;
import com.Scenarios.SearchingProduct;
import com.testcases.baseClass;

import org.testng.annotations.Test;

public class tc__BySearchingProduct_RegUser_InCC extends baseClass {
	 
	// Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" }, alwaysRun = true)
    public void bySearchingProduct_GuestUser_InCC() throws InterruptedException {
		
    	 // Validate login
        if (isLoggedIn) {
			
        //searching a product 		
		SearchingProduct sp1 = new SearchingProduct();
		sp1.searchingProduct();


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