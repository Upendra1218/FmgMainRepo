package com.Logout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @Test(dependsOnMethods = {"com.Login.tc__Login.loginTest"})
    public void Logout() throws InterruptedException {
        if (isLoggedIn) {

	        	
	      // Create an instance of the "loginPage" class
	            loginPage lp = new loginPage(driver);

	            // Hover on "Create and Login Account" option
	            lp.hoverOnCreateloginAcc(driver);
	            logger.info("Hover on create and login account");
	            
            logOut lo = new logOut(driver);
            logger.info("Hovered the myaccout");
            Thread.sleep(1000);
            lo.clicklogout(driver);
            Thread.sleep(4000);
            logger.info("clicked the logout button and successfully logged out");
            
            List<WebElement> userName = driver.findElements(By.xpath("//span[text()='Create / Login']"));
            
            if(userName.size()>0) {
            	// Log a fail message if the page title does not match the expected title
            	test.pass("User logout succesfully");
                logger.info("user logout successfully");
                isLoggedIn = false;
                guestuser=false;
            	
            }else {
            	
            	// Log a pass message if the user is logged in successfully
            	test.pass("User logged in successfully");
                logger.info("User logged in successfully");
                isLoggedIn = true;
                
                
                //registered user name 
                WebElement userName1 = driver.findElement(By.className("registered-user-message"));
                test.pass("Name of User name is " + userName1.getText());
                logger.info("Name of User name is " + userName1.getText());
            }
            
//            String expectedTitlelogout = "Sites-fireMountainGems-Site";
//            String actualTitlelogout = driver.getTitle();
//            logger.info(actualTitlelogout);
//            if (actualTitlelogout.equals(expectedTitlelogout)) {
//                test.pass("Successfully clicked on the Logout button");
//                logger.info("User logged out successfully");
//            } else {
//                test.fail("The page Title does not match expected " + expectedTitlelogout + " but found " + actualTitlelogout);
//                logger.info("Click failed");
//            }
//            Thread.sleep(5000);
//
// 
//
//            // Assert all the soft assertions
//            softAssert.assertAll();
        } else {
            Assert.fail("User not logged in");
        }
    }
}

 