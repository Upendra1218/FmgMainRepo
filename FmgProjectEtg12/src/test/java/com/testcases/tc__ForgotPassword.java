package com.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.loginPage;
import com.github.javafaker.Faker;

public class tc__ForgotPassword extends baseClass{

	@Test
	public void validatingForgotPassword() throws InterruptedException {
		
		
		  
       if(isBrowserLaunched){
        

		test.info("Validating the forgot password");
		
			Faker fake =new Faker();
		//hover on login 
			 loginPage  lp = new loginPage(driver);
			 lp.hoverOnCreateloginAcc(driver);
			 Thread.sleep(1000);
		 
		//click on login
			 lp.clickOnLogin();
	         logger.info("Clicked on Sign In");
	         Thread.sleep(2000L);
			 
			 
		 //clicks  on forgot password by fetching the element
			 WebElement forgotPasswordElement = driver.findElement(By.id("password-reset"));
			 forgotPasswordElement.click();
		 
		 //validating the password reset page
			 WebElement passwordResetPage = driver.findElement(By.xpath("//h2[contains(text(),'Password Reset')]"));
			 String expectedmessage=passwordResetPage.getText();
			 String actualMessage= "Password Reset";
			 if(expectedmessage.equals(actualMessage)) {
				 test.pass("Successfully naviagted to password reset page");
				 logger.info("Successfully naviagted to password reset page");
			 }else {
				 test.fail("Successfully naviagted to password reset page");
				 logger.info("Successfully naviagted to password reset page");
			 }
			
		//neagtive  validation of email
			 negativeEmailValidation();
			 Thread.sleep(1000);
		//entering email into input by fetching the element
			 WebElement email = driver.findElement(By.id("login-form-email")); 
			 String fakeName = fake.name().firstName();
			 String fakeEmail= "akhila.m" +"@etg.digital";
			 email.sendKeys(fakeEmail);
			 
		
		// submit request	 
			 WebElement submitEmail = driver.findElement(By.id("submitEmailButton"));
			 submitEmail.click();
			 Thread.sleep(4000);
		// no email available 
			 List<WebElement> emailUnavailbleElement = driver.findElements(By.id("email-not-available"));
			 if(emailUnavailbleElement.size()>0) {
				// validation of check  the email page
				 WebElement checkTheEmailPageElement = driver.findElement(By.xpath("//div[@class='check-email']")); 
				 String expectedcheckTheEmailText= checkTheEmailPageElement.getText();
				 logger.info(expectedcheckTheEmailText);
				 String actualcheckTheEmailText="Please Check your email";
				 
				 if(expectedcheckTheEmailText.equals(actualcheckTheEmailText)) {
					 test.pass("Successfully naviagted to check the email page and mail is sent");
					 logger.info("Successfully naviagted to check the email page and mail is sent");
				 }else {
					 test.fail("Not naviagted to check the email page");
					 logger.info("Not naviagted to check the email page");
				 }
			 }else { 
				 WebElement emailUnavailble = driver.findElement(By.id("email-not-available"));
				 if(emailUnavailble.isDisplayed()) {			
						 test.pass("This message is displayed ,when no account is created with that mail We apologize. We were not able to locate an account using the email address you provided. Please try again or create a new account.");
						 logger.info("This message is displayed ,when no account is created with that mail We apologize. We were not able to locate an account using the email address you provided. Please try again or create a new account.");
					 }else {
						 test.fail("This message is not  displayed ,when no account is created with that mail We apologize. We were not able to locate an account using the email address you provided. Please try again or create a new account.");
						 logger.info("This message is not  displayed ,when no account is created with that mail We apologize. We were not able to locate an account using the email address you provided. Please try again or create a new account.");				
				 }
			 }	
       }
	}
	
	public void negativeEmailValidation() {
		
		// submit request	 
			 WebElement submitEmail = driver.findElement(By.id("submitEmailButton"));
			 submitEmail.submit();
			
			 WebElement emailError= driver.findElement(By.xpath("//div[contains(text(),'This field is required')]")); 
			 boolean errorDisplayed= emailError.isDisplayed();
			 if(errorDisplayed) {
				 test.pass("Error message is displayed when no email is entered");
				 logger.info("Error message is displayed when no email is entered");
			 }else {
				 test.fail("Error message is displayed when no email is entered");
				 logger.info("Error message is displayed when no email is entered");
			 }
			 
	}
}
