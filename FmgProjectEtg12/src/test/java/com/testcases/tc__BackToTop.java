// Package declaration for the test case
package com.testcases;

// Import statements for required classes and interfaces
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// Importing the baseClass for common setup
import com.Launchingbrowser.launchBrowsering;

// Test class for the Back to Top functionality, extending the baseClass
public class tc__BackToTop extends baseClass {

    // Test method to validate the Back to Top functionality
    @Test
    public void backToTop() throws InterruptedException {
        
        // Creating an instance of the launchBrowsering class
       if(isBrowserLaunched){
        
        // Launching the Chrome browser
        

        // Locating the "Back to Top" element using XPath
        WebElement backToTop = driver.findElement(By.xpath("//span[contains(text(),'Back to top')]"));

        // Creating a JavascriptExecutor instance
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scrolling to the "Back to Top" element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", backToTop);

        // Clicking on the "Back to Top" element using JavascriptExecutor
        js.executeScript("arguments[0].click();", backToTop);

        // Locating the FMG logo element using XPath
        WebElement fmgLogo = driver.findElement(By.xpath("//div[contains(@class,'navbar-brand')]//img[@class='fmg-logo']"));

        // Checking if the FMG logo is displayed after clicking "Back to Top"
        boolean fmgLogoDisplayed = fmgLogo.isDisplayed();

        // Providing test result based on whether the FMG logo is displayed
        if (fmgLogoDisplayed) {
            test.pass("Clicked on the Back to Top button");
            logger.info("Clicked on Back to Top");
        }
    }
    }
}
