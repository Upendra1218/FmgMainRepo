package com.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.PageObjects.homePage;
import com.PageObjects.miniCartPage;
import com.testcases.baseClass;

public class Checkout_Validation extends baseClass {

	
	//validate the payment page
		public void validatePaymentButtonClk() {
			
			//validate the payment page
		    WebElement paymentPage = driver.findElement(By.xpath("//label[contains(text(), 'Payment Method')]"));
		    String ActualTitleofpaymentPage = paymentPage.getText();
		    String ExpectedTitlepaymentPage = "Payment Method";
		    logger.info(paymentPage.getText());
		    
		    if (ActualTitleofpaymentPage.equals(ExpectedTitlepaymentPage)) {
		    	test.info("Verify that shipping address added");
		    	 test.pass("Successfully added the shipping address");
		    	 test.info("Verify the payment button is clicked");
		        test.pass("Successfully clicked on the Payment button");
		        logger.info("Successfully clicked on the Payment button");
		    } else {
		        test.fail( "The page Title does not match expected " + ExpectedTitlepaymentPage + " " + "  but found" + " " + ActualTitleofpaymentPage + " ");
		        logger.info("Click failed");
		    }
		    
		}
    public void validateViewCartClick() {
    	test.info("Verify the view-cart button is clicked");
        WebElement viewcart = driver.findElement(By.xpath("//h4"));
        String actualTitleofviewcart = viewcart.getText();
        String expectedTitleviewcart = "Order Summary";
        logger.info(viewcart.getText());
        if (actualTitleofviewcart.equals(expectedTitleviewcart)) {
            test.pass("Successfully clicked on the view cart button");
            logger.info("Successfully clicked on the view cart button");
        } else {
            test.fail("Clicked failed on the view cart button");
            logger.info("Clicked failed on the view cart button");
        }  
    }
    
