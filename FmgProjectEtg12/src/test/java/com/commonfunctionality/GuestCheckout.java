package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.guestUserLoginPage;
import com.Validations.negativeValidation;
import com.testcases.baseClass;

public class GuestCheckout extends baseClass {
    
    public void clickContinueAsGuest() throws InterruptedException {
        
        // Find all elements with the text 'Continue as guest'
        List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Continue as guest')]"));
        logger.info(continueasAGuest.size());

        // If at least one 'Continue as guest' button is found, perform the following actions
        if (continueasAGuest.size() > 0) {
            test.info("Validate Guest checkout");
            
            // Perform negative validation for guest email
            negativeValidation.guestEmail();
            
            // Create an instance of the guestUserLoginPage class
            guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
            
            // Log a message
            logger.info("Guest checkout");
            
            // Generate a random email address for testing

            guestLoginPage.enterTheEmail();
            Thread.sleep(3000);

            test.pass("Successfully mail is entered");
            
            // Log a message
            logger.info("Guest mail again");
            
            // Click on the 'Continue as guest' button
            guestLoginPage.clickOnContinueAsGuest();
            
            // Log a message
            logger.info("Guest continue as guest");
            
            test.pass("Successfully Clicked on the Continue as Guest Btn");
            
            // Add a delay (sleep) of 5 seconds
            Thread.sleep(5000L);
        }
    }
}
