// Import necessary packages and classes
package com.PaymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.CreditCardPaymentMethods.allPaymentMethods;
import com.Logout.tc__LogOut;
import com.PageObjects.TotalCalculation;
import com.PageObjects.homePage;
import com.PageObjects.reviewOrderPage;
import com.PageObjects.taxCalculation;
import com.Validations.Checkout_Validation;
import com.Validations.negativeValidation;
import com.Validations.preValidationCheck;
import com.commonfunctionality.editInAllCheckOutProcess;
import com.testcases.baseClass;

// Define a test class named "tc__CreditCardPaymentProcess"
public class CreditCardPaymentProcess extends baseClass{
	
	// Define a method named "paymentByCreditCard"
	public void paymentByCreditCard() throws InterruptedException {
		// Find all elements matching the XPath for a link with class 'nav-link creditcard-tab active' 
		List<WebElement> billingPage = driver.findElements(By.xpath("//a[@class='nav-link creditcard-tab active']"));

		// Check if there is at least one element found with the specified XPath
		if(billingPage.size() > 0) {
		    // If the billing page is active, perform the following actions:

		    // Validate the payment page by clicking the payment button
		    preValidationCheck.validatePaymentButtonClk();
		    
		    // Perform negative validations on credit card details
		    negativeValidation.creditCardDetails();
		    
		    // Click the 'Edit' button randomly in the checkout process
		    editInAllCheckOutProcess.clickEditBtnRandomly();
		    
		    // Detect payment methods again after editing
		    // Specifically, check if Brain Tree payment method is available
		    List<WebElement> brainTree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
		    
		    // Create an instance of the "allPaymentMethods" class
		    allPaymentMethods bpm = new allPaymentMethods();
		    
		    // Scroll the window down by 900 pixels using JavaScriptExecutor
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,900)", "");
		    
		    // Determine the payment method and proceed accordingly
		    if(brainTree.size() > 0) {
		        // If Brain Tree payment method is available, call the BrainTreeMethod() from the allPaymentMethods class
		        bpm.BrainTreeMethod();
		    }
				    
		   // Create an instance of the reviewOrderPage class with the WebDriver
		    reviewOrderPage rop = new reviewOrderPage(driver);

		    // Pause execution for 4 seconds (used for demonstration purposes; consider using WebDriverWait instead)
		    Thread.sleep(4000);

		    // Click on the "Review Order" button using the reviewOrderPage instance
		    rop.clickonReviewOrder(driver);

		    // Pause execution for 4 seconds (used for demonstration purposes; consider using WebDriverWait instead)
		    Thread.sleep(4000);

		    // Click the 'Edit' button randomly in the checkout process
		    editInAllCheckOutProcess.clickEditBtnRandomly();

		    // Pause execution for 5 seconds (used for demonstration purposes; consider using WebDriverWait instead)
		    Thread.sleep(5000);

		    // Check if the CheckoutProcessClick flag is true
		    if(CheckoutProcessClick) {
		        // Log a message if the "Check" button is clicked, indicating that the total cost is not calculated
		        logger.info("This is check btn clicked, we are not calculating the total cost");
		    } else {
		        // If the "Check" button is not clicked, perform total calculation
		        TotalCalculation totalCal = new TotalCalculation();
		        totalCal.totalCalculation(driver);
		    }

		    // Click on the "Place Order" button using JavaScriptExecutor
		    rop.clickonplaceorderwithJsExuter(driver);

		    // Pause execution for 5 seconds (used for demonstration purposes; consider using WebDriverWait instead)
		    Thread.sleep(5000);

		    // Log a message indicating successful click on the "Place Order" button by normal click
		    logger.info("Successfully clicked on the place order button by normal click");

		    // Pause execution for 2 seconds (used for demonstration purposes)
		    Thread.sleep(2000);

		    // Log the title of the current page
		    logger.info(driver.getTitle());

		    // Checkout validation based on the title of the page
		    if(driver.getTitle().endsWith("Fire Mountain Gems and Beads")) {
		        // If the title ends with "Fire Mountain Gems and Beads," perform the following validations:

		        // Create an instance of the Checkout_Validation class
		        Checkout_Validation checkout = new Checkout_Validation();

		        // Validate the final "Place the Order" page
		        checkout.validatePlacetheOrderPage();

		        // Get order number and order date
		        checkout.ordernumberandOrderdate();

		        // Click on the "Continue Shopping" button using the reviewOrderPage instance
		        rop.clickoncontinueShoppingBtn(driver);

		        // Pause execution for 4 seconds (used for demonstration purposes; consider using WebDriverWait instead)
		        Thread.sleep(4000);

		        // Logout and perform additional actions if the user is logged in
		        if(isLoggedIn) {
		            tc__LogOut logout = new tc__LogOut();
		            logout.Logout();
		            Thread.sleep(7000);
		            homePage hp = new homePage(driver);
		            hp.clickconsentTracking();
		        }
		    } else if(driver.findElements(By.xpath("//p[contains(text(),'There was a problem processing your payment. Please verify your payment information and try again.')]")).size() > 0) {
		        // If the page contains an error message related to payment processing, log an info message
		        test.info("Returned back to payment page, as the expected behavior in Brain Tree is that the order will fail for specific amounts.");
		    } else {
		        // If the "Next payment" button is not enabled and clicked, log a failure message
		        test.fail("Next payment button is not enabled and clicked");
		    }
		}
	}
 }