package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.PageObjects.checkOutPage;
import com.PageObjects.guestUserLoginPage;
import com.PageObjects.reviewOrderPage;
import com.testcases.baseClass;

public class editInAllCheckOutProcess extends baseClass {

    // Edit buttons - Randomly selects and clicks an "Edit" button in the checkout process
    public static void clickEditBtnRandomly() throws InterruptedException {
        // Checking edit buttons
        List<WebElement> editBtns = driver.findElements(By.xpath("//button[text()='Edit']"));
        logger.info(editBtns.size());
        int displayedEditBtns = 0;

        // Count the number of displayed "Edit" buttons
        for (WebElement item : editBtns) {
            if (item.isDisplayed()) {
                displayedEditBtns++;
            }
        }
        logger.info(displayedEditBtns);

        // Generate a random number to select a random "Edit" button
        int count = displayedEditBtns;
        Random random = new Random();
        int randomNumber = random.nextInt(count) + 1;
        logger.info(randomNumber);

        // Locate and click the randomly selected "Edit" button
        WebElement editBtn = driver.findElement(By.xpath("(//button[text()='Edit'])[" + randomNumber + "]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", editBtn);
        js.executeScript("arguments[0].click();", editBtn);
        //editBtn.click();

        // Based on the context of the checkout process, perform actions accordingly
        if (displayedEditBtns == 1) {
            logger.info("This is the shipping page");
            test.info("This is the shipping page");

            if (randomNumber == 1) {
                // Edit guest email on the shipping page
                guestUserLoginPage glp = new guestUserLoginPage(driver);
                glp.guestEmailEdit();
                logger.info("Successfully edited the email");
                glp.clickOnContinueAsGuest();
                logger.info("Successfully clicked on the continue guest");
                
                // Get email from checkOutPage
                checkOutPage cp = new checkOutPage(driver);
                cp.getEmailFromCP();
                
            }

        } else if (displayedEditBtns == 3) {
            logger.info("This is the Payment page");
            test.info("This is the Payment page");

            if (randomNumber == 1) {
                // Edit guest email on the Payment page
                guestUserLoginPage glp = new guestUserLoginPage(driver);
                glp.guestEmailEdit();
                logger.info("Successfully edited the email");
                glp.clickOnContinueAsGuest();
                logger.info("Successfully clicked on the continue guest");

                // Continue to Billing
                checkOutPage cp = new checkOutPage(driver);
                cp.getEmailFromCP();
                
                cp.clickcontinueToBillingButton(driver);
                logger.info("Successfully clicked on the continue Billing");

            } else if (randomNumber == 2) {
                // Edit shipping address
                checkOutPage cp = new checkOutPage(driver);
                cp.seteditAddress1();
                cp.clickcontinueToBillingButton(driver);
                
				// Validate the shipping address when edited
				cp.getAddressFromPaymentPage();
                
                logger.info("Successfully clicked on the continue Billing");
                Thread.sleep(3000);

            } else {
                // Select shipping randomly
                checkOutPage cp = new checkOutPage(driver);
                cp.selectShippingRandomly();
                Thread.sleep(3000);
                cp.clickcontinueToBillingButton(driver);
                logger.info("Successfully clicked on the continue Billing");
				cp.getShippingvalidation();
            }
        } else {
            logger.info("This is the Review order page");
            test.info("This is the Review order page");

            if (randomNumber == 1) {
                // Edit guest email on the Review order page
                guestUserLoginPage glp = new guestUserLoginPage(driver);
                glp.guestEmailEdit();
                logger.info("Successfully edited the email");
                glp.clickOnContinueAsGuest();
                logger.info("Successfully clicked on the continue guest");

                // Continue to Billing
                checkOutPage cp = new checkOutPage(driver);
                cp.getEmailFromCP();
                
                cp.clickcontinueToBillingButton(driver);
                logger.info("Successfully clicked on the continue Billing");

                // Click on Review order button
                reviewOrderPage rop = new reviewOrderPage(driver);
                Thread.sleep(4000);
                rop.clickonReviewOrder(driver);
                logger.info("Successfully clicked on the Review order button");

            } else if (randomNumber == 2) {
                // Edit shipping address
                checkOutPage cp = new checkOutPage(driver);
                cp.seteditAddress1();
                cp.clickcontinueToBillingButton(driver);
                logger.info("Successfully clicked on the continue Billing");
                Thread.sleep(3000);
                
				// Validate the shipping address when edited
				cp.getAddressFromPaymentPage();

                // Click on Review order button
                reviewOrderPage rop = new reviewOrderPage(driver);
                Thread.sleep(4000);
                rop.clickonReviewOrder(driver);

            } else if (randomNumber == 3) {
                // Select shipping randomly
                checkOutPage cp = new checkOutPage(driver);
                cp.selectShippingRandomly();
                Thread.sleep(3000);
                cp.clickcontinueToBillingButton(driver);
                logger.info("Successfully clicked on the continue Billing");
                
				cp.getShippingvalidation();

                // Click on Review order button
                reviewOrderPage rop = new reviewOrderPage(driver);
                Thread.sleep(4000);
                rop.clickonReviewOrder(driver);
                logger.info("Successfully clicked on the Review order button");

            } else {
                // Click on Review order button without additional edits
                reviewOrderPage rop = new reviewOrderPage(driver);
                Thread.sleep(4000);
                rop.clickonReviewOrder(driver);
                logger.info("Successfully clicked on the Review order button");
            }
        }
    }
}