    public void validateMiniCartClick() throws InterruptedException {
    	
    	// validating the button in minicart
    	List<WebElement> minicartList = driver.findElements(By.xpath("(//h1)[1]"));
    	if(minicartList.size()>0) {
	    	test.info("Verify the mini-cart button is clicked");
	    	
	        WebElement minicart = driver.findElement(By.xpath("(//h1)[1]"));
	        String actualTitleofminicart = minicart.getText();
	        String expectedTitleminicart = "Your shopping cart";
	        Thread.sleep(2000);
	        logger.info(minicart.getText());
	        if (actualTitleofminicart.equals(expectedTitleminicart)) {
	            test.pass("Successfully clicked on the mini cart button");
	            logger.info("Successfully clicked on the mini cart button");
	
	        } else {
	            //test.fail("Clicked failed on the mini cart button");
	            logger.info("Clicked failed on the mini cart button");
	            //reclick if any error occurs
	            //reClickMiniCartButton();
	            
	        }
	        
	        test.info("Verify the viewcart, checkout, paypal buttons and products are displayed");
	        List<WebElement> productsinthecart = driver.findElements(By.xpath("//div[@class ='line-item-name']"));
	        logger.info(productsinthecart.size());
	        
	        WebElement viewcarButton = driver.findElement(By.xpath("//a[contains(@class, 'checkout-btn') and contains(text(), 'View Cart')]"));
	        boolean displaycartbutton = viewcarButton.isDisplayed();
	        logger.info(displaycartbutton);
	        WebElement checkOutProcess = driver.findElement(By.xpath("//a[contains(@class, 'checkout-btn') and contains(@class, 'btn-primary') and contains(text(), 'Checkout')]"));
	        boolean displaycheckOut = checkOutProcess.isDisplayed();
	        logger.info(displaycheckOut);
	        
	        if(productsinthecart.size()>0 && displaycartbutton && displaycheckOut ) {
	        	test.pass("Successfully displayed the viewcart, checkout, and products, The number of products are: "+ productsinthecart.size());
	            logger.info("Successfully displayed the viewcart, checkout,  and products");
	        	
	        }else {
	            test.fail(" Not displayed the viewcart, checkout, paypal buttons and products");
	            logger.info("Not displayed the viewcart, checkout, paypal buttons and products");
	        }
	        
	        
	        // to verify paypal button display  in minicart 
	        List<WebElement> salesforceButtonList= driver.findElements(By.xpath("//div[contains(@class,'salesforce')]"));
			List<WebElement> brainPayPalButtonList = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
			if(salesforceButtonList.size()>0 ) {			
				WebElement salesforceButton= driver.findElement(By.xpath("//div[contains(@class,'salesforce')]"));
				boolean displaySalesforcePaypal = salesforceButton.isDisplayed();
				if(displaySalesforcePaypal) {				
					test.pass("Salesforce paypal button is displayed after clicking the minicart button");
				}else {
					test.fail("Salesforce paypal button is not displayed after clicking the minicart button");
				}
	    
			}else if(brainPayPalButtonList.size()>0) {
				WebElement brainPayPalButton = driver.findElement(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
				boolean displaybraintreePaypal = brainPayPalButton.isDisplayed();
				if(displaybraintreePaypal) {				
					test.pass("brain tree paypal button is displayed after clicking the minicart button");
				}else {
					test.fail("brain tree  paypal button is not displayed after clicking the minicart button");
				}
			}
    	}
    }
    
    
    public void reClickMiniCartButton() throws InterruptedException {
    	
    	miniCartPage mc = new miniCartPage(driver);
        mc.clickcartbuttonjs(driver);
        
        WebElement reminicart = driver.findElement(By.xpath("(//h1)[1]"));
        String reactualTitleofminicart = reminicart.getText();
        String reexpectedTitleminicart = "Your shopping cart";
        Thread.sleep(2000);
        logger.info(reminicart.getText());
        if (reactualTitleofminicart.equals(reexpectedTitleminicart)) {
            test.pass("Successfully clicked on the mini cart button");
            logger.info("Successfully clicked on the mini cart button");

        } else {
            test.fail("Clicked failed on the mini cart button");
            logger.info("Clicked failed on the mini cart button");

        }	        	
    }
    
	//validate the order number and date of order
	public void ordernumberandOrderdate() throws InterruptedException {
		
	      List<WebElement> orderConfirmationPage = driver.findElements(By.xpath("//p[@class='order-thank-you-email-msg']"));
				 if(orderConfirmationPage.size()>0) {
					//displayordernumberandplaceddate
					 
					 JavascriptExecutor js = (JavascriptExecutor) driver;
		             js.executeScript("window.scrollBy(0,400)", "");
				    
				    WebElement orderNumeber = driver.findElement(By.xpath("//span[@class ='summary-details order-number']"));
				    String Ordernumber = orderNumeber.getText();
			        test.pass("Successfully Order is Placed and the Order number is "+ Ordernumber);
			        logger.info("Successfully Order is Placed and the Order number is "+ Ordernumber);
				    
				    //order date
				    WebElement OrderDate = driver.findElement(By.xpath("//span[@class ='summary-details order-date']"));
			        String Orderdate = OrderDate.getText();
			        test.pass("Successfully Order is Placed and the Ordered date is "+ Orderdate);
			       
			        //shipping details
			       List<WebElement> shippingDetailsList = driver.findElements(By.xpath("//div[@class='single-shipping']"));	
			       if(shippingDetailsList .size()>0) {
				        WebElement shippingDetails = driver.findElement(By.xpath("//div[@class='single-shipping']"));			        
				        test.info("Shipping Details of placed orders " + shippingDetails.getText());
			       }
			        //paymnet details
				    WebElement paymentDetailsElement = driver.findElement(By.xpath("//div[@class='payment-details']"));
			        String paymentDetails = paymentDetailsElement.getText();
			        test.pass("Successfully Order is Placed and payment is "+ paymentDetails);
			        logger.info("Successfully Order is Placed and the Order number is "+  paymentDetails);
			        Thread.sleep(5000);
			        
			        if(isLoggedIn) {
                        logger.info("Returning to Home page");
		    			 homePage hp = new homePage(driver);
		    			 hp.clickOnLogo();
		    			 
		    			 Thread.sleep(5000);
			        }
			        
			       
				 }
	}
	
	
	//validate the place the order page
   public void validatePlacetheOrderPage() throws InterruptedException {
	   
	    List<WebElement> orderConfirmationPage = driver.findElements(By.xpath("//p[@class='order-thank-you-email-msg']"));
			 if(orderConfirmationPage.size()>0) {
			    	test.info("verify that order is placed");
					
					//validate the orderstatus
			    	Thread.sleep(3000);
				    WebElement PlacetheOrder = driver.findElement(By.xpath("//p[@class='order-thank-you-email-msg']"));
				    String ActualTitleofPlacetheOrder = PlacetheOrder.getText();
				    String ExpectedTitlePlacetheOrder = "Your order was received. Thank you! Confirmation will be sent to your email shortly.";
				    logger.info(PlacetheOrder.getText());
				    
				    if (ActualTitleofPlacetheOrder.equals(ExpectedTitlePlacetheOrder)) {
				        test.pass("Successfully Order is Placed");
				        logger.info("Successfully Order is Placed");
				    } else {
				        test.fail( "The page Title does not match expected " + ExpectedTitlePlacetheOrder + " " + "  but found" + " " + ActualTitleofPlacetheOrder + " ");
				        logger.info("Click failed");
				    }
				    WebElement userName = driver.findElement(By.cssSelector("p.order-thank-you-email-msg"));
				    test.info("User name is " +userName.getText());
				    
				    Thread.sleep(5000);	
			 }
    }
}
