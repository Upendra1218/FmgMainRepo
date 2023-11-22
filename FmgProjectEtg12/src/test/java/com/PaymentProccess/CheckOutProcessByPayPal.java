package com.PaymentProccess;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.PageObjects.TierPrice;
import com.PageObjects.miniCartPage;
import com.PageObjects.paymentpPage;
import com.PageObjects.reviewOrderPage;
import com.PageObjects.taxCalculation;
import com.PageObjects.viewCartPage;
import com.Validations.Checkout_Validation;
import com.Validations.miniCartAndCartValidation;
import com.testcases.baseClass;

public class CheckOutProcessByPayPal extends baseClass{
		
	 Checkout_Validation checkout= new Checkout_Validation();
	 

	 
	 //checkout from viewcart paypal button
	    
	 		public void checkoutprocessFromViewCart() throws InterruptedException {
	 			List <WebElement> minicartcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
	 		     
	 	     
	 	       
	 	       // minicart and check out validation
	 			miniCartAndCartValidation validation= new miniCartAndCartValidation();
	 		       if(minicartcount.size()>0) {
	 		    	   WebElement miniCartDisplay = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
	 		    	   if(miniCartDisplay.isDisplayed()) {
	 			    	   WebElement minicartcount1 = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
	 			    	   String countOfMinicart = minicartcount1.getText();
	 			    	   int minicartCountValue = Integer.parseInt(countOfMinicart);
	 			
	 			        if (minicartCountValue > 0) {		
	 			            miniCartPage mc = new miniCartPage(driver);		            
	 			            
	 			            mc.hoverOnCartButton(driver);
	 			       
	 			            
	 			            List <WebElement> minicartPopUp = driver.findElements(By.xpath("(//h1)[1]"));
	 			            if(minicartPopUp.size()>0) {
	 			            	
	 				            //validate the button click 			          
	 				            validation.validateMiniCartClick();
	 		         
	 				           //assortable price  dissount  and its color                
	 			                TierPrice tp= new  TierPrice();
	 			                tp.onlyTier();
	 				            
	 				            //clicks on view cart button 
	 				            mc.clickviewCartButton(driver);
	 							logger.info("clicked the view cart button in the minicart");
	 							
	 							//validate the view cart button click
	 							validation.validateViewCartClick();
	 		
	 			            }		
	 			            
	 			           // Initialize the view cart page
	 			            viewCartPage vcp = new viewCartPage(driver);
	 			            
	 					            Random random = new Random();
	 					            int randomNumber = random.nextInt(2); // Generates a random number between 0 (inclusive) and 2 (exclusive)
	 					
	 					            if (randomNumber == 0) {
	 					               vcp.quantityInsertionInCartPage();
	 					            } else {
	 					                vcp.noQuantityInsertionInCartPage();
	 					            }
	 						 
	 				               
									//product price
	 				                vcp.productsCalInCart();
	 				                
	 				                //calcuates shipping charges
	 				                vcp.estimatedshippingCalculations();
	 				                	            
	 				                //total product cost
	 				                viewCartPage.totalProductsCost();
			            
					        Thread.sleep(2000);
				            List<WebElement> brainPayPalButton = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
				          			            
					            if(brainPayPalButton.size()>0) {
					            	test.info("Braintree payment integration is activated");
					            	 vcp.braintreePayPalButton(driver);
					            }
						        	paymentpPage pp =new paymentpPage(driver);
						        	Thread.sleep(2000);
						        	
						        	//paypal pop up
									pp.paypalPopup(driver);
										
									  List<WebElement> cartPage = driver.findElements(By.xpath("//h1[contains(text(),'Your Shopping Cart')]"));
									  if(cartPage.size()>0) {
										  
										  test.info("Some times the paypal in cart page will not navigate to review order page it will navigate for 2nd time");
										  
										  //clicks on paypal button
										  	vcp.braintreePayPalButton(driver);
										  	
										  //paypal pop up
											pp.paypalPopup(driver);
									  }
		          			            
									Thread.sleep(2000);
									 //total prodcut
									taxCalculation shippingMtd = new taxCalculation();
						    		shippingMtd.totalProductValidation();
						    		 
						    		 // granD TOTAL 
						    		shippingMtd.grandTotalValidation();
									
									//place order 
									reviewOrderPage rop = new reviewOrderPage(driver);
						    		Thread.sleep(4000);					    	
						    		rop.clickonplaceorderwithJsExuter(driver);
						    		
						    		Thread.sleep(5000);
															
									 Checkout_Validation checkout= new Checkout_Validation();
									 //validate the final place the order page
									 checkout.validatePlacetheOrderPage();							
									 //ordernumberandOrderdate
									 checkout.ordernumberandOrderdate();
									 Thread.sleep(3000);
									
	 			        }
	 		    	 }
	 			   }
		    	  	           
	 		}
	        
	    public void checkoutprocessFromCheckout() throws InterruptedException {
	    	
	    
	    	List<WebElement> paymnetPage= driver.findElements(By.xpath("//h2[contains(text(),'Payment Method')]"));
	    	
		    	  if(paymnetPage.size()>0) {					

			    	 	List<WebElement> brainPaypalAcc = driver.findElements(By.xpath("//li[@data-method-id='PayPal']"));			    
				    	
				    	JavascriptExecutor js = (JavascriptExecutor) driver;	    		  
			    		
		
			    	 if(brainPaypalAcc.size()>0) {	
			    		 
			    		test.info("Brain tree payment integration is activated");		    	
				    		paymentpPage pp =new paymentpPage(driver);	   				    		
				    		pp.braintreePaypal(driver);
				    		js.executeScript("window.scrollBy(0,500)", "");
				    		

			    		if (driver.findElement(By.xpath("//button[contains(@class,'submit-payment')]")).isDisplayed()) {
			    			
			    			
			    			    logger.info("After the click of paypal");
				    			reviewOrderPage rop = new reviewOrderPage(driver);
				    			Thread.sleep(2000);
				    		
				    	    //review order page 
					    		rop.clickonReviewOrder(driver);				    			    		
					    		Thread.sleep(4000);
					    		
					    	//place order 
					    		rop.clickonplaceorderwithJsExuter(driver);
					    		
			
	
						}else  {
							pp.brainTreeAfterClick(driver);
										
					    	pp.paypalPopup(driver);
					    	
					    	
					    				    	
					    	reviewOrderPage rop = new reviewOrderPage(driver);
   			    		
				    		Thread.sleep(4000);
				    		
				    		
				    		 //total prodcut
				    		taxCalculation shippingMtd = new taxCalculation();
				    		shippingMtd.totalProductValidation();
				    		 
				    		 // granD TOTAL 
				    		shippingMtd.grandTotalValidation();
					    	//place order				    		
				    		 rop.clickonplaceorderwithJsExuter(driver);
				    		
    		
						}
			    	}
   	  
		    		Thread.sleep(5000);
		    	
		    			 Checkout_Validation checkout= new Checkout_Validation();
		    		 //validate the final place the order page
		    			 checkout.validatePlacetheOrderPage();
		    		
		    	     //ordernumberandOrderdate
		    			 checkout.ordernumberandOrderdate();
		    			 Thread.sleep(5000);
		    			 
		    			 
		    	  }	
	    }
	    
	
		
}
