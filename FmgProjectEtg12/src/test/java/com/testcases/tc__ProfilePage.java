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
    @Test(dependsOnMethods = { "com.Login.tc__Login.loginTest" })
    public void profilePage() throws InterruptedException {
        // Validate login
        if (isLoggedIn) {

            // Create an instance of the "loginPage" class
            loginPage lp = new loginPage(driver);

            // Hover on "Create and Login Account" option
            lp.hoverOnCreateloginAcc(driver);
            // Logging an informational message about hovering on the create and login account option.
            logger.info("Hover on create and login account");

            // Create an instance of the "profilePage" class
            profilePage pp = new profilePage(driver);

            // Click on the "Account" link
            pp.clickAccount(driver);
            // Performing a click action on the "Account" link.
            Thread.sleep(3000);

            if(RegressionTestCase) {
                // Create an instance of the "myAccountpage" class
                myAccountpage myAC = new myAccountpage();

                // Update personal information on the My Account page
                myAC.updatePersonalInfo();
                // Performing an update of personal information on the My Account page.
                Thread.sleep(5000);

                // Change the password on the My Account page
                myAC.changePassword();
                // Performing a password change on the My Account page.
                Thread.sleep(5000);

                // Add a new address on the My Account page
                myAC.addNewAddress();
                // Performing an address addition on the My Account page.
                Thread.sleep(5000);

                // Add credit card details on the My Account page
                myAC.addCreditCardDetails();
                // Performing addition of credit card details on the My Account page.

                // Additional actions can be added here as needed

            } else {
                // Hover on "Create and Login Account" option
                lp.hoverOnCreateloginAcc(driver);
                // Logging an informational message about hovering on the create and login account option.
                logger.info("Hover on create and login account");
                
                pp.clickMyOrders(driver);
                // Performing a click action on the "My Orders" link.
                Thread.sleep(7000);

                // Hover on "Create and Login Account" option
                lp.hoverOnCreateloginAcc(driver);
                // Logging an informational message about hovering on the create and login account option.
                logger.info("Hover on create and login account");
                
                pp.clickMyFav(driver);
                // Performing a click action on the "My Favorites" link.
                Thread.sleep(5000);
            }
        }
    }
}
