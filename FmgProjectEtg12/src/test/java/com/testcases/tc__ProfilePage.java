package com.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PageObjects.loginPage;
import com.PageObjects.profilePage;
import com.Scenarios.myAccountpage;

public class tc__ProfilePage extends baseClass {
    // Creating a SoftAssert instance for performing soft assertions
    SoftAssert softAssert = new SoftAssert();

    // Test method, dependent on the loginTest method and always runs
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" }, alwaysRun = true)
    public void profilePage() throws InterruptedException {
        // Validate login
        if (isLoggedIn) {

            // Create an instance of the "loginPage" class
            loginPage lp = new loginPage(driver);

            // Hover on "Create and Login Account" option
            lp.hoverOnCreateloginAcc(driver);
            logger.info("Hover on create and login account");

            // Create an instance of the "profilePage" class
            profilePage pp = new profilePage(driver);

            // Click on the "Account" link
            pp.clickAccount(driver);
            Thread.sleep(3000);

            // Create an instance of the "myAccountpage" class
            myAccountpage myAC = new myAccountpage();

            // Update personal information on the My Account page
            myAC.updatePersonalInfo();
            Thread.sleep(5000);

            // Change the password on the My Account page
            myAC.changePassword();
            Thread.sleep(5000);

            // Add a new address on the My Account page
            myAC.addNewAddress();
            Thread.sleep(5000);

            // Add credit card details on the My Account page
            myAC.addCreditCardDetails();

            // Additional actions can be added here as needed
        }

    }
}
