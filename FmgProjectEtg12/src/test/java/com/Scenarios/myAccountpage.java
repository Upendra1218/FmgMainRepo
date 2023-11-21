package com.Scenarios;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.PageObjects.loginPage;
import com.PageObjects.profilePage;
import com.github.javafaker.Faker;
import com.testcases.baseClass;


public class myAccountpage extends baseClass {

    // Initialize the profile page
    profilePage pp = new profilePage(driver);

    // Method to update personal information
    public void updatePersonalInfo() throws InterruptedException {
        Thread.sleep(5000);

        // Click on "Edit Personal Info"
        pp.clickEditPage();
        logger.info("Clicked on the editprofile");
        Thread.sleep(10000);
        
        test.info("Verify that user infomation edits");
        // Set first name, last name, email, and password
        pp.setFisrtName(epfname);
        logger.info("Entered the firstName");
        pp.setLastname(eplname);
        logger.info("Entered the lastName");
        pp.scrolldown(driver);
        logger.info("Clicked on the Scrolldown");
        Thread.sleep(5000);
        pp.setconfirmEmail(epconfirmEmail);
        logger.info("Entered the Email");
        pp.setpassword(eppassword);
        logger.info("Entered the password");
        
//        // Validate the update operation
//        validateSucessfullyEdit();
        
        // Click the "Save" button on the edit page
        pp.clickSaveButtoninEditpage(driver);
        logger.info("Clicked on the save button in the edit page");
    }

    // Method to change the password
    public void changePassword() throws InterruptedException {
        // Click on "Change Password"
        pp.clickChangePassword();
        logger.info("Clicked on the changepassword");
        
        test.info("Verify that entering the change password details");
        // Set current password, new password, and confirm new password
        pp.setcurrentPassword(epcurrentPassword);
        logger.info("Entered the current Password");
        pp.setnewPassword(epnewPassword);
        logger.info("Entered the new password");
        pp.setnewPasswordConfirm(epnewPasswordConfirm);
        logger.info("Entered the new password confirm");
        
        // Validate the password change operation
        //validateSucessfullyChangePassword();
        
        // Click the "Save" button on the change password page
        pp.clicksavebuttonPasswordChange(driver);
        logger.info("Clicked on the save button on the change password page");
    }
    

    // Method to add a new address
    public void addNewAddress() throws InterruptedException {
        // Click on "Add New Address"
    	// Create a Faker instance
        Faker faker = new Faker();
        pp.clickAddNewAddress();
        logger.info("Clicked on the AddnewAddress");
        Thread.sleep(5000);
        
        // Set address details
        pp.setAddressTitle(faker.job().title());
        pp.setFirstNameofAddress("TMX");
        pp.setLastNameofAddress("MORE");

        // Generate a random address number
        WebElement Address1 = driver.findElement(By.xpath("//form[@id='dwfrm_address']//input[@id='address1']"));
        Random random = new Random();
        int randomNumber = random.nextInt(900) + 100;
        address = String.valueOf(randomNumber);
        Address1.sendKeys(address);
        
        WebElement Address11 = driver.switchTo().activeElement();
        //Actions actions = new Actions(driver);
        Thread.sleep(1000);
        Address11.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        Address11.sendKeys(Keys.ARROW_DOWN);
        Address11.sendKeys(Keys.ENTER);
        
        // Enter phone number
        pp.phonenumber();
        logger.info("Entered phone number");
        Thread.sleep(1000);

        
        // Validate the add new address operation
        //validateSucessfullyaddtheNewAddress();
        
        // Click the "Save" button
        pp.saveButton(driver);
        Thread.sleep(5000);
        
        // Click "Return to My Account"
        pp.clickReturntomyAccount(driver);
        logger.info("Clicked on the Returntomyaccount");
        Thread.sleep(5000);
    }

    // Method to view order details
    public void orderDetails() throws InterruptedException {
        // Click on "View Order History"
        pp.clickViewOrderHistory(driver);
        logger.info("Clicked on the vieworderhistory");
        Thread.sleep(5000);
        
        // Scroll down the page
        pp.scrolldown(driver);
        logger.info("Clicked on the Scrolldown");
        Thread.sleep(10000);
        
        // Validate the order history page
        validateSucessfullyViewedThewishList();
        
        try {
            pp.clickReturntomyAccountinViewOrder(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Clicked on the Returntomyaccount");
        Thread.sleep(5000);
    }

    // Method to add credit card details
    public void addCreditCardDetails() throws InterruptedException {
        // Click on "Add Credit Card"
        pp.clickaddCreditCard();
        
        test.info("Verify that credit card details");

        // Set cardholder name, card number, CVV, and expiration date
        pp.setcardholdername(driver);
        logger.info("entered card name");
        pp.setcardnumber(driver);
        logger.info("entered card number");
        pp.setcardcvv(driver);
        logger.info("entered CVV");
        pp.setcardexp(driver);
        logger.info("entered expiration date");
        
        // Click the "Save" button for credit card details
        pp.clicksavebuttoncc(driver);
        logger.info("Saved successfully");
        
        Thread.sleep(5000);
    }

    // Method to validate successful viewing of the wish list
    private void validateSucessfullyViewedThewishList() {
        test.info("Verify that viewed the order history");
        
        WebElement orderHistoryHeading = driver.findElement(By.xpath("//h2[text()='Order History']"));
        boolean isDisplayed = orderHistoryHeading.isDisplayed();

        if (isDisplayed) {
            test.pass("Successfully viewed the order history");
            logger.info("Successfully viewed the order history");
        } else {
            test.fail("Failed to view the order history");
            logger.info("Failed to view the order history");
        }
    }
    
    // Method to validate successful addition of a new address
    private void validateSucessfullyaddtheNewAddress() {
        test.info("Verify that added a new address");
        
        WebElement newAddressHeading = driver.findElement(By.xpath("//h2[text()='Add New Address']"));
        boolean isDisplayed = newAddressHeading.isDisplayed();

        if (isDisplayed) {
            test.pass("Successfully added a new address");
            logger.info("Successfully added a new address");
        } else {
            test.fail("Failed to add a new address");
            logger.info("Failed to add a new address");
        }
    }
    
    // Method to validate successful edit operation
    private void validateSucessfullyEdit() {
        test.info("Verify that edited the user information");
        
        WebElement editProfileHeading = driver.findElement(By.xpath("//h2[text='Edit Profile']"));
        boolean isDisplayed = editProfileHeading.isDisplayed();

        if (isDisplayed) {
            test.pass("Successfully edited the profile information");
            logger.info("Successfully edited the profile information");
        } else {
            test.fail("Failed to edit the profile information");
            logger.info("Failed to edit the profile information");
        }
    }
    
    // Method to validate successful change password operation
    private void validateSucessfullyChangePassword() {
        test.info("Verify that changed the password");
        
        WebElement changePasswordHeading = driver.findElement(By.xpath("//h2[text()='Change Password']"));
        boolean isDisplayed = changePasswordHeading.isDisplayed();

        if (isDisplayed) {
            test.pass("Successfully changed the password");
            logger.info("Successfully changed the password");
        } else {
            test.fail("Failed to change the password");
            logger.info("Failed to change the password");
        }
    }
}