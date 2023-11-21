package com.Logout;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PageObjects.homePage;
import com.PageObjects.logOut;
import com.PageObjects.loginPage;
import com.PageObjects.profilePage;
import com.testcases.baseClass;

 

public class tc__LogOut extends baseClass {

    SoftAssert softAssert = new SoftAssert();

    @Test(dependsOnMethods = {"com.Login.tc__Login.loginTest"}, alwaysRun = true)
    public void Logout() throws InterruptedException {
        if (isLoggedIn) {

	        	
	      // Create an instance of the "loginPage" class
	            loginPage lp = new loginPage(driver);

	            // Hover on "Create and Login Account" option
	            lp.hoverOnCreateloginAcc(driver);
	            logger.info("Hover on create and login account");
	            
            logOut lo = new logOut(driver);
            logger.info("Hovered the myaccout");
            Thread.sleep(10000);
            lo.clicklogout(driver);
            logger.info("clicked the logout button and successfully logged out");
            String expectedTitlelogout = "Sites-fireMountainGems-Site";
            String actualTitlelogout = driver.getTitle();
            logger.info(actualTitlelogout);
            if (actualTitlelogout.equals(expectedTitlelogout)) {
                test.pass("Successfully clicked on the Logout button");
                logger.info("User logged out successfully");
            } else {
                test.fail("The page Title does not match expected " + expectedTitlelogout + " but found " + actualTitlelogout);
                logger.info("Click failed");
            }
            Thread.sleep(5000);

 

            // Assert all the soft assertions
            softAssert.assertAll();
        } else {
            Assert.fail("User not logged in");
        }
    }
}

 