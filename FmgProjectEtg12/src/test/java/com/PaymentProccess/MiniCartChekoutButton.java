package com.PaymentProccess;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.PageObjects.checkOutPage;
import com.PageObjects.miniCartPage;
import com.commonfunctionality.FullAddressDetails;
import com.commonfunctionality.GuestCheckout;
import com.commonfunctionality.editInAllCheckOutProcess;
import com.testcases.baseClass;



public class MiniCartChekoutButton extends baseClass {

    public void checkoutprocess() throws InterruptedException {
    	
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll up using JavaScript
        // Negative 'y' value scrolls up
        js.executeScript("window.scrollTo(0, 0);");
    	
        // Check if the minicart is displayed
        List<WebElement> minicartdisplayedcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
        if (minicartdisplayedcount.size() > 0) {

            // Get the number of products in the cart
            WebElement productCountInCart = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
            String countOfMinicart = productCountInCart.getText();
            int minicartProductCountValue = Integer.parseInt(countOfMinicart);

            // If products are in the minicart, proceed
            if (minicartProductCountValue > 0) {

            	// Initialize miniCartPage
                miniCartPage mc = new miniCartPage(driver);
                Thread.sleep(5000);

                // Click on the cart button in the minicart
                mc.hoverOnCartButton(driver);
		        Thread.sleep(1000);
                logger.info(guestuser);
                //click review order
                mc.clickCheckout();
    			logger.info("clicked the chekout button in the minicart");

    			// Initialize GuestCheckout and click continue as a guest
                GuestCheckout gc = new GuestCheckout();
                gc.clickContinueAsGuest();
                
                
                // Click edit button randomly in the checkout process
                editInAllCheckOutProcess.clickEditBtnRandomly();
                
                Thread.sleep(3000);
                
                //check email edite
                checkOutPage cp = new checkOutPage(driver);

                
                // Validate negative shipping address
                //negativeValidation.shippingDetails();

                // Handle the shipping address
                FullAddressDetails address = new FullAddressDetails();
                address.address();
                

                // Initialize checkOutPage and click continue to billing
                
                cp.clickcontinueToBillingButton(driver);
                
                CheckoutProcessClick = true;
                

            } else {
                logger.info("The cart value is empty");
                test.fail("The cart value is empty");
            }
        }
    	
    }
}