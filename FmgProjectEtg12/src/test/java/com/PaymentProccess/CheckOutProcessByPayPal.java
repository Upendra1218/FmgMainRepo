package com.PaymentProccess;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.Logout.tc__LogOut;
import com.PageObjects.TierPrice;
import com.PageObjects.TotalCalculation;
import com.PageObjects.homePage;
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
	    
	// Define the method checkoutprocessFromViewCart, which may throw InterruptedException
	 public void checkoutprocessFromViewCart() throws InterruptedException {

	     // Find the elements with class 'minicart' to check the count
	     List<WebElement> minicartcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));

	     // Mini cart and check out validation
	     miniCartAndCartValidation validation = new miniCartAndCartValidation();

	     // Check if the minicart is displayed
	     if (minicartcount.size() > 0) {

	         // Find the element displaying the minicart count
	         WebElement miniCartDisplay = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));

	         // Check if the minicart display is visible
	         if (miniCartDisplay.isDisplayed()) {

	             // Find the minicart count element again
	             WebElement minicartcount1 = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));

	             // Get the text of the minicart count and convert it to an integer
	             String countOfMinicart = minicartcount1.getText();
	             int minicartCountValue = Integer.parseInt(countOfMinicart);

	             // If there are items in the minicart, proceed
	             if (minicartCountValue > 0) {

	                 // Initialize miniCartPage
	                 miniCartPage mc = new miniCartPage(driver);

	                 // Hover on the cart button in the minicart
	                 mc.hoverOnCartButton(driver);

	                 // Find minicart popup elements
	                 List<WebElement> minicartPopUp = driver.findElements(By.xpath("(//h1)[1]"));

	                 // If minicart popup is present
	                 if (minicartPopUp.size() > 0) {

	                     // Validate the minicart click
	                     validation.validateMiniCartClick();

	                     // Initialize TierPrice for assortment price, discount, and its color
	                     TierPrice tp = new TierPrice();
	                     tp.onlyTier();

	                     // Click on the view cart button
	                     mc.clickviewCartButton(driver);
	                     logger.info("clicked the view cart button in the minicart");

	                     // Validate the view cart click
	                     validation.validateViewCartClick();
	                 }

	                 // Initialize the view cart page
	                 viewCartPage vcp = new viewCartPage(driver);

	                 // Generate a random number
	                 Random random = new Random();
	                 int randomNumber = random.nextInt(2);

	                 // Randomly decide to insert or not insert quantity
	                 if (randomNumber == 0) {
	                     vcp.quantityInsertionInCartPage();
	                 } else {
	                     vcp.noQuantityInsertionInCartPage();
	                 }

	                 // Calculate product prices in the cart
	                 vcp.productsCalInCart();

	                 // Total product cost
	                 vcp.totalProductsCost();

	                 // Find Braintree PayPal button elements
	                 List<WebElement> brainPayPalButton = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));

	                 // If Braintree PayPal button is present
	                 if (brainPayPalButton.size() > 0) {
	                     test.info("Braintree payment integration is activated");
	                     vcp.braintreePayPalButton(driver);
	                 }

	                 // Initialize paymentPage
	                 paymentpPage pp = new paymentpPage(driver);

	                 // PayPal popup
	                 pp.paypalPopup(driver);

	                 // Find elements on the cart page
	                 List<WebElement> cartPage = driver.findElements(By.xpath("//h1[contains(text(),'Your Shopping Cart')]"));

	                 // If cart page elements are present
	                 if (cartPage.size() > 0) {

	                     // Log info about potential navigation issues with PayPal in the cart page
	                     test.info("Sometimes the PayPal in the cart page will not navigate to the review order page; it will navigate for the 2nd time");

	                     // Click Braintree PayPal button again
	                     vcp.braintreePayPalButton(driver);

	                     // PayPal popup again
	                     pp.paypalPopup(driver);
	                 }

	                 // Introduce a delay for 2 seconds
	                 Thread.sleep(2000);

	                 // Calculate total
	                 TotalCalculation totalCal = new TotalCalculation();
	                 totalCal.totalCalculation(driver);

	                 // Place order
	                 reviewOrderPage rop = new reviewOrderPage(driver);
	                 Thread.sleep(4000);
	                 rop.clickonplaceorderwithJsExuter(driver);

	                 // Introduce a delay for 5 seconds
	                 Thread.sleep(5000);

	                 // Checkout validation
	                 Checkout_Validation checkout = new Checkout_Validation();

	                 // Validate the final place the order page
	                 checkout.validatePlacetheOrderPage();

	                 // Order number and Order date
	                 checkout.ordernumberandOrderdate();

	                 // Introduce a delay for 3 seconds
	                 Thread.sleep(3000);
	             }
	         }
	     }
	 }

	        
	// Define the method checkoutprocessFromCheckout, which may throw InterruptedException
	 public void checkoutprocessFromCheckout() throws InterruptedException {

	     // Find elements with the text 'Payment Method'
	     List<WebElement> paymnetPage = driver.findElements(By.xpath("//h2[contains(text(),'Payment Method')]"));

	     // If the 'Payment Method' elements are present
	     if (paymnetPage.size() > 0) {

	         // Find elements related to BrainTree PayPal account
	         List<WebElement> brainPaypalAcc = driver.findElements(By.xpath("//li[@data-method-id='PayPal']"));

	         // Initialize JavascriptExecutor
	         JavascriptExecutor js = (JavascriptExecutor) driver;

	         // If executing a regression test case
	         if (RegressionTestCase) {

	             // Apply coupon
	             taxCalculation taxCal = new taxCalculation();
	             taxCal.applyCoupon();
	         }

	         // If BrainTree PayPal account elements are present
	         if (brainPaypalAcc.size() > 0) {

	             // Log info about BrainTree payment integration
	             test.info("Brain tree payment integration is activated");

	             // Initialize paymentPage
	             paymentpPage pp = new paymentpPage(driver);

	             // Perform Braintree PayPal payment
	             pp.braintreePaypal(driver);

	             // Scroll down by 500 pixels using JavaScript
	             js.executeScript("window.scrollBy(0,500)", "");

	             // If the submit payment button is displayed
	             if (driver.findElement(By.xpath("//button[contains(@class,'submit-payment')]")).isDisplayed()) {

	                 // Log info after the click of PayPal
	                 logger.info("After the click of PayPal");

	                 // Initialize reviewOrderPage
	                 reviewOrderPage rop = new reviewOrderPage(driver);

	                 // Introduce a delay for 4 seconds
	                 Thread.sleep(4000);

	                 // Click on the place order button using JavaScript Executor
	                 rop.clickonplaceorderwithJsExuter(driver);

	             } else {

	                 // Perform actions after the click of BrainTree
	                 pp.brainTreeAfterClick(driver);

	                 // Perform PayPal popup actions
	                 pp.paypalPopup(driver);

	                 // Initialize reviewOrderPage
	                 reviewOrderPage rop = new reviewOrderPage(driver);

	                 // Introduce a delay for 4 seconds
	                 Thread.sleep(4000);

	                 // Perform total calculation
	                 TotalCalculation totalCal = new TotalCalculation();
	                 totalCal.totalCalculation(driver);

	                 // Log info about 'my name'
	                 logger.info("my name");

	                 // Click on the place order button using JavaScript Executor
	                 rop.clickonplaceorderwithJsExuter(driver);
	             }

	             // Introduce a delay for 5 seconds
	             Thread.sleep(5000);

	             // Initialize Checkout_Validation
	             Checkout_Validation checkout = new Checkout_Validation();

	             // Validate the final place the order page
	             checkout.validatePlacetheOrderPage();

	             // Order number and Order date
	             checkout.ordernumberandOrderdate();

	             // Introduce a delay for 5 seconds
	             Thread.sleep(5000);
	             // Create an instance of the reviewOrderPage class with the WebDriver
	 		    reviewOrderPage rop = new reviewOrderPage(driver);
	             
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
	         }
	     }
	 }

	    
	
		
}
