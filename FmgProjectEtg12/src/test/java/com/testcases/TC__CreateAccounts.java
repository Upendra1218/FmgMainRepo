package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.PageObjects.CreateAccount;
import com.PageObjects.loginPage;
import com.github.javafaker.Faker;

public class TC__CreateAccounts extends baseClass{
	@Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
	public void createAccountWithValidCredientials() throws InterruptedException {
        test.info("Verifying that Create account");
        Faker faker = new Faker();
        if(isBrowserLaunched){
        	
        	loginPage lp = new loginPage(driver);        
	        
	        lp.hoverOnCreateloginAcc(driver);
		    logger.info("clicked on sign in");
		    
	        CreateAccount createAcc= new CreateAccount(driver);
	        
			createAcc.clickOnCreateAcc(driver);		
			logger.info("Clicked on create Account");

		test.info("Verify that details for creating account");	
		createAcc.enterFirstName(faker.name().firstName());					
		logger.info("Entered first Name");
		test.pass("Entered first Name");
		
		createAcc.enterLastName(faker.name().lastName());					
		logger.info("Entered lastName");
		test.pass("Entered last Name");
		
		int minLength = 10;
        int maxLength = 25;
        int phoneNumberLength = faker.random().nextInt(minLength, maxLength + 1);
        String fakePhoneNumber = faker.number().digits(phoneNumberLength);
		createAcc.enterPhone(fakePhoneNumber);					
		logger.info("Entered phonenumber");
		test.pass("Entered phonenumber");
		
		
		String firstName = faker.name().firstName();
        String email = firstName+ "@etg.digital"; // Change suffix as needed
        System.out.println("Email id is " + email);
		createAcc.enterEmail(email);					
		logger.info("Enter email");
		test.pass("Entered email");
		
								      
		
		CreateAccount.enterPassword("Akhireddy@07");					
		logger.info("Entered password");
		test.pass("Entered password");
		
		createAcc.enterConfirmPassword("Akhireddy@07");					
		logger.info("Confirmed password");
		test.pass("Entered password");
		
		createAcc.clickCreateAccountButton(driver);		
		logger.info("Clicked on create account");
		Thread.sleep(10000);

        }
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
