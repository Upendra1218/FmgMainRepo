

package com.GuestUserWith_CreditCard;

import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MiniCartChekoutButton;
import com.Scenarios.SearchingProduct;
import com.testcases.baseClass;

import org.testng.annotations.Test;

public class tc__BySearchingProduct_GuestUser_InCC extends baseClass {
	 
	 @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
    public void bySearchingProduct_GuestUser_InCC() throws InterruptedException {
		
      if(isBrowserLaunched) {

        //searching a product 		
		SearchingProduct sp1 = new SearchingProduct();
		sp1.searchingProduct();
		
		//this is for the guest
		guestuser = true;

		// Initialize MinicartViewCartProcess to perform the checkout process
		MiniCartChekoutButton cartProcess = new MiniCartChekoutButton();
        // Perform the checkout process
        cartProcess.checkoutprocess();

        // Initialize CreditCardPaymentProcess to perform the payment using a credit card
        CreditCardPaymentProcess ccPaymentProcess = new CreditCardPaymentProcess();
        // Perform the payment using a credit card
        ccPaymentProcess.paymentByCreditCard();
      }
    }
}