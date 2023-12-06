// Define the package and imports for the Java class
package com.PaymentProccess;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

// Import relevant page objects and validations
import com.PageObjects.TierPrice;
import com.PageObjects.checkOutPage;
import com.PageObjects.miniCartPage;
import com.PageObjects.viewCartPage;
import com.commonfunctionality.FullAddressDetails;
import com.commonfunctionality.GuestCheckout;
import com.commonfunctionality.editInAllCheckOutProcess;
import com.testcases.baseClass;

// Define the class MinicartViewCartProcess, which extends baseClass
public class MinicartViewCartProcess extends baseClass {

    // Define the checkoutprocess method which may throw InterruptedException
    public void checkoutprocess() throws InterruptedException {
        // Introduce a sleep to wait for 3 seconds
        Thread.sleep(3000);

        // Initialize the JavascriptExecutor for scrolling
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll up using JavaScript
        // Negative 'y' value scrolls up
        js.executeScript("window.scrollTo(0, 0);");

        // Check if the minicart is displayed
        List<WebElement> minicartdisplayedcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));

        // If minicart is displayed
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

                mc.clickviewCartButton(driver);

                // Initialize the view cart page
                viewCartPage vcp = new viewCartPage(driver);
                
                // If executing a regression test case
                if (RegressionTestCase) {
                   
                    // Click on a product link in the view cart page
                    vcp.clickProductLink();
                    logger.info("Successfully navigate to the product detail page");

                    // Introduce a delay for 2 seconds
                    Thread.sleep(2000);

                    // Click on the cart button in the minicart
                    mc.hoverOnCartButton(driver);
                    Thread.sleep(1000);

                    mc.clickviewCartButton(driver);
                }

               
                //click on save later           
                vcp.saveForLater();
                
                Thread.sleep(4000);
                
                //cick on the mini cart in the save later
                vcp.addtocartFromSaveLater();
                

                // Find remove buttons in the cart
                List<WebElement> removeBtns = driver.findElements(By.xpath("//div[contains(@class,'cart-delete')]"));

                // If more than 2 products in minicart, remove one
                if (removeBtns.size() > 2) {
                    vcp.removeBtn();
                }

                // Increase the quantity of the product
                vcp.quantityInsertionInCartPage();

                // Calculate product prices in the cart
                vcp.productsCalInCart();

                // Apply a promo code in the cart
                vcp.applyCouponInCartPage();

                // Calculate estimated shipping charges
                vcp.estimatedshippingCalculations();

                // Calculate total product cost
                vcp.totalProductsCost();

                // Click the "Checkout" button in the view cart page
                Thread.sleep(5000);
                vcp.clickCheckout(driver);
                Thread.sleep(1000);

                // Initialize GuestCheckout and click continue as a guest
                GuestCheckout gc = new GuestCheckout();
                gc.clickContinueAsGuest();

                // Click edit button randomly in the checkout process
                editInAllCheckOutProcess.clickEditBtnRandomly();

                // Check email edit
                checkOutPage cp = new checkOutPage(driver);

                // Validate negative shipping address
                // negativeValidation.shippingDetails();

                // Handle the shipping address
                FullAddressDetails address = new FullAddressDetails();
                address.address();

                // Initialize checkOutPage and click continue to billing
                cp.clickcontinueToBillingButton(driver);

            } else {
                logger.info("The cart value is empty");
                // test.fail("The cart value is empty");
            }
        }
    }
}
