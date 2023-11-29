package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.PageObjects.contactUsCustomerSupport;

public class tc__CustomerSupport extends baseClass{
	@Test(dependsOnMethods = {"com.Login.tc__Login.loginTest"})
	public void customerSuppor() throws InterruptedException {
		test.info("Contact us button on homepage");
		WebElement contactUsButton= driver.findElement(By.xpath("//div[@class='embeddedServiceHelpButton']//button"));
		boolean isDisplayedContactUsButton= contactUsButton.isDisplayed();
		if(isDisplayedContactUsButton) {
			logger.info("Contact us icon is displayed on homepage");
		    test.pass("Contact us icon is displayed on homepage");      
		}else {
			logger.info("Contact us icon is not displayed on homepage");
		    test.fail("Contact us icon is not displayed on homepage");   
		}
		Thread.sleep(5000);
		contactUsCustomerSupport csp = new contactUsCustomerSupport(driver);
		csp.clickcustomerSupportButton(driver);
		logger.info("Clicked on the customer support button");
		logger.info("Clicked on the customer support button");
		
		
		
		Thread.sleep(15000);
		
		csp.sendNameoftheCustomer(driver);
		logger.info("sucessfully Name send to the input of the name field");
		test.pass("sucessfully Name send to the input of the name field");
		Thread.sleep(1000);
		
        
        csp.sendEmailofTheCustomer(driver);
        logger.info("sucessfully Email send to the input of the name field");
        test.pass("sucessfully Email send to the input of the name field");
        Thread.sleep(1000);
        
        csp.sendPhoneofTheCustomer(driver);
        logger.info("Successfully phone is send to the phone filed");
        test.pass("Successfully phone is send to the phone filed");
        
        
        csp.selecttheIssuesoftheCustomer(driver);
        logger.info("sucessfully select the reason for the feedback");
        test.pass("sucessfully select the reason for the feedback");
        Thread.sleep(1000);
        
        csp.sendDescritofTheCustomer(driver);
        logger.info("Succesfully description is send to the description");
        test.pass("Succesfully description is send to the description");
        
        csp.clicksubmitButton(driver);
        logger.info("sucessfully clicked on the submit button");
        test.pass("sucessfully clicked on the submit button");
        Thread.sleep(5000);
        
        
        test.info("Verify that the feedback is submitted.");
        WebElement donebutton = driver.findElement(By.xpath("//button[contains(@class, 'dialogButton') and contains(@class, 'dialog-button-0') and contains(@class, 'uiButton--default') and contains(@class, 'uiButton') and contains(@class, 'embeddedServiceSidebarButton')]"));

		  boolean isDsiplayed = donebutton.isDisplayed();

		  if (isDsiplayed) {
		      System.out.println("Button is displayed");
		        csp.clickdoneButton(driver);
		        logger.info("sucessfully clicked on the done button");
			    test.pass("Feedback submitted successfully");
		      
		  } else {
		      System.out.println("Button is disabled");
		      test.fail("Feedback not submitted successfully");
		  }
		  

	}
	
}
