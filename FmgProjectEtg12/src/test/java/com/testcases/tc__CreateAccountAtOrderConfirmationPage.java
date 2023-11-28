package com.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GuestUserWith_CreditCard.tc__GuestUserRandomProductFromPDP_InCc;

public class tc__CreateAccountAtOrderConfirmationPage extends baseClass {

	@Test
	public void createAccount() throws InterruptedException {
		
		
		tc__GuestUserRandomProductFromPDP_InCc testCase = new tc__GuestUserRandomProductFromPDP_InCc();
		testCase.ProductFromPDP();

		test.info("Account creation from order confirmation page");

		List<WebElement> mainDivList= driver.findElements(By.xpath("//div[contains(@class,'order-confirm-create-account')]"));
		if(mainDivList.size()>0) {
			WebElement mainDiv= driver.findElement(By.xpath("//div[contains(@class,'order-confirm-create-account')]"));
			if(mainDiv.isDisplayed()) {
				
				negativeValidation();
				
				WebElement password= driver.findElement(By.id("password"));
				password.sendKeys("Testing@123");
				
				WebElement confirmPassword= driver.findElement(By.id("newPasswordConfirm"));
				confirmPassword.sendKeys("Testing@123");
				
				WebElement createAccButton= driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("arguments[0].click();",createAccButton);
		    	
		    	Thread.sleep(3000);
				WebElement loginTitle = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]"));
				String expectedTitle = "Dashboard";
				String actualTitle = loginTitle.getText();

		        
		        if (actualTitle.equals(expectedTitle)) {
		        	test.pass("Account created sucessfully");         
		            logger.info("Account created sucessfully");
		            isLoggedIn = true;
		            
		            //registered user name 
		            WebElement userName = driver.findElement(By.className("registered-user-message"));
		            test.info("Name of User name is " + userName.getText());
		            logger.info("Name of User name is " + userName.getText());
		           
		            //registered email id 
		            WebElement regMail = driver.findElement(By.xpath("(//dd)[2]"));
		            test.info("Email is " + regMail.getText());
		            logger.info("Email  is " + regMail.getText());
		            
		        } else {
		        	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
		            logger.info("Click failed and account not created");
		            
		        }
			}
		}
	}
	
	public void negativeValidation() {
		WebElement createAccButton= driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));
		createAccButton.click();
		
		WebElement errorMessage= driver.findElement(By.xpath("//div[contains(text(),'This field is required.')]"));
		boolean errorMsgDisplayed= errorMessage.isDisplayed();
		if(errorMsgDisplayed) {
			 test.pass("Error message is displayed when no email is entered or for password mismatch");
			 logger.info("Error message is displayed when no email is entered or for password mismatch");
		}else {
			 test.fail("Error message is displayed when no email is entered or for password mismatch");
			 logger.info("Error message is displayed when no email is entered or for password mismatch");
		}
	}
}
