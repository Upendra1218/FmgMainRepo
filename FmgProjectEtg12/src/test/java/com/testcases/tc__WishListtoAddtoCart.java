package com.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PageObjects.homePage;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;

public class tc__WishListtoAddtoCart extends baseClass {
	
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"})
    public void wishListtoCart() throws InterruptedException {

    	tc__WishlistProccess wsh = new tc__WishlistProccess();
    	
    	wsh.wishlistPage(driver);
    	
        //checkout process
    	Thread.sleep(5000);
    	
    	MinicartViewCartProcess cp = new MinicartViewCartProcess();
        
        cp.checkoutprocess();
        
        //payment process
        
        CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
        
        cc.paymentByCreditCard(); 
    	
    }
	
}