// Import necessary packages and classes
package com.PaymentProccess;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.CreditCardPaymentMethods.allPaymentMethods;
import com.PageObjects.ShippingMethodInPaymentPage;
import com.PageObjects.checkOutPage;
import com.PageObjects.homePage;
import com.PageObjects.paymentpPage;
import com.PageObjects.reviewOrderPage;
import com.PageObjects.taxCalculation;
import com.Validations.Checkout_Validation;
import com.Validations.negativeValidation;
import com.Validations.preValidationCheck;
import com.commonfunctionality.editInAllCheckOutProcess;
import com.commonfunctionality.paymentMethods;
import com.testcases.baseClass;

// Define a test class named "tc__CreditCardPaymentProcess"
public class CreditCardPaymentProcessReg extends baseClass{
	
	// Define a method named "paymentByCreditCard"
	public void paymentByCreditCard() throws InterruptedException {
		
//		List<WebElement> billingPage = driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));		
//	
//		if(billingPage.size()>0 ) {
			
//			WebElement billingAddressDisplay = driver.findElement(By.xpath("//label[contains(text(),'Billing Address')]"));	
//			
//				if(billingAddressDisplay.isDisplayed()) {
					
					// Validate the payment page
					preValidationCheck.validatePaymentButtonClk();
					//Credit card negative validations
					//negativeValidation.creditCardDetails();
					
					editInAllCheckOutProcess.clickEditBtnRandomly();
					
			       
					// Detect payment methods
					// Brain Tree
					List<WebElement> brainTree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
				   logger.info(brainTree.size());
				    // Create an instance of the "allPaymentMethods" class
				    allPaymentMethods bpm = new allPaymentMethods();
				    				    
				    // Determine the payment method and proceed accordingly
				    if(brainTree.size()>0) {
				    	logger.info("coming");
				    	bpm.BrainTreeMethod();
				    	
				    } else {
				    	
				    	
				    }		
		
				    
				 // Review order page
	    		reviewOrderPage rop = new reviewOrderPage(driver);
	    		Thread.sleep(4000);	
	    		rop.clickonReviewOrder(driver);
	    		Thread.sleep(4000);	
	    		//total prodcut
	    		//taxCalculation shippingMtd = new taxCalculation();
	    		//shippingMtd.totalProductValidation();
	    		 // granD TOTAL 
	    		//shippingMtd.grandTotalValidation();
	    		
	    		List<WebElement> clickonReviewOrder = driver.findElements(By.xpath("//div[@class='reviewpage-custom']//button[contains(text(), 'Next: Review Order')]"));
	    		int displayedReviewOrder = 0;
	    	    for (WebElement item : clickonReviewOrder) {
	    	        if (item.isDisplayed()) {
	    	        	displayedReviewOrder++;
	    	        }
	    	    }
	    	    logger.info(displayedReviewOrder);
	    		if(displayedReviewOrder>0) {
	    			rop.clickonReviewOrderPaypal();
	    		}else {
	    			logger.info("Next review order already clicked");
	    		}
	    		logger.info("Clicked on review order button");
	    		Thread.sleep(4000);		  
	    		
	    		editInAllCheckOutProcess.clickEditBtnRandomly();


	  	    		//total prodcut
	    		taxCalculation tax= new taxCalculation();
	    		tax.totalProductValidation();
	    		 // granD TOTAL 
	    		tax.grandTotalValidation();
	    		
	    		  		rop.clickonplaceorderwithJsExuter(driver);
	    		
	    		 logger.info("successfully click on the place order button by normal click");
                Thread.sleep(2000);
                logger.info(driver.getTitle());
				    
				    Thread.sleep(5000);
					 // Checkout validation
		    		if(driver.getTitle().equals("Fire Mountain Gems and Beads")) {
		    			
		    			 Checkout_Validation checkout= new Checkout_Validation();
		    			 
		    		 // Validate the final place the order page
		    			 checkout.validatePlacetheOrderPage();
		    		
		    	     // Order number and order date
		    			 checkout.ordernumberandOrderdate();
		    			 
		    			 Thread.sleep(3000);
		    			 

		    		}else if(driver.findElements(By.xpath("//p[contains(text(),'There was a problem processing your payment. Please verify your payment information and try again.')]")).size()>0) {
		    			
		    			test.info("Returned back to payment page , as the Expected behaviour in brain tree is, the order will be failed for 2000-2999.99 $ ,3000.00-3000.99 $ 5000.00 $ ");
	
		    	
		    		}
				//}
//		  }else {
//			  test.fail("Next payment button is not enabled and clicked ");
//		  }
	}
 }//method
//class
	
