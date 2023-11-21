package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.giftCard;
import com.testcases.baseClass;

public class tc__OnlyGiftCards_GuestUser_InCc extends baseClass{

	 @Test(invocationCount = 1)
	public void OnlyGiftCards() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		 
		 //adding GC into cart
	    giftCard gc = new giftCard();
	    gc.giftCards();
		
		 //checkoutProcess
		 MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
			     
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
	     cc.paymentByCreditCard();
	     
	     Thread.sleep(2000);
	}
}
